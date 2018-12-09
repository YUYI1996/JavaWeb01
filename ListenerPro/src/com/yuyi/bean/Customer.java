package com.yuyi.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer implements HttpSessionActivationListener,Serializable{
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

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("好了  我又复活了……………………");
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("完了  我被钝了……………………");
		
	}
	
	
}
