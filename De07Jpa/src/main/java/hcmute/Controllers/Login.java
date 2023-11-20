package hcmute.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.Entity.User;
import hcmute.Service.IUserService;
import hcmute.Service.UserServiceImpl;

@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/views/DangNhap.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userService.findOne(username);
		if (password.equals(user.getPassword())) {
			System.out.println("dang nhap thanh cong");
			// khởi tạo session
			HttpSession s = req.getSession();
			// thiết lập thời gian tồn tại session
			s.setMaxInactiveInterval(60 * 60 * 24);
			Cookie userCookies = new Cookie("username", username);
			userCookies.setMaxAge(60 * 60 * 24);
			resp.addCookie(userCookies);
			// time to live
			// add obj cookies into response
			resp.setCharacterEncoding("UTF-8");
			resp.sendRedirect(req.getContextPath() + "/admin-listUser");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/views/DangNhap.jsp");
		}

	}
}
