package hcmute.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModel;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;

@WebServlet(urlPatterns = {"/category/edit"})
public class CategoryEditController extends HttpServlet{	
	ICategoryService cateService = new CategoryServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao ra new model 
		int cateID = Integer.parseInt(req.getParameter("NewCateID"));
		String NewCateName = req.getParameter("NewCateName");
		String NewCateImg =  req.getParameter("NewImages");
		CategoryModel NewCate = new CategoryModel(cateID,NewCateName,NewCateImg);
		// use edit new model
		cateService.edit(NewCate);
		System.out.println("EDIT COMPLETED");
		resp.sendRedirect("/BanHang/category/listcate");
		
	}
}
