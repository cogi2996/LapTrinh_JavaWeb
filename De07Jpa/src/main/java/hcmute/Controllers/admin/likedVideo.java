package hcmute.Controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Entity.User;
import hcmute.Service.IUserService;
import hcmute.Service.UserServiceImpl;
@WebServlet(urlPatterns = "/likedVideo")
public class likedVideo extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		User user = userService.findOne(username);
		req.setAttribute("user", user);
		req.setAttribute("listVideo", userService.listLikedVideo(username));
		System.out.println("listvideo"+userService.listLikedVideo(username));
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/likedVideo.jsp");
		rd.forward(req, resp);
	}

}
