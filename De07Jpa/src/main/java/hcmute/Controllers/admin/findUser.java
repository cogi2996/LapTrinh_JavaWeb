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

@WebServlet(urlPatterns = "/findUser")
public class findUser extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("inputFind")!=null) {
			String input = req.getParameter("inputFind");
			System.out.println("input"+ input);
			List<User> list = userService.findUser(input);
			System.out.println("listuser: "+list);
			req.setAttribute("listUser", list);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/find-user.jsp");
		rd.forward(req, resp);
	}
}
