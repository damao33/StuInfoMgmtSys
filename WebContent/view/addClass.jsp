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
	<a href="${pageContext.request.contextPath}/view/addClass.jsp">添加班级信息</a>
	<a href="#" onclick="alterClassInfo()">修改班级信息</a>
	<a href="#" onclick="deleteClassInfo()">删除班级信息</a>	
<br>
<p>
请输入想要添加的班级信息
</p>
<form action="">
	班级号：<input type="text" name="Clno" value="">			<br><br>
	班级名：<input type="text" name="Clname" value="">			<br><br>
	班主姓名：<input type="text" name="Htname" value="">		<br><br>
	班主任教师号：<input type="text" name="Htno" value="">		<br><br>	
<input type="submit" value="提交">
</form>
</body>
</html>