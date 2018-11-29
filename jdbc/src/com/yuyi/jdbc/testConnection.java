package com.yuyi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnection {

	public static void main(String[] args) throws SQLException {
		//注意：控制事務的connection必須是同一個
		Connection connection = null;
		Connection connection2=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql:///user", "root", "628081");
			connection2=DriverManager.getConnection("jdbc:mysql:///user", "root", "628081");
			connection.setAutoCommit(false);
			statement=connection.createStatement();
			statement.executeUpdate("insert into users values(40,'fd','FD','123456789','fd@qq.com')");
			statement.executeUpdate("insert into users values(41,'df','DF','123456789','df@qq.com')");
		try {
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		} catch (ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}
		
	}
}
