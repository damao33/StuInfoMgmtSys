<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<br>
		<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
	<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>
	<a href="#" onclick="addStuFacInfo()">添加学生系部信息</a>
	<a href="#" onclick="alterStuFacInfo()">修改学生系部信息</a>
	<a href="#" onclick="addStuSchInfo()">添加学生学院信息</a>
	<a href="#" onclick="alterStuSchInfo()">修改学生学院信息</a>
	<table class="table1"  border="1">
			<thead>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>班级</th>		
				<th>所在学院</th>		
				<th>所在系部</th>		
			</thead>
		<tbody>
		<c:forEach items="${studentlist.getList()}" var="student">			
			<tr align = "center">			
				<td> ${student.getSno()}</td>
				<td> ${student.getSname()}</td>
				<td> ${student.getSsex()}</td>
				<td> ${student.getSbirthdayString()}</td>
				<td> ${student.getClno()}</td>
				<td> ${student.getSschool()}</td>
				<td> ${student.getSfaculty()}</td>
			</tr>		
		</c:forEach>
			</tbody>
	</table>
	<div class="passage">	
	<a href="${pageContext.request.contextPath}/stuMgmt${mapname}?currentPage=${studentlist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/stuMgmt${mapname}?currentPage=${studentlist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${studentlist.getPageNum()}/${studentlist.getPages()}页
	</div>
</body>

</html>