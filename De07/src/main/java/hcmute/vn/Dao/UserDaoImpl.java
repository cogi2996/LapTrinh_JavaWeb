package hcmute.vn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.vn.Model.User;

public class UserDaoImpl implements IUserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<User> paginationUser(int index, int numberOfPage) {
		List<User> result = new ArrayList<User>();
		String sql = "SELECT * FROM users\r\n" + "LIMIT ? OFFSET ?;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, numberOfPage);
			ps.setInt(2, index * numberOfPage);

			rs = ps.executeQuery();
			User user;
			while (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setPhone(rs.getString("Phone"));
				user.setFullname(rs.getString("Fullname"));
				user.setEmail(rs.getString("Email"));
				result.add(user);
//				System.out.println("User in paginationUser: " + user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("End paginationUser");
		return result;
	}

	@Override
	public int countAll() {
		String sql = "select count(*) from users";
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
	public void insert(User user) {
		String sql = "INSERT INTO Users (Username, Password, Phone, Fullname, Email, Images) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getImages());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
