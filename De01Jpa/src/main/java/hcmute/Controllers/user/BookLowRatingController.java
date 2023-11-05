package hcmute.Controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Model.BookRating;
import hcmute.Service.BookServiceimpl;
import hcmute.Service.IBookService;

@WebServlet(urlPatterns = "/rating-low")
public class BookLowRatingController extends HttpServlet {
	IBookService bookService = new BookServiceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexPage = req.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		Long countP = bookService.countAll();
		// chia trang cho count
		Long endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		List<BookRating> books = bookService.findAll_DESC();
		System.out.println(books);
		req.setAttribute("books", books);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.getRequestDispatcher("/views/user/book-rating.jsp").forward(req, resp);
	}
}
