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
import hcmute.Entity.Author;
import hcmute.Service.IAuthorService;
import hcmute.Service.AuthorService;
import hcmute.Utils.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = "/admin-updateAuthor")
public class updateAuthor extends HttpServlet {
    IAuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.parseInt(req.getParameter("author_id"));
        Author author = authorService.findOne(authorId);
        req.setAttribute("author", author);
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/edit-author.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Author model = new Author();
        try {
            // Lấy dữ liệu từ jsp bằng BeanUtils
            BeanUtils.populate(model, req.getParameterMap());
            authorService.update(model);
            // Thông báo thành công
            req.setAttribute("message", "Update successful");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Update failed");
        }
        resp.sendRedirect(req.getContextPath() + "/admin-listAuthor");
    }
}
