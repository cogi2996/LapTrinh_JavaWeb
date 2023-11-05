package hcmute.vn.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hcmute.vn.Model.Favorites;
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

	@Override
	public void detete(String username) {
		String sql = "DELETE FROM Users WHERE Username = ?;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Users " + "SET Password = ?, Phone = ?, Fullname = ?, Email = ?, Images = ? "
				+ "WHERE Username = ?;";
		try {
			conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getUsername());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User findOne(String username) {
		String sql = "SELECT * FROM Users WHERE Username = ?";
		User model = new User();
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Chuẩn bị câu truy vấn
			// Truyền tham số vào truy vấn
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.setUsername(rs.getString("Username"));
				model.setPassword(rs.getString("Password"));
				model.setPhone(rs.getString("Phone"));
				model.setFullname(rs.getString("Fullname"));
				model.setEmail(rs.getString("Email"));
				model.setImages(rs.getString("Images"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(); // In ra mã đỏ báo lỗi
		}
		return model;
	}

	@Override
	public List<Favorites> findFavorByUsername(String username) {
		String sql = "SELECT * FROM Favorites WHERE Username = ?";
		List<Favorites> list = new ArrayList<Favorites>();
		Favorites model;
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql); // Chuẩn bị câu truy vấn
			// Truyền tham số vào truy vấn
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				model = new Favorites();
				model.setFavoriteID(rs.getInt("FavoriteID"));
				model.setLikedDate(rs.getDate("LikedDate"));
				model.setVideoId(rs.getInt("VideoId"));
				model.setUsername(rs.getString("Username"));
				list.add(model);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	@Override
	public List<User> findUserByNameOrEmail(String input) {
		String sql = "select * from users where fullname = ? or email =?;";
		List<User> list = new ArrayList<User>();
		User model = new User();
		try {
			conn = new DBConnection().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql); // Chuẩn bị câu truy vấn
			// Truyền tham số vào truy vấn
			ps.setString(1, input);
			ps.setString(2, input);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.setUsername(rs.getString("Username"));
				model.setPassword(rs.getString("Password"));
				model.setPhone(rs.getString("Phone"));
				model.setFullname(rs.getString("Fullname"));
				model.setEmail(rs.getString("Email"));
				model.setImages(rs.getString("Images"));
				list.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace(); // In ra mã đỏ báo lỗi
		}
		return list;
	}

}
