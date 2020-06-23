<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
		<a href="${pageContext.request.contextPath}/scoreMgmt/">查询所有成绩</a>
	<a href="${pageContext.request.contextPath}/view/alterScore.jsp">成绩修改</a>
	<a href="${pageContext.request.contextPath}/view/addScore.jsp">成绩添加</a>
	<a href="${pageContext.request.contextPath}/view/delScore.jsp">成绩删除</a>
	<br>
	
	<form action="">
		请输入想要修改的学号：<input type="text" name="Sno" value="">			<br><br>
			
		<input type="submit" value="提交">
	</form>
<table class="table1" border="1">
	<thead>
				<th>学号</th>
				<th>姓名</th>
				<th>课程号</th>
				<th>课程名</th>
				<th>成绩</th>					
				
	</thead>
	<tbody>
		<c:forEach items="${scorelist.getList()}" var="score">			
			<tr align = "center">			
				<td> ${score.getSno()}</td>
				<td> ${score.getSname()}</td>
				<td> ${score.getCno()}</td>
				<td> ${score.getCname()}</td>
				<td> ${score.getDegrees()}</td>
				
			</tr>		
		</c:forEach>
	</tbody>
</table>
</body>
</html>