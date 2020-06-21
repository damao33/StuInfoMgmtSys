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
	<a href="#" onclick="selectByClass()">按班级查询</a>
	<a href="#" onclick="selectBySno()">按学号查询</a>
	<a href="${pageContext.request.contextPath}/stuInfo/">查询所有</a>
	
	<br>
	<table>
		<c:forEach items="${studentlist}" var="student">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>班级</td>			
			</tr>
			<tr align = "center">			
				<td> ${student.getSno()}</td>
				<td> ${student.getSname()}</td>
				<td> ${student.getSsex()}</td>
				<td> ${student.getSbirthdayString()}</td>
				<td> ${student.getClno()}</td>
			</tr>			
		</c:forEach>
	</table>
</body>
<script>
	function selectBySno()
	{
		var sno = prompt("输入学号","");
		if(sno)
		{
			alert(sno);
		}
		this.location.href="${pageContext.request.contextPath}/stuInfo/sno?sno="+sno;
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