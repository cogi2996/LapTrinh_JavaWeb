package hcmute.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.DAO.iCategoryDAO;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
@WebServlet(urlPatterns = {"/category/delete"})
public class CategoryDeleteController extends HttpServlet{
		ICategoryService cateService = new CategoryServiceImpl();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			int cateID = Integer.parseInt(req.getParameter("id"));
			cateService.delete(cateID);
			resp.sendRedirect("/BanHang/category/listcate");
		}
		
}
