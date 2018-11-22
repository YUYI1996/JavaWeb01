package com.yuyi.servlet.request;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class lineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public lineServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求方式
		String method = request.getMethod();
		System.out.println("requestType=" + method);
		System.out.println("===================");

		// 获取请求资源的相关内容
		String requestURI = request.getRequestURI();
		System.out.println("requestURI=" + requestURI);
		System.out.println("===================");
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("requestURL=" + requestURL);
		System.out.println("===================");

		// 獲取WEB應用的名稱
		String contextPath = request.getContextPath();
		System.out.println("contextPath=" + contextPath);
		System.out.println("===================");

		// 獲取URL地址後面的參數字符串
		String queryString = request.getQueryString();
		System.out.println("qeryString=" + queryString);
		System.out.println("================");
		
		// 獲取訪問者的IP
		String remoteAddr = request.getRemoteAddr();
		System.out.println("remoteAddr=" + remoteAddr);
		
		//post獲取請求參數
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("姓名：" + username );
		System.out.println("密码：" + password );
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		System.out.println(parameterMap);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
