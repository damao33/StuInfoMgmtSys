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
		<a href="${pageContext.request.contextPath}/scoreMgmt/">查询所有成绩信息</a>
	<a href="${pageContext.request.contextPath}/view/alterScore.jsp">成绩修改</a>
	<a href="${pageContext.request.contextPath}/view/addScore.jsp">成绩添加</a>
	<a href="${pageContext.request.contextPath}/view/delScore.jsp">成绩删除</a>
	<br>
<p>
请输入想要添加的成绩信息
</p>
<form action="">
	学号：<input type="text" name="Sno" value="">			<br><br>
	姓名：<input type="text" name="Sname" value="">		<br><br>
	课程号：<input type="text" name="Cno" value="">		<br><br>
	课程名：<input type="text" name="Cname" value="">		<br><br>
	成绩：<input type="text" name="Degrees" value="">		<br><br>
	
	<input type="submit" value="提交">

</form>
</body>
</html>