<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 获取当前项目名 /bank2.0 -->
<%String path=request.getContextPath(); %>

<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<html>
  <head>
    <title>index.jsp</title>
     <base href="<%=basePath%>"/>
  </head>
  
  	<center>
  	<h1><font color="red" >欢迎光临银行项目网页版</font></h1>
  	</center>
  	
  	
  <body background="image/4.jpg">
 		<!-- 得到当前项目根目录 -->
 		<center>
 			 
 			<form action="ReturnServlet" method="post">
 			<table border="1">
 			<tr>
 				<td>
 				尊敬的用户您好，您的当前余额为：<br>
 	 			</td>
 	 			
 	 			<td align="center">
 				${money }<!-- 显示余额 -->
 				</td>
 			</tr>
 			
 			<tr>
 				<td align="center">
 				返回主菜单：
 				</td>
 			
 				<td>
 				<input  type="submit" name="re" value="返回主菜单" />
 				</td>
 			</tr>
 			</table>
 			</form>
 			
 		</center>
  </body>
</html>
