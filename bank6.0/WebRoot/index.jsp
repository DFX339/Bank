<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!-- 获取当前项目名 /bank4.0 -->
<%String path=request.getContextPath(); %>

<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>bank</title>
	<link rel="stylesheet" href="index.css">
	<script src="jquery-3.2.1.min.js"></script>
	<script>
			
		
		window.onload=function(){
			var img=document.getElementById('imga');
			var imgs=img.getElementsByTagName('img');
			var curIndex=0;
			var handler=null;
			handler=setInterval(changeImg,2000);
			function changeImg(){
						var img=document.getElementById('imga');
						var imgs=img.getElementsByTagName('img');
						imgs[curIndex].className='hide';
						var nextIndex=curIndex+1>=imgs.length?0:curIndex+1;

						imgs[nextIndex].className='show';
						curIndex=nextIndex;

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
				<input type="search" placeholder="新版网银">
				<label for=""><img src="images/yi.jpg" alt=""></label>
			</div>
			<ul>
				<li><a href="index.jsp">首页</a></li>
				<li>个人业务</li>
				<li>公司业务</li>
				<li>信用卡</li>
				<li>帮助</li>
				<li class="lastchild"><a href="toLogin.do"><spring:message code="userShowName"/></a></li>
			</ul>
		</div>
		<div class="lunbo">
			<ul class='mainMenu2'>
				<li>
					<span class="first"><a href="toLogin.do"><spring:message code="userShowName"/></a></span><br/>
					
				</li>
				<li>
					<span class="first"><a href="chinese.do?locale=zh_CN"><spring:message code="userLanguaueChinese"/></a></span><br/>
					<span class="first"><a href="us.do?locale=en_US"><spring:message code="userLanguaueEnglish"/></a></span><br/>
					
				</li>
				<li>
					<span><a href="">个人网上银行</a></span><br/>
					<ul class='subMenu'>
						<li><a href="regist.jsp">注册</a></li>
						<li><a href="">>指南</a></li>
						<li><a href="">>网银助手</a></li>
						<li><a href="">>安全专区</a></li>
						<li><a href="">>防范假网站</a></li>
					</ul>
				</li>
				<li>
					<span><a href="">企业网上银行</a></span><br/>
					<ul class='subMenu'>
						<li><a href="">>注册</a></li>
						<li><a href="">>演示</a></li>
						<li><a href="">>指南</a></li>
						<li><a href="">>网银助手</a></li>
						
					</ul>
				</li>
				<li>
					<span><a href="">合作软件</a></span><br/>
					<ul class='subMenu'>
						<li>><a href="">>拼多多</a></li>
						<li>><a href="">>融已购</a></li>
						<li><a href="">>开心银行</a></li>
						<li><a href="">>快乐购</a></li>
						
					</ul>
				</li>
			</ul>
			<ul class="img" id="imga">
				<li><img src="images/1.jpg" alt=""></li>
				<li><img src="images/2.jpg" alt=""></li>
				<li><img src="images/3.jpg" alt=""></li>
				<li><img src="images/4.jpg" alt=""></li>
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