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
  		if(obj.length<3){
  			nameMsg.innerHTML="用户名长度不能小于3";
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
  		if(obj.length<3){
  			pwMsg.innerHTML="密码长度不能小于3";
  			pwMsg.className="msg1";
  			return false;
  		}else{
  			pwMsg.innerHTML="格式正确";
  			pwMsg.className="msg";
  			return true;
  		}
  	
  	}
  	
  	
  	//存款金额输入框获取焦点事件
  	function moneyFocus(){
  		var obj=document.getElementById("moneyMsg");
  		obj.innerHTML="存款金额必须大于0且为数字";
  		nameMsg.className="msg";
  	
  	}
  	
  	//存款金额输入框焦点丢失事件
  	function moneyBlur(){
  		var obj=document.getElementById("money").value;
  		if(obj.regex("[0-9]{0,6}")){
  			moneyMsg.innerHTML="存款金额格式有误";
  			moneyMsg.className="msg1";
  			return false;
  		}else{
  			moneyMsg.innerHTML="格式正确";
  			moneyMsg.className="msg";
  			return true;
  		}
  	
  	}
  	
  	
  	
  	
  		
  	</script>
  <body background="image/4.jpg">
 		<!-- 得到当前项目根目录 -->
 		<center>
 			
 			 <form id="form" name="form" action="RegistServlet" method="post" onsubmit="return check()">
 			 用   户  名：<input type="text" name="username" id="username" onfocus="nameFocus()" onblur="nameBlur()"/>
 			 		 <span id="nameMsg" class="msg"></span><br><br>
 			 密&nbsp;&nbsp;码：<input type="password" name="password" id="password" onfocus="pwFocus()" onblur="pwBlur()"/>
 			 			<span id="pwMsg" class="msg"></span><br><br>
 			 预存金额：<input type="text" name="money" value="0.0" id="money" onfocus="moneyFocus()" onblur="moneyBlur()"/>
 			 		<span id="moneyMsg" class="msg"></span><br><br>
 			 &nbsp;&nbsp;&nbsp;<input id="regist" type="submit" value="注册" />
 		 	
 		 	</form>
 		
 		</center>
  </body>
</html>
