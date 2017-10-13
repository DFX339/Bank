<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 获取当前项目名 /bank2.0 -->
<% String path=request.getContextPath(); %>

<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<html>
  <head>
    <title>login.jsp</title>
  </head>
  
  <style>
  	.msg{color:gray;font-size:14px;}
    .msg1{color:red;heigth:14px;background-color:#ffcc99;border:solid 1px gary;}  
  </style>
  
  <script>
  	function check(){
  		if(nameBlur()==false||pwBlur()==false){
  			return false;
  		}else{
  			return true;
  		}
  	}
  	
  	//用户名输入框获取焦点事件
  	function nameFocus(){
  		var obj=document.getElementById("nameMsg");
  		obj.innerHTML="请输入正确的用户名";
  		nameMsg.className="msg";
  	
  	}
  	
  	//用户名输入框焦点丢失事件
  	function nameBlur(){
  		var obj=document.getElementById("username").value;
  		if(obj==""){
  			nameMsg.innerHTML="用户名不能为空";
  			nameMsg.className="msg1";
  			return false;
  		}else{
  			nameMsg.innerHTML="格式正确";
  			nameMsg.className="msg";
  			return true;
  		}
  	
  	}
  	//密码输入框获取焦点事件
  	function pwFocus(){
  		var obj=document.getElementById("pwMsg");
  		obj.innerHTML="请输入正确的密码";
  		nameMsg.className="msg";
  	
  	}
  	
  	
  	//密码输入框焦点丢失事件
  	function pwBlur(){
  		var obj=document.getElementById("password").value;
  		if(obj==""){
  			pwMsg.innerHTML="密码不能为空";
  			pwMsg.className="msg1";
  			return false;
  		}else{
  		    pwMsg.innerHTML="格式正确";
  			pwMsg.className="msg";
  			return true;
  		}
  	
  	}
  	

  	//点击注册时，客户端跳转到注册页面
  	function check1(){
  		window.location.replace("regist.jsp");
  	}
  	</script>
  	
  <center>
  	<h1><font color="red" >欢迎光临银行项目网页版</font></h1>
  	</center>
  	
  <body background="image/4.jpg">
 		<center>
 			 <form action="LoginServlet" method="post" onsubmit="return check()">
    	用户名：<input id="username" type="text" name="username" onfocus="nameFocus()" onblur="nameBlur()"/>
    			<span id="nameMsg" class="msg"></span><br/><br/>
    	密&nbsp;码：<input id="password" type="password" name="password" onfocus="pwFocus()" onblur="pwBlur()"/>
    			<span id="pwMsg" class="msg"></span><br/><br/>
		<input type="submit" name="login" value="登录"/>
		<input type="button" name="regist" value="注册" onclick="check1()"/> 
    </form>
 		</center>
  </body>
</html>
