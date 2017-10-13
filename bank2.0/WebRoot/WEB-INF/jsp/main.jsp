<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 获取当前项目名 /bank2.0 -->
<%String path=request.getContextPath(); %>

<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<html>
  <head>
    <title>regist.jsp</title>
    
  </head>
  
  <!-- 定义两个样式 -->
  <style>
  	.msg{color:gray;font-size:12px;}
  	.msg2{height:12px;color:red;background-color:#ffcc99;border:solid 1px gray;line-height:10px;padding:4px 2px;}
  </style>
  
  	<center>
  	<h1><font color="red" >欢迎光临银行项目网页版</font></h1>
	<a href="invalidate.jsp">注销</a></right>
  	</center>
  	
  	<script>
  		<%--转账输入验证--%>
  		//鼠标焦点获得 ID
  		function focuTransfer(){
  			var obj=document.getElementById("traMsg");
  			obj.innerHTML="转账ID必须按格式填写哦";
  			traMsg.className="msg";
  		}
  		
  		//鼠标焦点失去 ID
  		function blurTransfer(){
  			if(document.getElementById("ID").value==""){
  				traMsg.innerHTML="ID不能为空哦";
  				traMsg.className="msg2";
  				return false;
  			}else if((document.getElementById("ID").value).matches("[0-9]{0,2}")){//ID属于0-99
  				traMsg.innerHTML="ID格式有误";
  				traMsg.className="msg2";
  				return false;
  			}else{
  				return true;
  			}
  		}
  		
  		//鼠标焦点获得 TransferNum
  		function focusTraId(){
  			var obj=document.getElementById("traNumMsg");
  			obj.innerHTML="转账金额只能是0-999999哦";
  			traNumMsg.className="msg";
  		}
  		
  		//鼠标焦点失去 TransferNum
  		function blurTraId(){
  			if(document.getElementById("transferNum").value==""){
  				traNumMsg.innerHTML="转账金额不能为空哦";
  				traNumMsg.className="msg2";
  				return false;
  			}else if((document.getElementById("transferNum").value).matches("[0-9]{0,2}")){//ID属于0-99
  				traMsg.innerHTML="转账金额格式有误";
  				traMsg.className="msg2";
  				return false;
  			}else{
  				return true;
  			}
  		}
  			
  			
  		
  		function checkTransfer(){
  			
  			if(blurTransfer()==false||blurTraId()==false){
  				return false;
  			}else{
  				return true;
  			}
  				
  		}
  		
  	</script>
  	
  	
  <body background="image/4.jpg">
 		<center>&nbsp; 
 		主界面<br>
 			<hr>
 			<form name="inqury" action="InquryServlet" method="post" >
 			<input type="submit" value="查询余额" name="InqurySubmit" /><br>
 			
 			</form>
 			
 			<hr>
 			<form name="transfer" action="TransferServlet" method="post"  onsubmit="return checkTransfer()">
 			转账ID：<input type="text" name="ID" id="ID" onfocus="focuTransfer()" onblur="blurTransfer"/>
 			<span id="traMsg" class="msg"></span><br><br>
 			转账金额：<input type="text" name="transferNum" id="transferNum" onfocus="focusTraId()" onblur="blurTraId()"/>
 			<span id="traNumMsg" class="msg"></span><br><br>
 			<input type="submit" value="转账" name="TransferSubmit" /><br>
 			</form>
 			
 			
 			<hr>
 			<form name="deposit" action="DepositServlet" method="post" onsubmit="return check2()">
 			存款金额：<input type="text" name="depositNum" id="depositNum"/><br><br>
 			<input type="submit" value="存款"  name="depositSubmit" /><br>
 			</form>
 			
 			<hr>
 			<form name="withdrawal" action="WithdrawalServlet" method="post" onsubmit="return check3()">
 			取款金额：<input type="text" name="withdrawalNum" id="withdrawalNum"/><br><br>
 			<input type="submit" value="取款"  name="withdrawalSubmit" /><br>
 			</form>
 		
 		</center>
  </body>
</html>
