package com.spaneos.onlineshopping.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelper {
	public static void close(ResultSet x) {
		if (x != null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void close(Statement x) {
		if (x != null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void close(Connection x) {
		if (x != null)
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static Connection getConnection() throws InstantiationException, IllegalAccessException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/pushpankar", "root", "123");
			System.out.println("connection established");
		} catch (Exception e) {
			System.out.println("connection not established");
			e.printStackTrace();
		}

		return con;

	}
}