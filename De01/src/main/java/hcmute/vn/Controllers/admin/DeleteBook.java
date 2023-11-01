package hcmute.vn.Controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Dao.BookDaoImpl;
import hcmute.vn.Dao.IBookDao;
@WebServlet(urlPatterns = "/admin-DeleteByBookID")
public class DeleteBook extends HttpServlet{
	IBookDao bookDao = new BookDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bookid"));
		bookDao.delete(id);
		resp.sendRedirect(req.getContextPath()+"/admin-listbook");
	}
}
