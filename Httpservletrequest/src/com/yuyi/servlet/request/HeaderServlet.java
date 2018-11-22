package com.yuyi.servlet.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HeaderServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 獲取指定的請求頭
		String header = request.getHeader("User-Agent");
		System.out.println("header=" + header);
		// 获取所有的请求头
		Enumeration<String> headNames = request.getHeaderNames();
		while (headNames.hasMoreElements()) {
			String nextElement = headNames.nextElement();
			String value = request.getHeader(nextElement);
			System.out.println("requestHeader:" + value);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
