package com.yuyi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuyi.bean.Customer;


public class demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public demo3() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session=request.getSession();
	Customer customer=new Customer();
	customer.setId("1");
	customer.setName("yuyi");
	session.setAttribute("Customer", customer);
	System.out.println("Customer放到这个域对象中了……");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
