package hcmute.Controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Service.IUserService;
import hcmute.Service.UserServiceImpl;


@WebServlet(urlPatterns = "/admin-deleteUser")
public class deleteUser extends HttpServlet{
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		userService.delete(id);
		resp.sendRedirect(req.getContextPath()+"/admin-listUser");
	}
}
