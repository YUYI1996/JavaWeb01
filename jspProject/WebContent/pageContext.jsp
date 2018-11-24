<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PageContext</title>
</head>
<body>
	<%
		//使用pageContext向request域存對象
		request.setAttribute("name", "yuyi");
		pageContext.setAttribute("name", "aaa");
		pageContext.setAttribute("name", "bbb", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "ccc", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "ddd", PageContext.APPLICATION_SCOPE);
	%>
	
	<%=request.getAttribute("name") %>
	<%=pageContext.getAttribute("name",pageContext.REQUEST_SCOPE) %>
	
	<!-- findAtrribute会从小到大来取范围中的name -->
	<!-- 依次从pageContext域，request域，session域，application域中获取属性， -->
	<!-- page域：当前jsp页面方位 -->
	<!-- application域：整个web应用 -->
	<%=pageContext.findAttribute("name") %>
</body>
</html>