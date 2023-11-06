package hcmute.Controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Model.Book_21110709;
import hcmute.Service.BookServiceImpl_21110709;
import hcmute.Service.IBookService_21110709;

@WebServlet(urlPatterns = "/add")
public class listBook_21110709 extends HttpServlet {
	IBookService_21110709 bookService = new BookServiceImpl_21110709();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book_21110709> list = bookService.findAll();
		req.setAttribute("listBook", list);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/listBook.jsp");
		rd.forward(req, resp);
	}
}
