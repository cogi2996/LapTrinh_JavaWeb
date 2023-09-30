package hcmute.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.DAO.CategoryDAOImpl;
import hcmute.DAO.DBConnection;
import hcmute.DAO.iCategoryDAO;
import hcmute.models.CategoryModel;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;

@WebServlet(urlPatterns = { "/category/listcate", "/category/add", "/category/findOne", "/category/update","/category/delete" })
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICategoryService categoryService = new CategoryServiceImpl(); // Lấy hàm trong class implement

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURI().toString();

		if (url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addcategory.jsp");
			rd.forward(req, resp);
		} else if (url.contains("listcate")) {
			try {
				findAll(req, resp);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url.contains("update")) {
			System.out.println("find one entry");
			findOne(req, resp);
		}
		else if(url.contains("delete")) {
			this.delete(req, resp);
		}

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			categoryService.delete(id);
			req.setAttribute("message", "Xoa thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.setAttribute("error", "Xoa that bai");
		}
		RequestDispatcher rd = req.getRequestDispatcher("listcate");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURI().toString();
		if (url.contains("add")) {
			try {
				insert(req, resp);
			} catch (IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (url.contains("update")) {
			update(req,resp);
		}

	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		int cateID = Integer.parseInt(req.getParameter("NewCateID"));
		String NewCateName = req.getParameter("NewCateName");
		String NewCateImg =  req.getParameter("NewImages");
		CategoryModel NewCate = new CategoryModel(cateID,NewCateName,NewCateImg);
		// use edit new model
		categoryService.update(NewCate);
		resp.sendRedirect(req.getContextPath() +"/category/listcate");
		
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, SQLException, ServletException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// Nhận dữ liệu từ form
		String cateID = req.getParameter("cateID");
		String cateName = req.getParameter("cateName");
		String image = req.getParameter("images");
		// init model
		CategoryModel model = new CategoryModel();
		model.setCateID(Integer.parseInt(cateID));
		model.setCateName(cateName);
		model.setImages(image);
		// gọi phương thức insert từ service
		categoryService.insert(model);
		// chuyển view về lại list cate
		// resp.sendRedirect(req.getContextPath()+ "/category/listcate");
		this.findAll(req, resp);
	}

	private void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		CategoryModel model = categoryService.findOne(id);
		System.out.println(model);
		req.setAttribute("model", model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/viewEdit.jsp");
		rd.forward(req, resp);
	}

	// hiển thị tất cả dữ liệu của category
	private void findAll(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, SQLException, ServletException {

		// TODO Auto-generated method stub
		List<CategoryModel> list = categoryService.findAll();
		// Xử lí bài toán

		// đẩy dữ liệu ra view
		req.setAttribute("listcate", list);
		// ngoài view sẽ bắt tham số listcate rồi render phần thiếu ra
		// view sẽ lấy dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);

	}

}
