package hcmute.Controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.Entity.User;
import hcmute.Service.IUserService;
import hcmute.Service.UserServiceImpl;
import hcmute.Utils.Constant;
import hcmute.Utils.UploadUtils;
@MultipartConfig(fileSizeThreshold = 1024*1024*10,  maxFileSize = 1024*1024*50,maxRequestSize = 1024*1024*50)
@WebServlet(urlPatterns = "/admin-updateUser")
public class updateUser extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.findOne(id);
		req.setAttribute("user",user );
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/edit-user.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		User model = new User();
		try {
			// Lấy dữ liệu từ jsp bằng beanutils
			BeanUtils.populate(model, req.getParameterMap());
			System.out.println("post update");
			System.out.println("beanutil:"+model);
		
			userService.update(model);
			// thong bao 
			req.setAttribute("message", "Add successfull");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Add fails");
		}
		resp.sendRedirect(req.getContextPath()+"/admin-listUser");
	}
}

