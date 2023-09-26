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

@WebServlet(urlPatterns = { "/category/listcate","/category/findOne"})
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
		
		System.out.println("here 1 "+url);
		if(url.contains("findOne")) {
			findOne(req,resp);
		}
	
		try {
			findAll(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		List<CategoryModel> list =categoryService.findAll();
		// Xử lí bài toán
		
		// đẩy dữ liệu ra view
		req.setAttribute("listcate", list);
		// ngoài view sẽ bắt tham số listcate rồi render phần thiếu ra
		// view sẽ lấy dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);

	}

}
