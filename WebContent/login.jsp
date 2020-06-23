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
		<form class="login-form" action="login/" method="post">
				<h1>用户登陆</h1>
				<div class="txtb">
					<input type="text" placeholder="这里是账号" name="account"/>
					<span data-placeholder="account" ></span>
					<br>
					${loginMsg}
				</div>
				<div class="txtb" >
					<input type="password"   placeholder="这里是密码" name="password"/>
					<span data-placeholder="password"></span>
				</div>
				<input type="submit" class="logbtn" value="登陆" />
				<div class="bottom-text">
					<a href="#">注册</a>
				</div>
		</form>
	</body>
</html>
