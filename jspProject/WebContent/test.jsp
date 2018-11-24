<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="true" isErrorPage="TRUE"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Test Page</title>
</head>
<body>
	<%
		int i = 100;
		System.out.println(i);//沒帶感嘆號的是局部變量
	%>

	<%=i %>
	<br>
	<br>
	<%=1+2+3+4 %>
	<br>
	<br>
	<%!int a = 2;//帶感嘆號的是成員變量%>

	<%
	  String string="hello,I am yuyi";
	%>
	<%=string %>
	<br>
	<br>
	<%
	List list=new ArrayList();
	%>

	<%
	int c=10/0;
	%>
</body>
</html>