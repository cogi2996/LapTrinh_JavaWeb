package hcmute.Controllers.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Service.BookServiceImpl_21110709;
import hcmute.Service.IBookService_21110709;

@WebServlet(urlPatterns = "/book")
public class Book_21110709 extends HttpServlet {
	IBookService_21110709 bookService = new BookServiceImpl_21110709();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		req.setAttribute("book", bookService.findOne(bookid));
		System.out.println("book da click: " + bookService.findOne(bookid));
		req.setAttribute("listUser", bookService.BookReview(bookid));
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/Book.jsp");
		rd.forward(req, resp);
	}
}
