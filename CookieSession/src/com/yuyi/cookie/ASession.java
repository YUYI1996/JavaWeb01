package com.yuyi.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ASession
 */
public class ASession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一次訪問生成sessionId,第二次訪問驗證sessionId
		HttpSession httpSession=request.getSession();
		//設置屬性
		httpSession.setAttribute("yuyi", "23");
		//獲取ID
		String id=httpSession.getId();
		//創建session發送給客戶端
		Cookie cookie=new Cookie("JSESSIONID", id);
		cookie.setPath("/CookieSession");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
		response.getWriter().write("ID="+id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
