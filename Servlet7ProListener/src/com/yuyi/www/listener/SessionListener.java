package com.yuyi.www.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.yuyi.www.dao.UserList;


@WebListener
public class SessionListener implements HttpSessionBindingListener {

   private UserList userList=UserList.getInstance();
   
    public SessionListener() {
        
    }

	@Override
    public void valueBound(HttpSessionBindingEvent arg0)  { 
        System.out.println(name+"上线了！");
        //添加用户
        boolean bn=userList.addUser(name);
    }

    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
        System.out.println(name="下线了！");
        //移除用户
        userList.removeUser(name);
    }
    
    private String name;
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getName() {
		return name;
	}
	
}
