package hcmute.Controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Entity.User;
import hcmute.Service.IUserService;
import hcmute.Service.UserServiceImpl;

@WebServlet(urlPatterns = "/admin-listUser")
public class listUser extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexPage = req.getParameter("index");

		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		Long countP = userService.countAll();
		// chia trang cho count
		Long endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		List<User> users = userService.paginationPage(indexp - 1, 3);
		System.out.println(users);
		req.setAttribute("listUser", users);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.getRequestDispatcher("/views/admin/listUser.jsp").forward(req, resp);
	}
}
