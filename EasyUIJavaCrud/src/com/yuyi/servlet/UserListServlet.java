package com.yuyi.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAO = new UserDAOImpl();

	public UserListServlet() {
		super();

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=1;
		int rows=10;
		String strPage = req.getParameter("page");
		String strSize = req.getParameter("rows");
		
		if(strPage !=null && strPage.trim().length()>0) {
			page=Integer.parseInt(strPage.trim());
		}
		
		if(strSize !=null && strSize.trim().length()>0) {
			rows=Integer.parseInt(strSize.trim());
		}

		Map<String, Object> result = new HashMap<>();
		List<User> list = userDAO.findByPage(page, rows);
		
		int total=userDAO.findTotal();
		
		result.put("rows", list);
		result.put("total", total);
		
		String data=new Gson().toJson(result);
		resp.setContentType("application/json;charset=UTF-8");
		resp.getWriter().write(data);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page=1;
		int rows=10;
		String strPage = request.getParameter("page");
		String strRows = request.getParameter("rows");
		
		if(strPage !=null && strPage.trim().length()>0) {
			page=Integer.parseInt(strPage);
		}
		
		if(strRows !=null && strRows.trim().length()>0) {
			rows=Integer.parseInt(strRows);
		}

		Map<String, Object> result = new HashMap<>();
		List<User> list = userDAO.findByPage(page, rows);
		
		int total=userDAO.findTotal();
		
		result.put("rows", list);
		result.put("total", total);
		
		String data=new Gson().toJson(result);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(data);
	}

}
