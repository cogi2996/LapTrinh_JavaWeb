package hcmute.vn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.vn.Model.Author;
import hcmute.vn.Model.Book;

public class AuthorDaoImpl implements IAuthorDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<Author> findAll() {
		String sql = "SELECT * FROM author";
		List<Author> list = new ArrayList<Author>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setAuthor_id(rs.getInt("author_id"));
				author.setAuthor_name(rs.getString("author_name"));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
				list.add(author);
				System.out.println("author in dao impl"+author);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("false");
		}

		return list;
	}

}
