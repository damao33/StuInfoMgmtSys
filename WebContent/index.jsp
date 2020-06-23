<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/indexStyle.css" />
<body>
	<div align="center">
		<h1>学生信息管理系统</h1>
	</div>
	<div>
	当前登录账号：${user.getAccount()}
	</div>
	<div class="Navigation">
	  <a href="${pageContext.request.contextPath}/welcome/" target="ContentFrame">主页</a>
	  <a href="${pageContext.request.contextPath}/stuInfo/" target="ContentFrame">学生信息查询</a>
	  <a href="${pageContext.request.contextPath}/scoreInfo/" target="ContentFrame">学生成绩查询</a>
	  <a href="${pageContext.request.contextPath}/sysMgmt/" target="ContentFrame">系统管理</A>
	  <a href="${pageContext.request.contextPath}/stuMgmt/" target="ContentFrame">学生管理</a>
	  <a href="${pageContext.request.contextPath}/cozMgmt/" target="ContentFrame">课程管理</a>
	  <a href="${pageContext.request.contextPath}/scoreMgmt/" target="ContentFrame">成绩管理</a>
	  <a href="${pageContext.request.contextPath}/clsMgmt/" target="ContentFrame">班级管理</a>
	</div>
	<div align="center">
			<iframe name="ContentFrame" scrolling="no" class="ContentFrame" src="${pageContext.request.contextPath}/welcome/" ></iframe>
	</div>
</body>

</html>