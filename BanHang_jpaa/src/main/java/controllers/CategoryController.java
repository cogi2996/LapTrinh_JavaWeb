package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CategoryDaoImpl;
import entity.Category;
import services.CategoryServiceImpl;
import services.ICategoryService;

@WebServlet(urlPatterns = { "/category/listcate" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			System.out.println("listcase success");
			
			req.getRequestDispatcher("/category/findAll.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("bị lỗi rồi");
		}
		

	}

	
}
