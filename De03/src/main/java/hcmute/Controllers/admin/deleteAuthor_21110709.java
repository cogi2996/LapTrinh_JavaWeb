package hcmute.Controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.Service.IAuthorService_21110709;
import hcmute.Service.AuthorService_21110709; // Thay IUserService bằng IAuthorService

@WebServlet(urlPatterns = "/admin-deleteAuthor")
public class deleteAuthor_21110709 extends HttpServlet {
    IAuthorService_21110709 authorService = new AuthorService_21110709(); // Thay userService bằng authorService

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int author_id = Integer.parseInt(req.getParameter("author_id")); // Thay id bằng author_id
        authorService.delete(author_id); // Thay delete(id) bằng delete(author_id)
        resp.sendRedirect(req.getContextPath() + "/admin-listAuthor"); // Thay "/admin-listUser" bằng "/admin-listAuthor"
    }
}
