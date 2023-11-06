package hcmute.Controllers.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Dao.AuthorDaoImpl_21110709;
import hcmute.Dao.IAuthorDao_21110709;
@WebServlet(urlPatterns = "/listNumAuthorBook")
public class listNumAuthorBook extends HttpServlet {
	IAuthorDao_21110709 authorService = new AuthorDaoImpl_21110709();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("AuthorBook", authorService.NumberOfBook());
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/listNumAuthorBook.jsp");
        rd.forward(req, resp);
	}
}
