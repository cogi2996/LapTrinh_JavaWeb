package hcmute.Controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Entity.Book;
import hcmute.Service.BookServiceimpl;
import hcmute.Service.IBookService;

@WebServlet(urlPatterns = "/admin-listbook")
public class listbook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IBookService bookService = new BookServiceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> listbook = bookService.findAll();
		req.setAttribute("listbook", listbook);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listbook.jsp");
		rd.forward(req, resp);
	}
}
