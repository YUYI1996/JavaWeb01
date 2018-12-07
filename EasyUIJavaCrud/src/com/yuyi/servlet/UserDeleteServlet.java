package com.yuyi.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yuyi.dao.UserDAO;
import com.yuyi.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        userDAO=new UserDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String strId=request.getParameter("id");
		System.out.println(strId);
		Integer id=Integer.parseInt(strId);
		
		boolean bn=userDAO.deleteUser(id);
		
		String data=null;
		
		if(bn==false) {
			data = "{\"success\":true}";//成功返回success
			
		}else {
			Map<String, String> map=new HashMap<String,String>();
			map.put("errorMsg", "刪除用戶失敗！");
			data=new Gson().toJson(map);
		}
		System.out.println(data);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
