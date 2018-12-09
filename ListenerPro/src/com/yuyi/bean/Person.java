package com.yuyi.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//绑定的方法
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	//解绑的方法
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("哎呀  我解绑了    你可以走了");
		
	}
	
}
