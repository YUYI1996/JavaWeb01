package com.yuyi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yuyi.bean.User;
import com.yuyi.dao.UserDAO;
import com.yuyi.dbutil.DBUtils;

public class UserDAOImpl implements UserDAO {
	DBUtils dbutils = DBUtils.getInstance();

	@Override
	public List<User> findAllUser() {
		String sql = "SELECT * FROM users";
		return dbutils.executeQueryUser(sql, null);
	}

	@Override
	public int addUser(User user) {
		int num = 0;
		String sql = "INSERT INTO users(firstname,lastname,phone,email) VALUES(?,?,?,?)";
		num = dbutils.executeUpdate(sql, user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail());
		return num;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean bn = false;
		String sql = "DELETE FROM users WHERE id=?";
		int num = dbutils.executeUpdate(sql, id);
		if (num > 0) {
			bn = true;
		} else {
			bn = false;
		}
		return false;
	}

	@Override
	public User updateUser(User user) {
		int num=0;
		String sql = "UPDATE users set firstname=?,lastname=?,phone=?,email=? WHERE id=?";
		 num = dbutils.executeUpdate(sql, user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(),
				user.getId());
		 User user2=user;
		return user2;
	}

	@Override
	public List<User> findByPage(int page, int rows) {
		String sql = "SELECT * FROM users limit ?,?";
		int index = (page - 1) * rows;
		return dbutils.executeQueryUser(sql, index, rows);
	}

	@Override
	public int findTotal() {
		String sql = "SELECT COUNT(*) FROM users";
		PreparedStatement ps = null;
		ResultSet resultSet = null;
        Connection con=null;
		try {
			con=dbutils.getConnection();
			ps=con.prepareStatement(sql);
			resultSet=ps.executeQuery();
			if(resultSet.next()){
				int total=resultSet.getInt(1);
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbutils.close(null, ps, resultSet);
		}
		return 0;



	}

	@Override
	public User saveUser(User user) {
		User user2=null;
		UserDAO userDAO=new UserDAOImpl();
		Connection con=null;
        try {
        	con=dbutils.getConnection();
			int result=userDAO.addUser(user);
			if(result>0) {
				user2=user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbutils.close(con, null, null);
		}
		return user2;
	}


}
