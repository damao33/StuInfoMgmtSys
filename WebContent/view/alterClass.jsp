<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alterStyle.css" / >
<body>
<br>
<div class="select">
	<a href="${pageContext.request.contextPath}/view/addClass.jsp">添加班级信息</a>
	<a href="${pageContext.request.contextPath}/view/alterClass.jsp">修改班级信息</a>
	<a href="${pageContext.request.contextPath}/view/delClass.jsp">删除班级信息</a>	
</div>
<br>
	<form  action="">
		<div class="txtb"   >
		<input type="text"  name="Cno" value="" placeholder="请输入想要修改的班级号">			<br><br>
			</div>
			<div align="center">
			<input class="input1" type="submit" value="提交" >
			</div>

	</form>
<table class="table1"  border="1">
			<br><br>
	
			<thead>
				<th>班级号</th>
				<th>班级名</th>
				<th>班主任</th>
				<th>班主任教师号</th>					
			</thead>
		<tbody>
		<c:forEach items="${classlist.getList()}" var="cls">			
			<tr align = "center">			
				<td> ${cls.getClno()}</td>
				<td> ${cls.getClname()}</td>
				<td> ${cls.getHtname()}</td>
				<td> ${cls.getHtno()}</td>								
			</tr>		
		</c:forEach>
			</tbody>
	</table>
</body>
</html>