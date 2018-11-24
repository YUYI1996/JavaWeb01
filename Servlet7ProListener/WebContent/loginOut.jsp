<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>loginOut Page</title>
</head>
<body>
	<%
		session.invalidate();//session发生了注销事件，就会调用valueUnBound方法。
		response.sendRedirect("index.jsp");
	%>
</body>
</html>