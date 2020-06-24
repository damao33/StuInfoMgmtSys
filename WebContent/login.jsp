<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户登陆</title>
	</head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginStyle.css" />
	<body>
		<form class="login-form" action="${pageContext.request.contextPath}/login/" method="post">
				<h1>学生信息管理系统</h1>
				<h2 align="center">用户登陆</h1>
				<div class="txtb">
					<input type="text" placeholder="这里是账号" name="account"/>
					<span data-placeholder="account" ></span>
					<br>
				</div>
				<p class="msg">${loginMsg}</p>
				<div class="txtb" >
					<input type="password"   placeholder="这里是密码" name="password"/>
					<span data-placeholder="password"></span>
				</div>
				<input type="submit" class="logbtn" value="登陆" />
		</form>
	</body>
</html>

