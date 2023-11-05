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
@WebServlet(urlPatterns = "/authorBook")
public class AuthorBook extends HttpServlet{
	IAuthorDao authorService = new AuthorDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("id")!=null) {
			int authorid = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("listBook",authorService.findBookByAuthorId(authorid) );
		}
		
		req.setAttribute("listAuthor",authorService.findAll() );
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/authorBook.jsp");
        rd.forward(req, resp);
		
	}

}
