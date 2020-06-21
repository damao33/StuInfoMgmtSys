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
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>班级</td>			
			</tr>
		<c:forEach items="${studentlist.getList()}" var="student">			
			<tr align = "center">			
				<td> ${student.getSno()}</td>
				<td> ${student.getSname()}</td>
				<td> ${student.getSsex()}</td>
				<td> ${student.getSbirthdayString()}</td>
				<td> ${student.getClno()}</td>
			</tr>			
		</c:forEach>
	</table>
	<div>
	<a href="${pageContext.request.contextPath}/stuInfo${mapname}?currentPage=${studentlist.getPrePage()}${attributeType}${attributeValue}">上一页</a>		
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
		this.location.href="${pageContext.request.contextPath}/stuInfo/sno?sno="+sno;
	}
	function selectByClass()
	{
		cls = prompt("输入班级","");
		if(cls)
		{
			alert(cls);
		}
		window.location.href="${pageContext.request.contextPath}/stuInfo/cls?cls="+cls;
	}	
</script>
</html>