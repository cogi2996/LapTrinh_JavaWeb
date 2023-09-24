package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.DAO.CategoryDAOImpl;
import hcmute.DAO.iCategoryDAO;
import hcmute.models.CategoryModel;

@WebServlet(urlPatterns = "/category/listcate")
public class CategoryController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ép categoryDAOIMPL -> iCategoryDao = findAll in categoryDAO được bổ nghĩa
	iCategoryDAO categoryDAO = new  CategoryDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			findAll(req,resp);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		List<CategoryModel> list = categoryDAO.findAll();
		// them list vao request
		req.setAttribute("listcate", list);
		// day du lieu ra view
		try {
			
			RequestDispatcher rq = req.getRequestDispatcher("/views/category/listcategory.jsp");
			rq.forward(req, resp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR\n" + e);
		}
		
	}
}
