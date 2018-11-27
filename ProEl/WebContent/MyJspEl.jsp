<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="com.yuyi.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	=================算术运算符======================
	<br /> 10+20=${10+20}
	<br> 5/2=${5/2 }
	<br> 5/2=${5/2 }
	<br> 9/0=${9 div 0 }
	<br>
	  9%4=${9 % 4 }<br/>
         =================表达式关系运算======================<br/>
                12==15    ${12 ==15 }<br/>
                12<15     ${12  <15 }<br/>
                12>15     ${12  >  15 }<br/>
                12<=15    ${12<=15} <br/>
                12>=15    ${12>=15 }<br/>
                12!=15    ${12!=15 }<br>
                
                12==15    ${12 eq 15 }<br/>
                12<15     ${12 lt 15 }<br/>
                12>15     ${12 gt  15 }<br/>
                12<=15    ${12 le  15} <br/>
                12>=15    ${12 ge  15 }<br/>
                12!=15    ${12 ne  15 }<br>
         ================逻辑关系运算===========================<br/>
                ${12 <15  &&   12<  15 }<br>
                ${12 <15  and   12<  15 }<br>
                ${12 <15  ||   12 >  15 }<br>
                ${12 <15  or   12  >  15 }<br>
                ${!(12 < 15)  }<br>
                ${not (12 <15) }<br>
         ============ 在  EL 中判断对象是否为空====================<br>
                <%  request.setAttribute("user",""); %>
                <%  request.setAttribute("user1",null); %>
                ${empty  user }  <br>
                ${empty  user1 }  <br>       
         ============在EL中进行条件运算===============================<br/>
                <%
                     request.setAttribute("cart","");
                 %>
                 <%=request.getAttribute("cart") %><br/>
                 ${cart }<br/>
                 ${empty cart ?  "cart为空"  :  cart }<br/>
         ============遍历数组===============================<br/>        
                 <%
                        //假设从数据库中获取的数据,其实这段代码是servlet里面的
                        String[]   arr={"java","区块链","大数据"};
                        request.setAttribute("book",arr);
                 %>
            
                 <%
                        String[]     arr1=(String[] )request.getAttribute("book");
                        for(int i=0;i<3;i++){
                               request.setAttribute("num",i);
                 %>
                               ${num}:${book[num]}<br/>
                 <%
                        }
                  %>
         ============遍历集合===============================<br/>   
                 <%
                        //以后在项目中，集合是获取过来的
                        List<String> list=new  ArrayList<String>();
                        list.add("饼干");
                        list.add("牛奶");
                        list.add("果冻");
                        session.setAttribute("goodList", list);
                        for(int  i=0;i<list.size();i++){
                                 request.setAttribute("num", i);
                  %> 
                               ${goodList[num] }    <br/>
                  <%
                        }
                  %>
         ============javabean组合===============================<br/>    
         <%
                  User    user=new  User();
                  user.setUsername("root");
                  user.setPassword("123456");
                  
                  request.setAttribute("ur", user);
          %>
          <!--这个  -->                    
          ${ur.username }<br>
          ${ur.password }<br>
                            
</body>
</html>