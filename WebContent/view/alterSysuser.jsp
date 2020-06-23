<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alterStyle.css" / >
<body>
<div class="select"   >
<a href="${pageContext.request.contextPath}/sysMgmt/">查询所有用户</a>
<a href="${pageContext.request.contextPath}/view/addSysuser.jsp">增加用户</a>
<a href="#" onclick="deleteSysuser()">删除用户</a>	
<a href="${pageContext.request.contextPath}/view/alterSysuser.jsp">修改密码</a>
<a href="#" onclick="exitSys()">退出系统</a>
</div>
	<form action="">
	<div class="txtb"   >
		<input type="text" name="Account" value="" placeholder="请输入想要修改的账号">	<br><br>		
			</div>
		<div align="center">
		<input class="input1" type="submit" value="提交">
		</div>
	</form>
	
<table class="table1" border="1">
	<br><br>
	<thead>
				<th>账户</th>
				<th>密码</th>				
	</thead>
	<tbody>
		<c:forEach items="${Sysuserlist.getList()}" var="Sysuser">			
			<tr align = "center">			
				<td> ${Sysuser.getAccount()}	<a herf="#">修改</a></td>
				<td> ${Sysuser.getPassword()}	<a herf="#">修改</a></td>
				
			</tr>		
		</c:forEach>
			</tbody>
</table>
</body>
<script>
function deleteSysuser(){
	var account = prompt("输入账号","");
	
	if(account)
		{
			alert("account："+account);
		}
	window.location.href("${pageContext.request.contextPath}/sysMgmt/delete?account="+account);
	//代码	
}
</script>
</html>