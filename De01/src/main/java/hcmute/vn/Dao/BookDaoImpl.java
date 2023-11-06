package hcmute.vn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.vn.Model.Book;

public class BookDaoImpl implements IBookDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Book> findAll() {
		String sql = "select * from books";
		List<Book> list = new ArrayList<Book>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getInt("price"));
				book.setCover_image(rs.getString("cover_image"));
				list.add(book);
				System.out.println(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

	@Override
	public Book findOne(int bookid) {
		String sql = "select * from books where bookid = ?";
		Book model = new Book();
		try {
			conn = new DBConnection().getConnection(); // kết nối csdl
			ps = conn.prepareStatement(sql); // phát biểu câu query
			// truyền tham số vào query
			ps.setInt(1, bookid);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.setBookid(rs.getInt("bookid"));
				model.setIsbn(rs.getInt("isbn"));
				model.setTitle(rs.getString("title"));
				model.setPublisher(rs.getString("publisher"));
				model.setPrice(rs.getInt("price"));
				model.setDescription(rs.getString("description"));
				model.setPublish_date(rs.getDate("publish_date"));
				model.setCover_image(rs.getString("cover_image"));
				model.setQuantity(rs.getInt("quantity"));
			}
			System.out.println("chi tiet model: " + model);
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); // in ra mã đỏ bị sai
		}
		return model;
	}

	@Override
	public void update(Book book) {
		String sql = "UPDATE books\r\n" + "SET\r\n" + "  title = ?,\r\n" + "  publisher = ?,\r\n" + "  price = ?,\r\n"
				+ "  description = ?,\r\n" + "  publish_date = ?,\r\n" + "  cover_image = ?,\r\n" + "  quantity = ?\r\n"
				+ "WHERE bookid = ?;\r\n" + "";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getPublisher());
			ps.setInt(3, book.getPrice());
			ps.setString(4, book.getDescription());
			ps.setDate(5, book.getPublish_date());
			ps.setString(6, book.getCover_image());
			ps.setInt(7, book.getQuantity());
			ps.setInt(8, book.getBookid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int bookid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "delete from books" + " where bookid  = ?;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int countAll() {
		String sql = "select count(*) from books";
		try {
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public List<Book> paginationPage(int index, int numberOfPage) {
		List<Book> result = new ArrayList<Book>();
		String sql = "SELECT * FROM books\r\n" + "ORDER BY bookid\r\n" + "LIMIT ? OFFSET ?;";
		try {
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, numberOfPage);
			ps.setInt(2, index * numberOfPage);
			ResultSet rs = ps.executeQuery();
			Book book;
			while (rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setDescription(rs.getString("description"));
				book.setCover_image(rs.getString("cover_image"));
				book.setPrice(rs.getInt("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setIsbn(rs.getInt("isbn"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setTitle(rs.getString("title"));
				result.add(book);

				System.out.println("book in paginnationPage" + book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end pagination");
		return result;
	}

	@Override
	public List<Book> findBookByAuthor(int author_id) {
		String sql = "SELECT books.*\r\n" + "FROM books\r\n"
				+ "INNER JOIN book_author ON books.bookid = book_author.bookid\r\n"
				+ "WHERE book_author.author_id = ?;";
		List<Book> list = new ArrayList<Book>();

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getInt("price"));
				book.setCover_image(rs.getString("cover_image"));
				list.add(book);
				System.out.println(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

	@Override
	public List<Book> findAll_DESC() {
		String sql = "SELECT books.*,rating.rating\r\n" + "FROM books\r\n"
				+ "Inner JOIN rating ON books.bookid = rating.bookid\r\n" + "GROUP BY books.bookid,rating.rating\r\n"
				+ "ORDER BY AVG(rating.rating) DESC;";
		List<Book> list = new ArrayList<Book>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookid(rs.getInt("bookid"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getInt("price"));
				book.setCover_image(rs.getString("cover_image"));
				book.setRating(rs.getInt("rating"));
				list.add(book);
				System.out.println(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

	@Override
	public void insert(Book book) {
		String sql = "INSERT INTO books (isbn, title, publisher, price, description, publish_date, cover_image, quantity)\r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);\r\n";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getIsbn()); // Change to getIsbn() to set ISBN
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice()); // Use setBigDecimal for DECIMAL
			ps.setString(5, book.getDescription());
			ps.setDate(6, book.getPublish_date());
			ps.setString(7, book.getCover_image());
			ps.setInt(8, book.getQuantity());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
