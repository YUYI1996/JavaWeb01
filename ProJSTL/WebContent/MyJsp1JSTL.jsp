<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSTL Test</title>
</head>
<body>
	==============c:out=====================
	<br>
	<%=10%><br> ${10}
	<br>
	<c:out value="10"></c:out>
	<br>
	<!-- 
                   escapeXml：转换特殊字符，默认的true是转换(就是说那个特殊字符就是相当于普通字符).如果是false：不转换，html里面相当于包含了
                                                                 特殊字符，<hr>结果就是水平线，
               -->
	<c:out value="水<hr>平" escapeXml="false" />
	<br>
	<%
		request.setAttribute("name", "yuyi");
	%>
	<c:out value="${requestScope.name}" default="lily"></c:out>
	<br>
	<c:out value="${requestScope.name}">YUYI</c:out>
	<br> ==============c:set=====================
	<br>
	<!-- var:属性名 value:属性值 -->
	<c:set var="age" value="18" scope="page"></c:set>
	${age}
	<br>
	<c:out value="${age}"></c:out>
	<br>
	<c:set var="age" scope="page">40</c:set>
	<c:out value="${age}"></c:out>
	<br>

	<!-- id:对象名      下面代码相当于：User   user=new  User()-->
	<jsp:useBean id="user" class="com.yuyi.bean.User"></jsp:useBean>
	<c:set target="${user}" property="account" value="100"></c:set>
	${user.account}
	<br>
	<c:out value="${user.account}"></c:out>
	<br> ==============c:remove=====================
	<br>
	<c:remove var="age"></c:remove>
	<c:out value="${age }"></c:out>
	<br> ==============c:catch=====================
	<br>
	<c:catch var="message">
		<jsp:useBean id="user2" class="com.yuyi.bean.User"></jsp:useBean>
		<c:set target="${user2}" property="account2" value="200"></c:set>
	</c:catch>
	<c:out value="${message} "></c:out>
	<br> ==============c:if=====================
	<br>
	<!-- param.title： 获取title的值         var:定义属性名称       它的值就是test结果值-->
	<c:if test="${empty param.title}" var="result">
		<form action="">
			新闻标题：<input type="text" name="title"> <br> <input
				type="submit"> <br>
		</form>
	</c:if>
	<!-- result：false      !result:true -->
	<c:if test="${!result}">
	<c:out value="${param.title}"></c:out>,重大新闻！
	</c:if>
	 ==============c:choose=====================<br> 
	 <c:choose>
	 <c:when test="${empty param.title}">
	  <form action="">
			                                                             新闻标题：<input   type="text"     name="title"> <br>
			                                  <input   type="submit"    > <br>
		                         </form>
	 </c:when>
	 
	 <c:otherwise>
	 <c:out value="${param.title}"></c:out>,重大新闻
	 </c:otherwise>
	 </c:choose>      
</body>
</html>