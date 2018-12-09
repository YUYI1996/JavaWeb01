package com.yuyi.listener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyServletContext implements ServletContextListener {

   
    public MyServletContext() {
      
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("監聽器銷毀了！");
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
       System.out.println("監聽器啓動了...");
       Timer timer=new Timer();
       timer.schedule(new TimerTask() {
		
		@Override
		public void run() {
			System.out.println("Run....");
			
		}
	}, new Date(),5000);
       
		//timer.schedule(task, firstTime, period);
		// task  任务  你要干什么事情
		//firstTime   第一次执行的时间
		//period  间隔的时间   以毫秒为单位
       
       System.out.println("監聽到MySetvletContext創建");
       ServletContext servletContext=arg0.getServletContext();
       System.out.println(servletContext);
       
       ServletContext servletContext2=(ServletContext) arg0.getSource();
       System.out.println(servletContext);
    }
	
}
