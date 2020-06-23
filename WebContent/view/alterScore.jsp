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
		<a href="${pageContext.request.contextPath}/scoreMgmt/">查询所有成绩</a>
	<a href="${pageContext.request.contextPath}/view/alterScore.jsp">成绩修改</a>
	<a href="${pageContext.request.contextPath}/view/addScore.jsp">成绩添加</a>
	<a href="#" onclick="deleteScore()">成绩删除</a>
</div>
	
	<form action="${pageContext.request.contextPath}/scoreMgmt/sno">
	<div class="txtb"   >
		<input type="text" name="sno" value="" placeholder="请输入想要修改的学号">			<br><br>
	</div>	
	<div align="center">
		<input class="input1"  type="submit" value="提交">
	</div>
	</form>
<table class="table1" border="1">
	<br><br>
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
				<td> ${score.getSno()}<a href="#">修改</a></td>
				<td> ${score.getSname()}<a href="#">修改</a></td>
				<td> ${score.getCno()}<a href="#">修改</a></td>
				<td> ${score.getCname()}<a href="#">修改</a></td>
				<td> ${score.getDegrees()}<a href="#">修改</a></td>
			</tr>		
	</c:forEach>	
	</tbody>
</table>
</body>
<script>
function deleteScore(){
        var sno = prompt("输入学号","");		
		if(sno)
			{
			window.location.href("${pageContext.request.contextPath}/scoreMgmt/delete?sno="+sno);
			}
		
		//跳转
	}
function alterSno()
{
	var sno = prompt("输入学号","");		
	if(sno)
		{
		window.location.href("${pageContext.request.contextPath}/scoreMgmt/update?sno="+sno);
		}
}
</script>
</html>