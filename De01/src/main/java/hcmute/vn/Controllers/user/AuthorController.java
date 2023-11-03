package hcmute.vn.Controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Model.Author;
import hcmute.vn.Model.Book;
import hcmute.vn.Service.AuthorSeriveImpl;
import hcmute.vn.Service.BookServiceimpl;
import hcmute.vn.Service.IAuthorService;
import hcmute.vn.Service.IBookService;
@WebServlet(urlPatterns = "/author")
public class AuthorController extends HttpServlet {
	IBookService bookService = new BookServiceimpl();
	IAuthorService authorService = new AuthorSeriveImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexPage = req.getParameter("index");
		int author_id  = Integer.parseInt(req.getParameter("id"));
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		int countP = bookService.countAll();
		// chia trang cho count
		int endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		
		List<Book> books = bookService.findBookByAuthor(author_id);
		List<Author> authors = authorService.findAll();
		System.out.println(books);
		req.setAttribute("books", books);
		req.setAttribute("authors", authors);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.getRequestDispatcher("/views/user/product-list.jsp").forward(req, resp);
	}
}
