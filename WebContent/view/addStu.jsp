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
	<a href="${pageContext.request.contextPath}/stuMgmt/">查询所有学生</a>
	<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
	<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>
	<a href="#" onclick="deleteStudent()">删除学生信息</a>
	</div>
	<br>
	${controllerMsg}
<form class="add-form" action="${pageContext.request.contextPath}/stuMgmt/insert" >
<h1>
<p>
请输入想要添加的学生信息
</p>
</h1>
<div class="txtb">	
	<input type="text" name="sno" value="" placeholder="这里是学号">			
</div>
<div class="txtb">		
	<input type="text" name="sname" value="" placeholder="这里是姓名">		
</div>	
<div class="txtb">		
	<input type="text" name="ssex" value="" placeholder="这里是性别">		
</div>	
<div class="txtb">		
	<input type="text" name="sbirthday" value="" placeholder="这里是出生日期">
</div>	
<div class="txtb">		
	<input type="text" name="clno" value="" placeholder="这里是班级">		
</div>
<div class="txtb">	
	<input type="text" name="sschool" value="" placeholder="这里是学院">		
</div>
<div class="txtb">		
	<input type="text" name="sfaculty" value="" placeholder="这里是专业">	
	
</div>
	<div align="center">
		<input class="input1" type="submit" value="提交" >
		</div>

</form>
</body>
<script>
	function deleteStudent(){
		var sno= prompt("输入学号","");
		
		if(sno)
			{
			window.location.href("${pageContext.request.contextPath}/stuMgmt/delete?sno="+sno);
			}
	}
</script>
</html>