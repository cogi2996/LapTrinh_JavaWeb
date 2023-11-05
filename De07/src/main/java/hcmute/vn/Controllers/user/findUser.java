package hcmute.vn.Controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Model.User;
import hcmute.vn.Service.IUserService;
import hcmute.vn.Service.UserServiceImpl;

@WebServlet(urlPatterns = "/findUser")
public class findUser extends HttpServlet{
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/findUser.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String inputFind = req.getParameter("inputFind");
		System.out.println("start find user:"+ inputFind);
		List<User> listUser = userService.findUserByNameOrEmail(inputFind);
		System.out.println("list user : "+ listUser);
		System.out.println("end find user");
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("/views/user/findUser.jsp").forward(req, resp);
	}
}
