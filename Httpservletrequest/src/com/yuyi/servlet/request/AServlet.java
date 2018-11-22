package com.yuyi.servlet.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在request域中存儲參數
		request.setAttribute("yuyi", "yuyi");
		//請求轉發
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/bservlet");
		//執行
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
