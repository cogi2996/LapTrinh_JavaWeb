package hcmute.Controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.Model.Author_21110709;
import hcmute.Service.AuthorService_21110709;
import hcmute.Service.IAuthorService_21110709;

@WebServlet(urlPatterns = "/admin-addAuthor")
public class addAuthor_21110709 extends HttpServlet {
    IAuthorService_21110709 authorService = new AuthorService_21110709();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/add-author.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Author_21110709 model = new Author_21110709();
        try {
            // Lấy dữ liệu từ jsp bằng beanutils
            BeanUtils.populate(model, req.getParameterMap());
            System.out.println("đã tới post update");
            System.out.println("author-dopost được get từ beanutil:" + model);

            // Insert the new Author into the database
            authorService.insert(model);

            // Set success message
            req.setAttribute("author", model);
            req.setAttribute("message", "Add successful");
        } catch (Exception e) {
            e.printStackTrace();

            // Set error message
            req.setAttribute("error", "Add fails");
        }

        // Redirect to the list authors page
        resp.sendRedirect(req.getContextPath() + "/admin-listAuthor");
    }
}