<%@  page  isELIgnored="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	<!-- 	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />	 -->
	 <script language="javascript">
           function gradeDel(userId)
           {
               if(confirm('您确定删除吗？'))
               {	
              
                   window.location.href="<%=path %>/score.do?command=delGrade&Id="+userId;
               }
           }
           function check1(){
				if( document.getElementByName("username").value==""){
					alert("请输入用户名");
					return false;
				}
					document.text.submit();
			}
      </script>
		<style type="text/css">
	body {
		 background:url(images/bg.gif);
		}
	</style>
        
	</head>

	<body leftmargin="2" topmargin="2" >
           <table>
			<form action="<%=path %>/score.do?command=findGrade" name="formFind" method="post">
				<tr >
				用户查询
				</tr>
				<tr>
					 <td width="25%" bgcolor="#FFFFFF" align="right">  请输入学生名：</td>
				    <td width="75%" bgcolor="#FFFFFF" align="left">
				        <input type="text" name="username" size="20"/>
				        <input type="submit" value="提交" onClick="check1()"/>&nbsp;
				    </td>
				</tr>
			</form>
		  </table>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" align='center'>&nbsp;学生成绩&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="20%">学生名</td>
					<td width="20%">课程名</td>
					<td width="20%">任课老师</td>
					<td width="10%">学分</td>
					<td width="10%">分数</td>
					<td width="20%">操作</td>
		        </tr>	
				<c:forEach items="${scoreList}" var="s">
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td bgcolor="#FFFFFF" align="center">
					    ${s.stu_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${s.class_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${s.class_teacher}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${s.class_score}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${s.stu_grade}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="gradeDel(${s.id})" >删除</a>
						<a href="<%=path %>/score.do?command=updateGrade&id=${s.id}">修改</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
