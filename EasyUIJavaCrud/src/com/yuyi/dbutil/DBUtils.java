package com.yuyi.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuyi.bean.User;

public class DBUtils {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "628081";
	private static final String URL = "jdbc:mysql:///user";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private DBUtils() {
		// TODO Auto-generated constructor stub
	}

	private static DBUtils dbUtils = new DBUtils();

	public static DBUtils getInstance() {
		return dbUtils;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public List<User> executeQueryUser(String sql, Object... objects) {
		List<User> list = new ArrayList<User>();
		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			pstat = con.prepareStatement(sql);
			if (objects != null)
				for (int i = 0; i < objects.length; i++) {
					pstat.setObject(i + 1, objects[i]);
				}
			rs = pstat.executeQuery();
			while (rs.next()) {
				Integer id=rs.getInt("id");
				String firstName=rs.getString("firstname");
				String lastName=rs.getString("lastname");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				User user=new User(id, firstName, lastName, phone, email);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstat, rs);
		}
		return list;
	}

	public int executeUpdate(String sql, Object... objects) {
		int num = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					ps.setObject(i + 1, objects[i]);
				}
				num = ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return num;
	}

	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
