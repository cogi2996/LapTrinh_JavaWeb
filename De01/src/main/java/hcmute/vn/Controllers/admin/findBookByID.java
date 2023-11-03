package hcmute.vn.Controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Dao.BookDaoImpl;
import hcmute.vn.Dao.IBookDao;
import hcmute.vn.Model.Book;
import hcmute.vn.Service.BookServiceimpl;
import hcmute.vn.Service.IBookService;
@WebServlet(urlPatterns = "/admin-findByBookID")
public class findBookByID extends HttpServlet {
	IBookService bookService = new BookServiceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bookid"));
		Book book = bookService.findOne(id);
		req.setAttribute("book",book );
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/book.jsp");
		rd.forward(req, resp);
	}
}
