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
		<a href="${pageContext.request.contextPath}/scoreInfo/">查询所有成绩</a>
		<a href="#" onclick="selectByCno()">按课程查询成绩</a>
	</div>	
	<table class="table1"  border="1">
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
	<div class="passage">	
	<a href="${pageContext.request.contextPath}/scoreInfo${mapname}?currentPage=${scorelist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/scoreInfo${mapname}?currentPage=${scorelist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${scorelist.getPageNum()}/${scorelist.getPages()}页
	</div>

</body>
<script>
	function selectByCno(){
        var cno = prompt("输入课程编号：","");		
		if(cno)
			{
			window.location.href("${pageContext.request.contextPath}/scoreInfo/cno?cno="+cno);
			}
	}
</script>
</html>