<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addStyle.css" / >
<body>
	<div class="lable">
	<a href="${pageContext.request.contextPath}/view/addClass.jsp">添加班级信息</a>
	<a href="${pageContext.request.contextPath}/view/alterClass.jsp">修改班级信息</a>
	<a href="${pageContext.request.contextPath}/view/delClass.jsp">删除班级信息</a>	
	</div>
	<form class="add-form" action="">
		<h1>请输入想要添加的班级信息</h1>
		<div class="txtb">
			<input type="text" name="Clno" value="" placeholder="这里是班级号">				
		</div>
		<div class="txtb">
			<input type="text" name="Clname" value="" placeholder="这里是班级名">			
		</div>
		<div class="txtb">
			<input type="text" name="Htname" value="" placeholder="这里是班主任姓名">		
		</div>
		<div class="txtb">
			<input type="text" name="Htno" value="" placeholder="这里是班主任教师号">		
		</div>
		<div align="center">
		<input class="input1" type="submit" value="提交" >
		</div>
	</form>
</body>
</html>