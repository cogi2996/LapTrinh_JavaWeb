package viettel.telecom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hello", "/xin-chao" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 5345916336840194678L;

	@Override
	public void init() throws ServletException {
		System.out.println("Bat dau servlet");
	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("Phuong thuc dang su dung la: " + req.getMethod());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set response content type
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
		PrintWriter wr = resp.getWriter();
		wr.println("<h1>Xin chao cac ban !</h1>");
		wr.close();
	}

	@Override
	public void destroy() {
		System.out.println("Ket thuc servlet");
	}
}
