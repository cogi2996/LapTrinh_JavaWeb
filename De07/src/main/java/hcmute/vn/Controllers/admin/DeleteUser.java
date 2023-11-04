package hcmute.vn.Controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Service.IUserService;
import hcmute.vn.Service.UserServiceImpl;
@WebServlet(urlPatterns = "/admin-DeleteUser")
public class DeleteUser extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		System.out.println("username: "+username);
		userService.detete(username);
		resp.sendRedirect(req.getContextPath()+"/admin-listUser");
	}
}
