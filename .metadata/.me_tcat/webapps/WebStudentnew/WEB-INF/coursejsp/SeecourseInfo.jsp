 <%@ page isELIgnored="false" %>
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
           function courseDel(courseId)
           {
               if(confirm('您确定删除吗？'))
               {	
              
                   window.location.href="<%=path %>/course.do?command=delCourse&courseId="+courseId;
               }
           }
    </script>
		<style type="text/css">
		body {
			 background:url(images/bg.gif);
			}
	</style>
        
	</head>

	<body leftmargin="2" topmargin="2" >
			 
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" align='center'>&nbsp;课程信息&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="20%">ID</td>
					<td width="20%">课程名</td>
					<td width="20%">任课教师</td>
					<td width="20%">课程学分</td>
					<td width="20%">操作</td>
					 
		        </tr>	
				<c:forEach items="${AllCourse}" var="s">
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${s.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${s.className}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${s.teacher}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   ${s.score}
					</td>	 
				    <td bgcolor="#FFFFFF" align="center">
						 <a href="#" onclick="courseDel(${s.id})" >删除</a>
					    <a href="<%=path %>/course.do?command=updateCourse&id=${s.id}">修改</a>
					</td>
				</tr>
				</c:forEach>
			</table>
					    
	</body>
</html>
