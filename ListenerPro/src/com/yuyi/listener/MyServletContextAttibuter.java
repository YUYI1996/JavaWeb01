package com.yuyi.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttibuter implements ServletContextAttributeListener {

	public MyServletContextAttibuter() {

	}

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// 添加到这个域对象中的name
		System.out.println(arg0.getName());
		//添加到这个域对象中的value
		System.out.println(arg0.getValue());
		
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		//删除这个域对象中的name
    	System.out.println(arg0.getName());
    	//删除这个域对象中的value
    	System.out.println(arg0.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		//修改这个域对象中的name
    	System.out.println(arg0.getName());
    	//修改这个域对象中的value
    	System.out.println(arg0.getValue());
	}

}
