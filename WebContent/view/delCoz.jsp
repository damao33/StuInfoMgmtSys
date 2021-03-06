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
<div class="select">
	<a href="${pageContext.request.contextPath}/cozMgmt/">查询所有课程</a>	
	<a href="${pageContext.request.contextPath}/view/addCoz.jsp">添加课程信息</a>
	<a href="${pageContext.request.contextPath}/view/alterCoz.jsp">修改课程信息</a>
	<a href="${pageContext.request.contextPath}/view/delCoz.jsp">删除课程信息</a>
</div>
<br>
<table class="table1"  border="1">
			<colgroup>
				<col width="15%" />
				<col width="60%" />
				<col width="10%" />
				<col width="15%" />
			</colgroup>
			<thead>
				<th>课程号</th>
				<th>课程名</th>
				<th>教师号</th>
				<th>任课教师</th>					
			</thead>
		<tbody>
		<c:forEach items="${courselist.getList()}" var="course">			
			<tr align = "center">			
				<td> ${course.getCno()}</td>
				<td> ${course.getCname()}</td>
				<td> ${course.getTno()}</td>
				<td> ${course.getTname()}</td>				
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
	



</script>
</html>