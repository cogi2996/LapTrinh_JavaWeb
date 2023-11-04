package hcmute.vn.Controllers.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.vn.Model.Favorites;
import hcmute.vn.Model.User;
import hcmute.vn.Service.IUserService;
import hcmute.vn.Service.UserServiceImpl;
@WebServlet(urlPatterns = "/likedVideo")
public class likedVideo extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		List<Favorites> listFavor = userService.findFavorByUsername(username);
		User user = userService.findOne(username);
		req.setAttribute("listFavor", listFavor);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/views/user/liked-video.jsp").forward(req, resp);
		
	}
}
