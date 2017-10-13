<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 获取当前项目名 /bank2.0 -->
<%String path=request.getContextPath(); %>

<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<html>
  <head>
    <title>regist.jsp</title>
    
  </head>
  
  	<center>
  	<h1><font color="red" >欢迎光临银行项目网页版</font></h1>
  	</center>
 
  	
  <body background="image/4.jpg">
 		<center>
 			哇出错啦出错啦 兄弟你要稳一点噢 不能随便输入信息的哦<br><br><br>
 			<hr/>
 			<hr/>
 			<%  response.setHeader("refresh","3;url=login.jsp"); %>
 			三秒钟后自动跳转到登录页面，如未跳转请点击<a href="login.jsp">这里</a>
 			<hr/>
 			
 		</center>
 		
  </body>
</html>
