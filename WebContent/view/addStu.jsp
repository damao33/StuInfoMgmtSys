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
	<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
	<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>
<a href="${pageContext.request.contextPath}/stuInfo/" target="ContentFrame">查询所有</a>
	<br>
<p>
请输入想要添加的学生信息
</p>
<form action="">
	学号：<input type="text" name="Sno" value="">			<br><br>
	姓名：<input type="text" name="Sname" value="">		<br><br>
	性别：<input type="text" name="SSex" value="">		<br><br>
	出生日期：<input type="text" name="Sbirthday" value=""><br><br>
	班级号：<input type="text" name="Clno" value="">		<br><br>
	学院：<input type="text" name="Sschool" value="">		<br><br>
	专业：<input type="text" name="Sfaculty" value="">	<br><br>
<input type="submit" value="提交">

</form>
</body>
</html>