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

<a href="#" onclick="mgmtUser()">用户管理</a>
<br>
<a href="#" onclick="alterPw()">修改密码</a>
<br>
<a href="#" onclick="exitSys()">退出系统</a>
<br>
	<table class="table1"  border="1">
			<thead>
				<th>账户</th>
				<th>密码</th>					
			</thead>
		<tbody>
		<c:forEach items="${sysuserlist.getList()}" var="sysuser">			
			<tr align = "center">			
				<td> ${sysuser.getAccount()}</td>
				<td> ${sysuser.getPassword()}</td>
				
			</tr>		
		</c:forEach>
			</tbody>
	</table>
</body>
<script>
	function mgmtUser(){
		//代码
	}
	
	function alterPw(){
		//代码
	}
	
	function exitSys(){
		//退出系统
	}
	
	
</script>
</html>