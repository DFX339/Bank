<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>bank</title>
	<link rel="stylesheet" href="index.css">
	<script src="jquery-3.2.1.min.js"></script>
	
	<style>
  	.msg{color:gray;font-size:14px;}
    .msg1{color:red;heigth:14px;background-color:#ffcc99;border:solid 1px gary;} 
    .msg2{color:white;background-color:#99cc33;display:inline-block;border-bottom:1px solid #99cc33;font-size:16px; height:32px;width:120px;} 
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
  		if(obj.length<2){
  			nameMsg.innerHTML="用户名长度不能小于2";
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
  		pwMsg.className="msg";
  	
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
  		moneyMsg.className="msg";
  	
  	}
  	
  	//存款金额输入框焦点丢失事件
  	function moneyBlur(){
  		var obj=document.getElementById("money").value;
  		if(obj.length<1){
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
  	
</head>
<body>
	<div class="net">
		<div class="nav">
			<div class="logo">
				<span class="logo-left">DFX</span>
				<img src="images/logo.jpg" alt="">
				<span class="logo-right">段飞霞个人银行</span>
				<input type="search" placeholder="新版网银">`
				<label for=""><img src="images/yi.jpg" alt=""></label>
			</div>
			<ul>
				<li><a href="index.jsp">首页</a></li>
				<li>个人业务</li>
				<li>公司业务</li>
				<li>信用卡</li>
				<li>帮助</li>
				<li class="lastchild"><a href="login.jsp"><spring:message code="userShowButtonLogin"/></a></li>
			</ul>
		</div>
		<div class="lunbo">
			<ul class='mainMenu'>
				<li>
					<span class="first"><a href="regist.jsp" style="color:white;background-color:#99cc33;display:inline-block;border-bottom:1px solid #99cc33;font-size:20px; height:28px;width:230px;padding-left:100px"><spring:message code="userRegistName"/></a></span><br/><br/>
					  <form id="form" name="form" action="regist.do" method="post" onsubmit="return check()">
					  <h3>
 			 <spring:message code="userRegistUsername"/>：<input type="text" name="username" id="username" onfocus="nameFocus()" onblur="nameBlur()" style="font-size:16px;height:32px;width:160px "/>
 			 		 <span id="nameMsg" class="msg"></span><br><br>
 			<spring:message code="userRegistPassword"/>：<input type="password" name="password" id="password" onfocus="pwFocus()" onblur="pwBlur()" style="font-size:16px;height:32px;width:160px "/>
 			 			<span id="pwMsg" class="msg"></span><br><br>
 			<spring:message code="userRegistMoney"/>：<input type="text" name="money" value="0.0" id="money" onfocus="moneyFocus()" onblur="moneyBlur()" style="font-size:16px;height:32px;width:160px "/>
 			 		<span id="moneyMsg" class="msg"></span><br><br>
 			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 			 <input id="regist" type="submit" value="<spring:message code="userButtonRegist"/>" class="msg2"/>
 		 	</h3>
 		 	</form>
					
				</li>
				
			</ul>
		</div>
		<div class="news">
			<div class="n-left">
				<h4>重要公告</h4>
				<ul>
					<li>
						<span class="lp">></span>
						<a href="">关于我行系统升级的通告</a>
					</li>
					<li>
						<span class="lp">></span>
						<a href="">关于国家开发银行2017年第七期金融债券柜台市...</a>
					</li>
					<li>
						<span class="lp">></span>
						<a href="">关于销售国家开发银行2017年第七期金融债券的...</a>
					</li>
					<li>
						<span class="lp">></span>
						<a href="">关于开办账户农产品和账户基本金属连续产品业..</a>
					</li>
					<li>
						<span class="lp">></span>
						<a href="">关于调整人民币和美元账户钯金报价价差的通告</a>
					</li>
				</ul>
			</div>
			<div class="n-right">
				<h4>优惠活动</h4>
				<ul>
					<li>
						<span class="lp">></span><a href="">"点差优惠 直通年底"账户贵金属垫差优惠活动</a><span class="rp">即日起至2017年12月31日</span></li>
					<li>
						<span class="lp">></span><a href="">西瓜+WIFI+冰淇淋+爱奇艺 手机银行多重优惠过暑假</a><span class="rp">即日起至2017年8月10日</span>
					</li>
					<li>
						<span class="lp">></span><a href="">免押金+30天免费骑的摩拜单车 快来领福利啦！</a><span class="rp">即日起至2017年7月31日</span>
					</li>
					<li>
						<span class="lp">></span><a href="">关于开办账户农产品和账户基本金属连续产品业..</a><span class="rp">即日起至2017年12月31日</span>
					</li>
					<li>
						<ul class="little-a">
							<li>看电影</li>
							<li>去旅行</li>
							<li>尝美食</li>
							<li>兑积分</li>
							<li>骑车行</li>
							<li>分期购</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<div class="selector">
				<select name="" id="selec1">
					<option value="" selected>中国DFX系列银行</option>
					<option value="">美国分行网站</option>
					<option value="">加拿大分行网站</option>
					<option value="">南非分行网站</option>
					<option value="">俄罗斯分行网站</option>
				</select>
				<select name="" id="selec2">
					<option value="" selected>境内分支银行</option>
					<option value="">北京分行</option>
					<option value="">上海分行</option>
					<option value="">深圳分行</option>
					<option value="">南京分行</option>
				</select>
				<select name="" id="selec3">
					<option value="" selected>友情链接</option>
					<option value="">淘宝网</option>
					<option value="">百度</option>
					<option value="">阿里巴巴</option>
					<option value="">网易</option>
				</select>
			
		</div>

		<div class="footer">
			<hr>
			<ul>
				<li><a href="">网站声明</a></li>
				<li><a href="">服务网点</a></li>
				<li><a href="">网站地图</a></li>
				<li><a href="">联系我行</a></li>
				<li>服务热线888888</li>
			</ul>
			<img src="images/LOG.jpg" alt="">
			<span>中国DFX银行版权所有  赣ICP站666666号</span>

		</div>


	</div>
	
</body>
</html>