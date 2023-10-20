package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.models.CategoryModel;
import hcmute.models.ProductModel;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
import hcmute.services.IProductService;
import hcmute.services.ProductServiceImpl;
import hcmute.utils.Constant;
import hcmute.utils.UploadUtils;

@MultipartConfig(fileSizeThreshold = 1024*1024*10,  maxFileSize = 1024*1024*50,maxRequestSize = 1024*1024*50)
@WebServlet(urlPatterns = { "/product/listpro", "/findprobycate", "/admin-insertpro" })
public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IProductService productService = new ProductServiceImpl();
	ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURI().toString();
		if(url.contains("findprobycate"))
		{
			System.out.println("findprobycate accesssed");
			int cateId = Integer.parseInt(req.getParameter("cateid"));
			List<ProductModel> list = productService.findProductByCateId(cateId);
			System.out.println("product in list: "+list.get(0));
			req.setAttribute("listPro", list);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/listproduct.jsp");
			rd.forward(req, resp);
		}	
		else if(url.contains("admin-insertpro")) {
			List<CategoryModel> listcate = cateService.findAll();
			req.setAttribute("listcate", listcate);
			RequestDispatcher rd = req.getRequestDispatcher("/views/product/addproduct.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("listpro")) {
			this.findAll(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if(url.contains("admin-insertpro")) {
			this.insert(req,resp);
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		ProductModel model = new ProductModel();
		try {
			// Lấy dữ liệu từ jsp bằng beanutils
			BeanUtils.populate(model, req.getParameterMap());
			System.out.println("model được get từ beanutil:"+model);
			// xử lí trường hợp images
			if(req.getPart("imageLink").getSize()!=0)
			{
				String fileName = "" + System.currentTimeMillis();
				// truyền vào url thư mục (path), file name, req và tên file mới
				model.setProImg(UploadUtils.processUpload("imageLink",req,Constant.DIR + "\\products\\",fileName));
			}
			model.setCategory(cateService.findOne(model.getCateID()));
			productService.insert(model);
			// thong bao 
			req.setAttribute("product", model);
			req.setAttribute("message", "Add successfull");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Add fails");
		}
		resp.sendRedirect(req.getContextPath()+"/product/listpro");
	}

	void findAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> listpro = productService.findAll();
		req.setAttribute("listPro", listpro);
		RequestDispatcher rd = req.getRequestDispatcher("/views/product/listproduct.jsp");
		rd.forward(req, resp);
		
	}
}
