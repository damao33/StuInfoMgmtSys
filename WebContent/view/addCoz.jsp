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
	<a href="${pageContext.request.contextPath}/view/addCoz.jsp">添加课程信息</a>
	<a href="#" onclick="alterCozInfo()">修改课程信息</a>
	<a href="#" onclick="deleteCozInfo()">删除课程信息</a>
<p>
请输入想要添加的课程信息
</p>
<form action="">
	课程号：			<input type="text" name="Cno" 		value="">				<br><br>
	课程名：			<input type="text" name="Cname" 	value="">				<br><br>
	任课教师教师号：		<input type="text" name="Tno" 		value="">				<br><br>
	任课教师教师姓名：	<input type="text" name="Tname" value="">				<br><br>
<input type="submit" value="提交">

</form>
</body>
</html>