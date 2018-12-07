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
import com.yuyi.bean.User;
import com.yuyi.dao.UserDAO;
import com.yuyi.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   
   
    public AddUserServlet() {
        super();
        userDAO=new UserDAOImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.設置編碼格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//2.從前台獲取信息
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		//3.傳入數據
		User user=new User(null, firstName, lastName, phone, email);
		//4.調用DAO來保存數據
		User result=userDAO.saveUser(user);
		//5.返回數據給到前台
		String data=null;
		
		if(result != null) {
			data=new Gson().toJson(result);
		}else {
			Map<String, String> map=new HashMap<String,String>();
			map.put("errorMsg", "新增用戶失敗");
			data=new Gson().toJson(map);
			System.out.println(data);
		}
		//把java的对象数据变成json格式的数据
		response.setContentType("application/json;charset=UTF-8");
		//服务器返回json数据到浏览客户端
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
