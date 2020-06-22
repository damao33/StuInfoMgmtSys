<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<a href="${pageContext.request.contextPath}/view/addSysuser.jsp">增加用户</a>
<a href="#" onclick="alterPw()">修改密码</a>
<a href="#" onclick="exitSys()">退出系统</a>
<br>
<p>
请输入想要添加的管理员信息
</p>
<form action="${pageContext.request.contextPath}/sysMgmt/insert">
	账号：<input type="text" name="account" value="">			<br><br>
	密码：<input type="password" name="password" value="">		<br><br>
		<input type="submit" value="添加">
</form>
</body>
</html>