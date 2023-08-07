package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static final String JDBCDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBCURL = "jdbc:mysql://localhost:3306/demoproduct";
	private static final String USERNAME = "binh";
	private static final String PASSWORD = "12345";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBCDRIVER);		// khai báo className cho nó
			connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);	// thực hiện mở kết nối
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		// thục hiện xong sẽ trả về connection
		return connection;
	}
	
	// statement dùng để truy vấn sql tĩnh không thể thay đổi
	// preparedStatement dùng để truy vấn những câu sql dùng setInt( để truyền vào vị trí dấu ? , giá trị muốn truyền );
	// callableStatement dùng để
	
	public static void closeConnection(Connection connection) {
		// thực hiện đóng connection
		if (connection != null) {
			// check xem nó có kết nối không thì đóng nó lại
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
}
