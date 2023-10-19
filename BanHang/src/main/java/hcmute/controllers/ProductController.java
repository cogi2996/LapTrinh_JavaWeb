package hcmute.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.DAO.IProductDAO;
import hcmute.DAO.ProductDAOImpl;
import hcmute.models.CategoryModel;
import hcmute.models.ProductModel;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
import hcmute.services.IProductService;
import hcmute.services.ProductServiceImpl;

@WebServlet(urlPatterns = {"/findprobycate","/admin-insertpro"})
public class ProductController extends HttpServlet {
	IProductService productService  = new ProductServiceImpl();
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
	}
	
}
