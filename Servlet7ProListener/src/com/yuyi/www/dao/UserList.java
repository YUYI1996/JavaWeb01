package com.yuyi.www.dao;

import java.util.Vector;
/**
 * 这个类是用来添加删除用户的
 * @author 育奕
 *
 */
public class UserList {

	private static UserList userList=new UserList();
	
	private UserList() {
		vector=new Vector<String>();
	}
	
	public static UserList getInstance() {
		return userList;
	}
	
	private Vector<String> vector;
	
	public Vector<String> getVector() {
		return vector;
	}
	
	public void setVector(Vector<String> vector) {
		this.vector = vector;
	}
	
	//添加用户
	public boolean addUser(String name) {
		if(vector != null) {
			vector.add(name);
			return true;
		}
		return false;
	}
	
	//移除用户
	public void removeUser(String name) {
		if (vector != null) {
			vector.remove(name);
		}
	}
}
