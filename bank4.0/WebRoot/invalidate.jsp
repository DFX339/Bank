<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </style>
  
	
  	
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
				<li>首页</li>
				<li>个人业务</li>
				<li>公司业务</li>
				<li>信用卡</li>
				<li>帮助</li>
				<li class="lastchild"><a href="invalidate.jsp"> 注销登录</a></li>
			</ul>
		</div>
		<div class="lunbo">
			<ul class='mainMenu1'>
				<li>
					<span class="first1"><a href="index.jsp" style="color:white;background-color:#99cc33;display:inline-block;border-bottom:1px solid #99cc33;font-size:20px; height:28px;width:230px;padding-left:100px">注销登录界面</a></span><br/><br/>
				<h3>
 			<% 
 				session.invalidate(); 
 				response.setHeader("refresh","0;url=index.jsp");
 			%>
 			
 		 	<a href="login.jsp" style="color:white;background-color:#99cc33;display:inline-block;border-bottom:1px solid #99cc33;font-size:20px; height:28px;width:230px;padding-left:20px">点击这里回到登录页面</a><br><br>
 		 	</h3>
					
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