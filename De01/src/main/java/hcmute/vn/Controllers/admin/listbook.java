package hcmute.vn.Controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Dao.IBookDao;
import hcmute.vn.Model.Book;
import hcmute.vn.Dao.BookDaoImpl;
@WebServlet(urlPatterns = "/admin-listbook")
public class listbook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IBookDao bookDao = new BookDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> listbook = bookDao.findAll();
		req.setAttribute("listbook", listbook);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listbook.jsp");
		rd.forward(req, resp);
	}
}
