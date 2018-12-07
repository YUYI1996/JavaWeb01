package com.yuyi.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.yuyi.bean.User;
import com.yuyi.dao.UserDAO;
import com.yuyi.dao.impl.UserDAOImpl;

public class UserTest {
	UserDAO userDAO = new UserDAOImpl();
	

//	@Test
//	public void testListAllUser() {
//		List<User> list = userDAO.findAllUser();
//		System.out.println(list.size());
//		Iterator<User> it = list.iterator();
//		while(it.hasNext()) {
//			User user = it.next();
//			System.out.println("user.id"+user.getId()+"user.firstname"+user.getFirstName());
//		}
//	}

//	@Test
//	public void testAddUser() {
//		User user = new User();
//		user.setFirstName("bb");
//		user.setLastName("BB");
//		user.setPhone("13414873584");
//		user.setEmail("bb@163.com");
//		
//		int num = userDAO.addUser(user);
//		if (num > 0) {
//			System.out.println("添加成功");
//		} else {
//			System.out.println("添加失敗");
//		}
//	}
//	@Test
//	public void testDeleteUser() {
//		boolean bn=userDAO.deleteUser(14);
//		if(bn==false) {
//			System.out.println("刪除成功");
//		}else {
//			System.out.println("刪除失敗！");
//		}
//	}
//	@Test
//	public void testUpdateUser() {
//		User user=new User();
//		user.setId(5);
//		user.setFirstName("ff");
//		user.setLastName("FF");
//		user.setPhone("1341875963");
//		user.setEmail("ff@163.com");
//		int num=userDAO.updateUser(user);
//		if(num>0) {
//			System.out.println("修改成功！");
//		}else {
//			System.out.println("修改失敗！");
//		}
//	}
//	@Test
//	public void testFindByPage() {
//		List<User> list=userDAO.findByPage(2, 10);
//		System.out.println(list.size());
//		Iterator<User> it = list.iterator();
//		while(it.hasNext()) {
//			User user = it.next();
//			System.out.println("user.id"+user.getId()+","+"user.firstname"+user.getFirstName()+","+"user.lastname"+user.getLastName());
//		}
//	}
	
//	@Test
//	public void testFindTotal() {
//		int total=userDAO.findTotal();
//		System.out.println(total);
//	}
	@Test
	public void testSaveUser() {
		User user=new User(null, "nn", "NN", "13414873584", "nn@163.com");
		User user2=userDAO.saveUser(user);
		System.out.println(user2.getFirstName());
	}

}
