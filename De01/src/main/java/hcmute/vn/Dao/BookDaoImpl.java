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

}
