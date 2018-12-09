package com.yuyi.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public demo2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = this.getServletContext();
		//存放操作
		servletContext.setAttribute("name", "yuyi");
		servletContext.setAttribute("name", "yuxi");
		//刪除操作
		servletContext.removeAttribute("name");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
