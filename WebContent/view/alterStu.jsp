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
	<a href="${pageContext.request.contextPath}/stuInfo/">查询所有学生</a>
	<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
	<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>

	<br>
	<form action="">
		请输入想要修改的学号：<input type="text" name="Sno" value="">			<br><br>
			
		<input type="submit" value="提交">
	</form>
<table class="table1" border="1">
	<thead>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>班级</th>		
				<th>所在学院</th>		
				<th>所在系部 </th>	
				
	</thead>
	<tbody>
		<c:forEach items="${studentlist.getList()}" var="student">			
			<tr align = "center">			
				<td> ${student.getSno()} 			<a herf="">修改</a></td>
				<td> ${student.getSname()} 			<a herf="">修改</a></td>
				<td> ${student.getSsex()} 			<a herf="">修改</a></td>
				<td> ${student.getSbirthdayString()} <a herf="">修改</a></td>
				<td> ${student.getClno()}			 <a herf="">修改</a></td>
				<td> ${student.getSschool()} 		<a herf="">修改</a></td>
				<td> ${student.getSfaculty()}		 <a herf="">修改</a></td>
			</tr>		
		</c:forEach>
	</tbody>
</table>
</body>
</html>