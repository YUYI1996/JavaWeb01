<%@page import="java.util.ArrayList"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Foreach Page</title>
</head>
<body>
	<%
		for (int i = 0; i <= 10; i++) {
			out.println(i + "");
		}
	%><br> =====================================
	<br>
	<%
		for (int i = 0; i <= 10; i++) {
	%>
	<%=i%>
	<%
		}
	%>
	=====================================
	<br>
	<%
		for (int i = 0; i < 10; i++) {
			request.setAttribute("num", i);
	%>
	${num}

	<%
		}
	%>
	===========c:foreach==========================
	<br>
	<c:forEach var="i" begin="0" end="10" step="2">
	${i}
	</c:forEach>
	  ===========c:foreach==========================<br>
	  <c:forEach var="i" begin="0" end="10" step="1">
	  <c:out value="${i}"></c:out><br>
	  </c:forEach>
	  <hr/>
	   ===========c:foreach 数组==========================<br>
	   <%
	   String[] str={"yuyi","Mike","Lily"};
	   request.setAttribute("str", str);
	   %>
	   <c:forEach items="${str}" var="st" begin="0" varStatus="d">
	   <c:out value="${d.index}"></c:out>
	   <c:out value="${st}"></c:out><br>
	   </c:forEach>
	   <hr/>
	    ===========c:foreach list==========================<br> 
	    <%
	    //假設從數據庫裏面獲取了數據
	   List<String> list=new ArrayList<String>();
	    list.add("Jim");
	    list.add("Tom");
	    
	    request.setAttribute("lists", list);
	    
	   Map map=new HashMap();
	    %>
	    <c:foreach items="${lists}" var="name" begin="0" varStatus="d">
	    ${d.index} <c:out value="${name}"></c:out>
	    </c:foreach>
</body>
</html>