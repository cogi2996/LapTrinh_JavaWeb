package hcmute.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.Model.Book_21110709;
import hcmute.Model.User_21110709;

public class BookDaoImpl implements IBookDao_21110709 {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Book_21110709> findAll() {
		String sql = "SELECT \r\n"
				+ " b.bookid,title,isbn,a.author_name,publisher,publish_date,quantity,count(r.userid) review\r\n"
				+ "FROM \r\n" + "  books b\r\n" + "inner JOIN \r\n" + "  book_authors ba ON b.bookid = ba.bookid\r\n"
				+ "inner JOIN \r\n" + "  authors a ON ba.author_id = a.author_id\r\n"
				+ "inner join ratings r on b.bookid = r.bookid\r\n"
				+ "group by b.bookid, title,isbn,a.author_name,publisher,publish_date,quantity,r.userid";
		List<Book_21110709> books = new ArrayList();
		try {
			conn = new DBConnection().getConnection(); // Establish the database connection
			ps = conn.prepareStatement(sql); // Prepare the SQL statement
			rs = ps.executeQuery(); // Execute the query

			while (rs.next()) {
				Book_21110709 book = new Book_21110709();
				book.setBookid(rs.getInt("bookid"));
				book.setTitle(rs.getString("title"));
				book.setIsbn(rs.getInt("isbn"));
				book.setAuthor(rs.getString("author_name"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setQuantity(rs.getInt("quantity"));
				book.setReview(rs.getInt("review"));
				books.add(book); // Add the book object to the list
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book_21110709 findOne(int bookid) {
		String sql = "SELECT \r\n"
				+ "  b.bookid,title,isbn,a.author_name,publisher,publish_date,quantity,count(r.userid) review\r\n" + "FROM \r\n"
				+ "  books b\r\n" + "inner JOIN \r\n" + "  book_authors ba ON b.bookid = ba.bookid\r\n"
				+ "inner JOIN \r\n" + "  authors a ON ba.author_id = a.author_id\r\n"
				+ "inner join ratings r on b.bookid = r.bookid\r\n" + "where b.bookid = ?\r\n"
				+ "group by title,isbn,a.author_name,publisher,publish_date,quantity,r.userid";
		try {
			conn = new DBConnection().getConnection(); // Establish the database connection
			ps = conn.prepareStatement(sql); // Prepare the SQL statement
			ps.setInt(1, bookid);
			rs = ps.executeQuery(); // Execute the query

			Book_21110709 book = new Book_21110709();
			while (rs.next()) {
				book.setBookid(rs.getInt("bookid"));
				book.setTitle(rs.getString("title"));
				book.setIsbn(rs.getInt("isbn"));
				book.setAuthor(rs.getString("author_name"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setQuantity(rs.getInt("quantity"));
				book.setReview(rs.getInt("review"));
				return book;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User_21110709> BookReview(int bookid) {
		String sql = "select users.fullname , ratings.review_text\r\n" + "from users,ratings,books\r\n"
				+ "where users.id = ratings.userid and ratings.bookid = books.bookid and books.bookid = ?";
		List<User_21110709> list = new ArrayList();
		try {
			conn = new DBConnection().getConnection(); // Establish the database connection
			ps = conn.prepareStatement(sql); // Prepare the SQL statement
			ps.setInt(1, bookid);
			rs = ps.executeQuery(); // Execute the query

			while (rs.next()) {
				User_21110709 user = new User_21110709();
				user.setFullname(rs.getString(1));
				user.setReview_text(rs.getString(2));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
