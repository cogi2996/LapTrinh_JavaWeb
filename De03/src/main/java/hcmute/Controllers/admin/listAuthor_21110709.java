package hcmute.Controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Dao.AuthorDaoImpl_21110709;
import hcmute.Dao.IAuthorDao_21110709;
import hcmute.Model.Author_21110709;
@WebServlet(urlPatterns = "/admin-listAuthor")
public class listAuthor_21110709 extends HttpServlet{
	IAuthorDao_21110709 authorService = new AuthorDaoImpl_21110709();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexPage = req.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		Long countP = authorService.countAll();
		// chia trang cho count
		Long endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		List<Author_21110709> authors = authorService.paginationPage(indexp - 1, 3);
		System.out.println(authors);
		req.setAttribute("listAuthor", authors);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.getRequestDispatcher("/views/admin/listAuthor.jsp").forward(req, resp);
	}
}

