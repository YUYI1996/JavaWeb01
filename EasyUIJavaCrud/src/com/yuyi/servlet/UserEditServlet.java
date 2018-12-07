package com.yuyi.servlet;

import static org.hamcrest.CoreMatchers.nullValue;

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
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
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
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		int id=Integer.parseInt(strId);
		User user=new User(id, firstName, lastName, phone, email);
		
		User result=userDAO.updateUser(user);
		
		// 4.返回数据给页面，返回给easyui
				String data = null;
				if (result != null) {
					data = new Gson().toJson(result);
				} else {
					Map<String, String> map = new HashMap<String, String>();
					map.put("errorMsg", "修改用户失败！");
					data = new Gson().toJson(map);
				}

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
