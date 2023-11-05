package hcmute.Controllers.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Dao.AuthorDaoImpl;
import hcmute.Dao.IAuthorDao;
@WebServlet(urlPatterns = "/listNumAuthorBook")
public class listNumAuthorBook extends HttpServlet {
	IAuthorDao authorService = new AuthorDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("AuthorBook", authorService.NumberOfBook());
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/listNumAuthorBook.jsp");
        rd.forward(req, resp);
	}
}
