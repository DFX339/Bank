<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 获取当前项目名 /bank2.0 -->
<%String path=request.getContextPath(); %>

<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<html>
  <head>
    <title>invalidate.jsp</title>
     <base href="<%=basePath%>"/>
  </head>
  
  	<center>
  	<h1><font color="red" >欢迎光临银行项目网页版</font></h1>
  	</center>
  	
  	
  <body background="image/4.jpg">
  		<!-- session用户注销 -->
 		<% 
 			session.invalidate();
 		
 		 %>
 		<h1>注销成功，请点击<a href="<%=path %>/index.jsp">这里</a>跳转到首页</h1>
  </body>
</html>
