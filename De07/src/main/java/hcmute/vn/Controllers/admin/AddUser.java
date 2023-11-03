package hcmute.vn.Controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024* 50)
@WebServlet(urlPatterns = "/admin-addUser")
public class AddUser extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/add-user.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		User model = new User();
		try {
			// Lấy dữ liệu từ JSP bằng BeanUtils
			BeanUtils.populate(model, req.getParameterMap());
			System.out.println("user dopost: " + model);
			System.out.println("username : "+req.getParameter("Username"));

			if (req.getPart("image").getSize() != 0) {
				String fileName = "" + System.currentTimeMillis();
				// Xử lý tải lên ảnh và cập nhật trường Images trong User
				model.setImages(UploadUtils.processUpload("image", req, Constant.DIR + "\\users\\", fileName));
			}

			// Thêm user vào CSDL
			userService.insert(model);

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