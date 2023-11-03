package hcmute.vn.Controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.Model.Book;
import hcmute.vn.Service.BookServiceimpl;
import hcmute.vn.Service.IBookService;
import hcmute.vn.utils.Constant;
import hcmute.vn.utils.UploadUtils;
@MultipartConfig(fileSizeThreshold = 1024*1024*10,  maxFileSize = 1024*1024*50,maxRequestSize = 1024*1024*50)
@WebServlet(urlPatterns = "/admin-addBook")
public class AddBook extends HttpServlet{
	IBookService bookService = new BookServiceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/add-book.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Book model = new Book();
		try {
			// Lấy dữ liệu từ jsp bằng beanutils
			BeanUtils.populate(model, req.getParameterMap());
			System.out.println("đã tới post update");
			System.out.println("book-dopost được get từ beanutil:"+model);
			if(req.getPart("image").getSize()!=0)
			{
				String fileName = "" + System.currentTimeMillis();
				model.setCover_image(UploadUtils.processUpload("image",req,Constant.DIR + "\\products\\",fileName));
			}
//			model.setCategory(cateService.findOne(model.getCateID()));
			bookService.insert(model);
			// thong bao 
			req.setAttribute("product", model);
			req.setAttribute("message", "Add successfull");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Add fails");
		}
		resp.sendRedirect(req.getContextPath()+"/admin-listbook");
	}
}
