package hcmute.vn.Controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.vn.Model.User;
import hcmute.vn.Service.IUserService;
import hcmute.vn.Service.UserServiceImpl;
import hcmute.vn.utils.Constant;
import hcmute.vn.utils.UploadUtils;
@WebServlet(urlPatterns = "/admin-UpdateUser")
public class UpdateUser extends HttpServlet{
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("username");
		User user = userService.findOne(username);
		req.setAttribute("user",user );
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/update-user.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			User model = new User();
			BeanUtils.populate(model, req.getParameterMap());
			System.out.println("user dopost: " + model);
			System.out.println("username : "+req.getParameter("Username"));
			System.out.println("Password : "+req.getParameter("Password"));
			System.out.println("Phone : "+req.getParameter("Phone"));
			System.out.println("Fullname : "+req.getParameter("Fullname"));
			System.out.println("Email : "+req.getParameter("Email"));
			if (req.getPart("imageLink").getSize() != 0) {
				String fileName = "" + System.currentTimeMillis();
				// Xử lý tải lên ảnh và cập nhật trường Images trong User
				model.setImages(UploadUtils.processUpload("image", req, Constant.DIR + "\\users\\", fileName));
			}

			// Thêm user vào CSDL
			userService.update(model);

			// Thông báo thành công
			req.setAttribute("user", model);
			req.setAttribute("message", "Thêm thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thêm thất bại");
		}

		// Chuyển hướng đến trang danh sách người dùng sau khi thêm
		resp.sendRedirect(req.getContextPath() + "/admin-listUser");
	}
}
