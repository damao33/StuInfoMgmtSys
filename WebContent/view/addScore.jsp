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
	<a href="${pageContext.request.contextPath}/scoreMgmt/">查询所有成绩信息</a>
	<a href="${pageContext.request.contextPath}/view/alterScore.jsp">成绩修改</a>
	<a href="${pageContext.request.contextPath}/view/addScore.jsp">成绩添加</a>
	<a href="${pageContext.request.contextPath}/view/delScore.jsp">成绩删除</a>
</div>

<form class="add-form" action="">
<h1>
请输入想要添加的成绩信息
</h1>
<div class="txtb">	
	<input type="text" name="Sno" value="" placeholder="这里是学号" >	
	</div>	
<div class="txtb">		
	<input type="text" name="Sname" value="" placeholder="这里是姓名">		
	</div>	
<div class="txtb">		
	<input type="text" name="Cno" value="" placeholder="这里是课程号">		
</div>	
<div class="txtb">	
	<input type="text" name="Cname" value="" placeholder="这里是课程名">		
</div>		
<div class="txtb">		
	<input type="text" name="Degrees" value="" placeholder="这里是成绩">		
</div>		
	<div align="center">
		<input class="input1" type="submit" value="提交" >
		</div>
</form>
</body>
</html>