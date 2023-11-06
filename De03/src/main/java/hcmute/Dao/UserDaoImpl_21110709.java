package hcmute.Dao;

import hcmute.Model.User_21110709;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl_21110709 implements IUserDao_21110709 {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public void insert(User_21110709 user) {
		String sql = "INSERT INTO users (email, fullname, phone, passwd, signup_date, last_login, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFullname());
			ps.setInt(3, user.getPhone());
			ps.setString(4, user.getPasswd());
			ps.setDate(5, new java.sql.Date(user.getSignup_date().getTime()));
			ps.setDate(6, new java.sql.Date(user.getLast_login().getTime()));
			ps.setBoolean(7, user.isIs_admin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(User_21110709 user) {
		String sql = "UPDATE users SET email = ?, fullname = ?, phone = ?, passwd = ?, signup_date = ?, last_login = ?, is_admin = ? WHERE id = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getFullname());
			ps.setInt(3, user.getPhone());
			ps.setString(4, user.getPasswd());
			ps.setDate(5, new java.sql.Date(user.getSignup_date().getTime()));
			ps.setDate(6, new java.sql.Date(user.getLast_login().getTime()));
			ps.setBoolean(7, user.isIs_admin());
			ps.setInt(8, user.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int userid) {
		String sql = "DELETE FROM users WHERE id = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<User_21110709> paginationPage(int index, int numberOfPage) {
		String sql = "SELECT * FROM users LIMIT ?, ?";
		List<User_21110709> users = new ArrayList<User_21110709>();
		return null;
	}

	@Override
	public Long countAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User_21110709 findOne(int userid) {
		// TODO Auto-generated method stub
		return null;
	}
}
