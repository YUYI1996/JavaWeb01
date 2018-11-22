package com.yuyi.servlet.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServlet01
 */
public class HttpServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().write("你好！");
		
		//1.設置狀態碼
		//response.setStatus(404);
		
		//2.設置重定向
		//response.setHeader("Location", "/Httpservletresponse/Httpservlet02");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Httpservlet02");
		dispatcher.forward(request, response);
		//設置響應頭
//		Date date=new Date();
//		response.addHeader("name", "yuyi");
//		response.addHeader("name", "yuxi");
//		response.addIntHeader("age", 23);
//		response.addDateHeader("hiredate", date.getTime());
//		
		
		//response.setHeader("refresh", "5;url=http://www.zhihu.com");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
