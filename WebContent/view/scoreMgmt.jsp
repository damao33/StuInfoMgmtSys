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
		<a href="${pageContext.request.contextPath}/scoreMgmt/">查询所有成绩</a>
		<a href="${pageContext.request.contextPath}/view/alterScore.jsp">成绩修改</a>
		<a href="${pageContext.request.contextPath}/view/addScore.jsp">成绩添加</a>
		<a href="${pageContext.request.contextPath}/view/delScore.jsp">成绩删除</a>
		<br>
		${controllerMsg}
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
	<a href="${pageContext.request.contextPath}/scoreMgmt${mapname}?currentPage=${scorelist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/scoreMgmt${mapname}?currentPage=${scorelist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${scorelist.getPageNum()}/${scorelist.getPages()}页
	</div>

</body>
<script>

	function alterScore(){
		//跳转
	}
	
	function addScore(){
		//跳转
	}
	
	function deleteScore(){
        var sno = prompt("输入学号","");		
        var cno = prompt("输入课程号","");	
    	var cno1=cno.replace("-","%2D");
		if(sno)
			{
			window.location.href("${pageContext.request.contextPath}/scoreMgmt/delete?sno="+sno+"&cno="+cno1);
			}
		
		//跳转
	}
</script>
</html>