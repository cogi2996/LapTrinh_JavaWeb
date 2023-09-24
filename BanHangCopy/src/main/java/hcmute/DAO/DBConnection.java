package hcmute.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/sinhvien";
	private static String USER_NAME = "root";
	private static String PASSWORD = "29092003";

	private static Connection con;

	public static Connection getConnection() {
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException ex) {
			System.out.println("false");
		}
		return con;

	}

	public static void main(String[] args) throws SQLException {
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from category");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + rs.getString(3));
			}
			conn.close();
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

	}
}
