package hcmute.Controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Service.BookServiceimpl;
import hcmute.Service.IBookService;

@WebServlet(urlPatterns = "/admin-DeleteByBookID")
public class DeleteBook extends HttpServlet{
	IBookService bookService = new BookServiceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bookid"));
		bookService.delete(id);
		resp.sendRedirect(req.getContextPath()+"/admin-listbook");
	}
}
