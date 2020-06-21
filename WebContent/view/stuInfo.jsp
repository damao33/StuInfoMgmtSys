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
	<a href="${pageContext.request.contextPath}/stuInfo/class">按班级查询</a>
	<a href="#" onclick="selectBySno()">按学号查询</a>
	<a href="${pageContext.request.contextPath}/stuInfo/">查询所有</a>
	
	<br>
	<c:forEach items="${studentlist}" var="student">
		${student}<br>
	</c:forEach>
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