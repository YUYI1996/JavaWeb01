package com.yuyi.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Utils {
//加載配置
	private static DataSource dataSource = new ComboPooledDataSource("yuyi");
	private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = t1.get();
		if (connection == null) {
			connection = dataSource.getConnection();
			t1.set(connection);
		}
		return connection;
	}

//開啓事務
	public static void startTransaction() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.setAutoCommit(false);
		}
	}

//事務回滾
	public static void rockball() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.rollback();
		}
	}

//提交并且關閉資源從ThreadLoacal中釋放
	public static void commitAndRelease() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.commit();//事务提交
			connection.close();//关闭事务
			t1.remove();//从线程绑定中移除
		}
	}
	
	// 关闭资源方法
			public static void closeConnection() throws SQLException {
				Connection con = getConnection();
				if (con != null) {
					con.close();
				}
			}

			public static void closeStatement(Statement st) throws SQLException {
				if (st != null) {
					st.close();
				}
			}

			public static void closeResultSet(ResultSet rs) throws SQLException {
				if (rs != null) {
					rs.close();
				}
			}
}
