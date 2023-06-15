package dev.sakila.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil { //DB 접속 클래스

	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String DB_NAME = "sakila";
	static final String DB_ID = "root";
	static final String DB_PASSWORD = "1234";

	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(DB_URL + DB_NAME, DB_ID, DB_PASSWORD);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
