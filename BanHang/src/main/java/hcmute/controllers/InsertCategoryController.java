package hcmute.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModel;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
@WebServlet(urlPatterns = { "/addcate" })
public class InsertCategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICategoryService categoryService = new CategoryServiceImpl();
	// Lấy form insert
	// từ form --> action post
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/addcategory.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// mã hoá utf-8
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
		System.out.println(model);
		// gọi phương thức insert từ service
		categoryService.insert(model);
		// chuyển view
		resp.sendRedirect("/BanHang/category/listcate");
	}
}
