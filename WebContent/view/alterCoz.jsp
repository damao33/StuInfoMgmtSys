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
	<a href="${pageContext.request.contextPath}/cozMgmt/">查询所有课程</a>
	<a href="${pageContext.request.contextPath}/view/addCoz.jsp">添加课程信息</a>
	<a href="${pageContext.request.contextPath}/view/alterCoz.jsp">修改课程信息</a>
	<a href="${pageContext.request.contextPath}/view/delCoz.jsp">删除课程信息</a>
	<br>
	<form action="">
		请输入想要修改的课程号：<input type="text" name="Cno" value="">			<br><br>
			
		<input type="submit" value="提交">
	</form>
<table class="table1" border="1">
	<thead>
				<th>课程号</th>
				<th>课程名</th>
				<th>任课教师教师号</th>
				<th>任课教师姓名</th>				
	</thead>
	<tbody>
		<c:forEach items="${courselist.getList()}" var="course">			
			<tr align = "center">			
				<td> ${course.getCno()}		<a herf="">修改</a></td>
				<td> ${course.getCname()}	<a herf="">修改</a></td>
				<td> ${course.getTno()}		<a herf="">修改</a></td>
				<td> ${course.getTname()}	<a herf="">修改</a></td>				
			</tr>		
		</c:forEach>
			</tbody>
</table>
</body>
</html>