<%@page import="com.yuyi.www.dao.UserList"%>
<%@page import="com.yuyi.www.listener.SessionListener"%>
<%@ page language="java" import="java.util.*"
contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User Page</title>
</head>
<body>
	<%
		//获取文本框输入的值
		String str = request.getParameter("mytext");
		//创建监听对象
		SessionListener sListener = new SessionListener();
		//设置name的值
		sListener.setName(str);

		System.out.println(1111);

		//把监听器传入会话对象里面，并且会执行SessionListener中valueBound方法
		//监听器是监听session事件，如果设置属性的时候，监听器就有调用valueBound方法了
		//调用valueBound方法了
		session.setAttribute("listener", sListener);

		System.out.println(2222);
		//session最大的生存周期100秒
		session.setMaxInactiveInterval(100); //存10秒就失效，如果失效了又会执行valueUnbound
		
		System.out.println(3333);
	%>
	
	<textarea rows="10" cols="20">
	  <%
	    //获取集合对象
	    Vector<String> vector=UserList.getInstance().getVector();
	    System.out.println("vector.size()="+vector.size());
	
	  if(vector !=null && vector.size()>0){
		  for(int i=0;i<vector.size();i++){
			  //打印到页面
			  System.out.println("vector.elementAt(i)="+vector.elementAt(i));
			  out.println(vector.elementAt(i));
		  }
	  }
	  %>
	</textarea>
	<br><br>
	<a href="loginOut.jsp">下线！</a>
	
</body>
</html>