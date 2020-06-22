<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addStuStyle.css" / >
<body>

	<div class="lable">
	<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
	<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>
	</div>

<form class="add-form" action="" >
<h1>
请输入想要添加的学生信息
</h1>
<div class="txtb">	
	<input type="text" name="Sno" value="" placeholder="这里是学号">			
</div>
<div class="txtb">		
	<input type="text" name="Sname" value="" placeholder="这里是姓名">		
</div>	
<div class="txtb">		
	<input type="text" name="SSex" value="" placeholder="这里是性别">		
</div>	
<div class="txtb">		
	<input type="text" name="Sbirthday" value="" placeholder="这里是出生日期">
</div>	
<div class="txtb">		
	<input type="text" name="Clno" value="" placeholder="这里是班级">		
</div>
<div class="txtb">	
	<input type="text" name="Sschool" value="" placeholder="这里是学院">		
</div>
<div class="txtb">		
	<input type="text" name="Sfaculty" value="" placeholder="这里是专业">	
	
</div>
	<div align="center">
		<input class="input1" type="submit" value="提交" >
		</div>

</form>
</body>
</html>