package com.yuyi.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class MyHttpsession implements HttpSessionListener {

   
    public MyHttpsession() {
        // TODO Auto-generated constructor stub
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  { 
        System.out.println("session創建了..."+arg0.getSession().getId());
//統計這個網站的訪問人數
    }
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         System.out.println("session銷毀了。。。");
    }
	
}
