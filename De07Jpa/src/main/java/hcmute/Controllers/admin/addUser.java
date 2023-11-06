package hcmute.Controllers.admin;

import java.io.IOException;
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

@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50)
@WebServlet(urlPatterns = "/admin-addUser")
public class addUser extends HttpServlet {
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
        User user = new User();
        try {
            // Lấy dữ liệu từ jsp bằng beanutils
            BeanUtils.populate(user, req.getParameterMap());
            System.out.println("user bean: "+ user);
            // Handle file upload for user's image
            if(req.getPart("image").getSize()!=0) {
                String fileName = "" + System.currentTimeMillis();
                user.setImages(UploadUtils.processUpload("image", req, Constant.DIR + "\\users\\", fileName));
            }
            // Insert new user into the database
            userService.insert(user);
            // thong bao 
            req.setAttribute("user", user);
            req.setAttribute("message", "Add successful");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Add fails");
        }
        resp.sendRedirect(req.getContextPath()+"/admin-listUser");
    }
}
