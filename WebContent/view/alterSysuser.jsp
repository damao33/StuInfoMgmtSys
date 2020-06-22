<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<a href="${pageContext.request.contextPath}/view/addSysuser.jsp">增加用户</a>
<a href="${pageContext.request.contextPath}/view/alterSysuser.jsp">修改密码</a>
<a href="#" onclick="exitSys()">退出系统</a>
<br>
	<form action="">
		请输入想要修改的账号：<input type="text" name="Account" value="">			<br><br>
			
		<input type="submit" value="提交">
	</form>
<table class="table1" border="1">
	<thead>
				<th>账户</th>
				<th>密码</th>				
	</thead>
	<tbody>
		<c:forEach items="${Sysuserlist.getList()}" var="Sysuser">			
			<tr align = "center">			
				<td> ${Sysuser.getAccount()}	<a herf="">修改</a></td>
				<td> ${Sysuser.getPassword()}	<a herf="">修改</a></td>
				
			</tr>		
		</c:forEach>
			</tbody>
</table>
</body>
</html>