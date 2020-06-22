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
<br>
	<div class="lable">
		<a href="${pageContext.request.contextPath}/view/addCoz.jsp">添加课程信息</a>
	<a href="${pageContext.request.contextPath}/view/alterCoz.jsp">修改课程信息</a>
	<a href="${pageContext.request.contextPath}/view/delCoz.jsp">删除课程信息</a>
	</div>

<form class="add-form" action="${pageContext.request.contextPath}/cozMgmt/insert">
	<h1>请输入想要添加的课程信息</h1>
	<div class="txtb">	
		<input type="text" name="cno" 		value="" placeholder="这里是课程号">				
	</div>	
	<div class="txtb">	
		<input type="text" name="cname" 	value="" placeholder="这里是课程名">				
	</div>
	<div class="txtb">
		<input type="text" name="tno" 		value="" placeholder="这里是任课教师教师号">				
	</div>
	<div class="txtb">
		<input type="text" name="tname" value="" placeholder="这里是任课教师教师姓名">				
	</div>	
		<div align="center">
		<input class="input1" type="submit" value="提交" >
		</div>

</form>
</body>
</html>