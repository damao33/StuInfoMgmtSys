<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/selectStyle.css" />
<body>
	<div class="select">
	<a href="#" onclick="selectByClass()">按班级查询</a>
	<a href="#" onclick="selectBySno()">按学号查询</a>
	<a href="${pageContext.request.contextPath}/stuInfo/" target="ContentFrame">查询所有学生</a>
	</div>
	<br>
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
	<a href="${pageContext.request.contextPath}/stuInfo${mapname}?currentPage=${studentlist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/stuInfo${mapname}?currentPage=${studentlist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${studentlist.getPageNum()}/${studentlist.getPages()}页
	</div>
	
	
</body>
<script>
	function selectBySno()
	{
		var sno = prompt("输入学号","");
		if(sno)
		{
			alert(sno);
		}
		window.location.href="${pageContext.request.contextPath}/stuInfo/sno?sno="+sno;
	}
	function selectByClass()
	{
		var cls = prompt("输入班级","");
		if(cls)
		{
			alert(cls);
		}
		window.location.href="${pageContext.request.contextPath}/stuInfo/cls?cls="+cls;
	}	
</script>
</html>