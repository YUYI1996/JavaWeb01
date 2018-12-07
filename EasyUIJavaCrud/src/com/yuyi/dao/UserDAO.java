package com.yuyi.dao;

import java.util.List;

import com.yuyi.bean.User;

public interface UserDAO {

	public List<User> findAllUser();
	
	public int addUser(User user);
	
	public boolean deleteUser(int id);
	
	public User updateUser(User user);
	
	public List<User> findByPage(int page,int rows);
	
	public int findTotal();
	
	public User saveUser(User user); 
}
