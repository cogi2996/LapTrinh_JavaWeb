package hcmute.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.Model.Author_21110709;
import hcmute.Model.AuthorBook_21110709;
import hcmute.Model.Book_21110709;

public class AuthorDaoImpl_21110709 implements IAuthorDao_21110709 {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(Author_21110709 author) {
		String sql = "INSERT INTO authors (author_name, date_of_birth) VALUES (?, ?)";
		try {
			conn = new DBConnection().getConnection(); // Obtain your database connection
			ps = conn.prepareStatement(sql); // Prepare your SQL statement
			ps.setString(1, author.getAuthor_name()); // Set author_name
			ps.setDate(2, author.getDate_of_birth()); // Set date_of_birth
			ps.executeUpdate(); // Execute the update
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Author_21110709 author) {
		String sql = "UPDATE authors SET author_name = ?, date_of_birth = ? WHERE author_id = ?";
		try {
			conn = new DBConnection().getConnection(); // Obtain your database connection
			ps = conn.prepareStatement(sql); // Prepare your SQL statement
			ps.setString(1, author.getAuthor_name()); // Set author_name
			ps.setDate(2, author.getDate_of_birth()); // Set date_of_birth
			ps.setInt(3, author.getAuthor_id()); // Set author_id for WHERE clause
			ps.executeUpdate(); // Execute the update
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int author_id) {
		String sql = "DELETE FROM authors WHERE author_id = ?";
		try {
			conn = new DBConnection().getConnection(); // Obtain your database connection
			ps = conn.prepareStatement(sql); // Prepare your SQL statement
			ps.setInt(1, author_id); // Set the author_id for the WHERE clause
			int rowsAffected = ps.executeUpdate(); // Execute the update

			if (rowsAffected == 0) {
				// Handle the case where the author does not exist
				throw new Exception("Không tìm thấy");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Author_21110709> paginationPage(int index, int numberOfPage) {
		List<Author_21110709> result = new ArrayList<>();
		String sql = "SELECT * FROM authors ORDER BY author_id LIMIT ? OFFSET ?";

		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			// Set parameters for LIMIT and OFFSET
			ps.setInt(1, numberOfPage);
			ps.setInt(2, index * numberOfPage); // Calculate the offset
			rs = ps.executeQuery();

			while (rs.next()) {
				Author_21110709 author = new Author_21110709();
				author.setAuthor_id(rs.getInt("author_id"));
				author.setAuthor_name(rs.getString("author_name"));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
				result.add(author);

				// If you want to log each author
				System.out.println("Author in paginationPage: " + author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// If you want to log the end of pagination
		System.out.println("End pagination for authors");
		return result;
	}

	@Override
	public Long countAll() {
		String sql = "SELECT COUNT(*) FROM authors";
		Long count = 0L;
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getLong(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public Author_21110709 findOne(int author_id) {
		String sql = "SELECT * FROM authors WHERE author_id = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Author_21110709 author = new Author_21110709();
				author.setAuthor_id(rs.getInt("author_id"));
				author.setAuthor_name(rs.getString("author_name"));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
				return author;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book_21110709> findBookByAuthorId(int author_id) {
		String sql = "SELECT\r\n" + "  books.bookid\r\n" + "FROM\r\n" + "  books\r\n" + "JOIN\r\n"
				+ "  book_authors\r\n" + "ON\r\n" + "  books.bookid = book_authors.bookid\r\n" + "WHERE\r\n"
				+ "  book_authors.author_id = ?;";
		List<Book_21110709> list = new ArrayList<Book_21110709>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Book_21110709 book = new Book_21110709();
				book.setBookid(rs.getInt("bookid"));
				list.add(book);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

	@Override
	public List<Author_21110709> findAll() {
		String sql = "SELECT * FROM authors";
		List<Author_21110709> authors = new ArrayList<Author_21110709>();
		try {
			conn = new DBConnection().getConnection(); // Establish the database connection
			ps = conn.prepareStatement(sql); // Prepare the SQL statement
			rs = ps.executeQuery(); // Execute the query

			while (rs.next()) {
				Author_21110709 author = new Author_21110709();
				author.setAuthor_id(rs.getInt("author_id")); // Get the author_id from the ResultSet
				author.setAuthor_name(rs.getString("author_name")); // Get the author_name
				author.setDate_of_birth(rs.getDate("date_of_birth")); // Get the date_of_birth
				authors.add(author); // Add the Author object to the list

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authors;
	}

	@Override
	public List<AuthorBook_21110709> NumberOfBook() {
		String sql = "SELECT author_id,COUNT(*) as count FROM book_authors group by author_id";
		List<AuthorBook_21110709> list = new ArrayList<AuthorBook_21110709>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AuthorBook_21110709 authorBook = new AuthorBook_21110709(rs.getInt(1), rs.getInt(2));
				list.add(authorBook);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}
		return list;
	}

}
