<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/dtree.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#bae87c;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#c1ea8b;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#ffffff;
		 background:url(images/bg.gif);
		}
		
		.bitem {
		  background:url(images/side_snow.gif);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		  background-repeat: no-repeat;
		  margin-top:0px;
			
		}
		.title{
			margin-left:2px;
			background:url(images/menubg.gif);
			background-repeat:no-repeat;
			text-align:center;
			cursor:pointer;
			height:26px;
		  	line-height:26px;
	</style>
	<script language='javascript'>var curopenItem = '1';</script>
	<script language="javascript" type="text/javascript" src="js/menu.js"></script>
	<base target="main" />
  </head>
  <body target="main">
  	<div class='bitem'>
  	
  	<div class='title'><tr>学生信息</tr><br></div>
  		<tr><a href='<%=path %>/stuInfo.do' target='main'>学生信息管理</a></tr><br>
  	</div>
  
  	<div class='bitem'>
  		<div class='title'><tr >学生成绩</tr><br/></div>
  		<tr><a href='<%=path %>/score.do?command=findGrade' target='main'>学生成绩管理</a></tr><br>
  		<tr><a href='<%=path %>/score.do?command=addGrade' target='main'>学生成绩录入</a></tr><br>

  	</div>
  	<div class='bitem'>
  		<div class='title'><tr >课程</tr><br/></div>
  		<tr><a href='<%=path %>/course.do?command=findCourse' target='main'>课程管理</a></tr><br>
  	    <tr><a href='<%=path %>/course.do?command=addCourse' target='main'>课程录入</a></tr><br>

  	</div>
  	
  	<div class='bitem'>
  		<div class='title'><tr >通告</tr><br></div>
  		<tr><a href='<%=path %>/notice.do?command=findNotice' target='main'>通告信息管理</a></tr><br>
  		<tr><a href='<%=path %>/notice.do?command=forwardAddNotice' target='main'>添加通告</a></tr>
  	</div>
  	<div class='bitem'>
  		<div class='title'><tr>管理员账号</tr><br></div>
  		<tr><a href='<%=path %>/admin.do?command=findAdmin' target='main'>管理员账号管理</a></tr><br>
  		<tr><a href='<%=path %>/admin.do?command=updateAdmin' target='main'>修改密码</a></tr>
  	</div>
  </body>
</html>