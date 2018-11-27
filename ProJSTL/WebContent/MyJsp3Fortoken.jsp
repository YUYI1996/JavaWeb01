<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = "abcdnefghnijnklmndfddf";
		request.setAttribute("strr", str);
	%>
	<!-- 
                    items:要切割的对象
                    delims:以什么字符分割
                    begin: 分割后的字符下标，从哪个下标开始
                    end  : 分割后的字符下标，从哪个下标结束
               -->
                <c:forTokens items="${strr }" delims="n"   begin="0"  end="4"  step="2"  var="aa">
                         <c:out value="${aa}"></c:out>
              </c:forTokens>
</body>
</html>