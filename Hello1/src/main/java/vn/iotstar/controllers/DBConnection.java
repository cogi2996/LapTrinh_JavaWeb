package vn.iotstar.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/sinhvien";
	private static String USER_NAME = "root";
	private static String PASSWORD = "29092003";
	private static Connection con;

	public static Connection getConnection() throws IOException {
		con = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection)DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
		} catch (SQLException ex ) {
			// TODO: handle exception
		}
		return (con);
	}
	public static void main(String[] args) {
		try {
			Connection c = getConnection();
			System.out.println(DBConnection.getConnection());
			if(c == null)
			{
				System.out.println("something wrong");
			}
			else
			{
				System.out.println("ok");
			}
		} catch ( Exception e) {
			// TODO: handle exception
		}
	}
}
