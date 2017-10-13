<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isELIgnored="false" %>
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
           function adminDel(userId)
           {
               if(confirm('您确定删除吗？'))
               {	
              
                   window.location.href="<%=path %>/notice.do?command=delNotice&userId="+userId;
               }
           }
           
           function adminAdd()
           {
                 var url="<%=path %>/jsp/adminAdd.jsp";
				 window.location.href=url;
           }
           	function check1(){
				if( document.getElementById("userName").value==""){
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
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" align='center'>&nbsp;通告查看&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="25%">ID</td>
					<td width="25%">标题名</td>
					<td width="25%">创建日期</td>
					<td width="25%">操作</td>
		        </tr>	
				<c:forEach items="${noticeList}" var="s">
				<tr align='center' bgcolor="#FFFFFF" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${s.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="<%=path %>/notice.do?command=updateNotice&id=${s.id}">${s.head}</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${s.time}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="adminDel(${s.id})" >删除</a>
						<a href="<%=path %>/notice.do?command=updateNotice&id=${s.id}">修改</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			
	</body>
</html>
