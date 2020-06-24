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
	<a href="#" onclick="deleteCoz()">删除课程信息</a>
</div>
	<form action="${pageContext.request.contextPath}/cozMgmt/cno">
	<div class="txtb"   >
		<input type="text" name="cno" value="" placeholder="请输入想要修改的课程号">			<br><br>
	</div>	
	<div align="center">
		<input  class="input1" type="submit" value="提交">
	</div>
	</form>
	<center>${controllerMsg}</center>
<table class="table1" border="1">
	<thead>
				<th>课程号</th>
				<th>课程名</th>
				<th>任课教师教师号</th>
				<th>任课教师姓名</th>				
	</thead>
	<tbody>
				
			<tr align = "center">			
				<td> ${course.getCno()}		</td>
				<td> ${course.getCname()}	<a href="#"onclick="alterCname()">修改</a></td>
				<td> ${course.getTno()}		<a href="#"onclick="alterTno()">修改</a></td>
				<td> ${course.getTname()}	<a href="#"onclick="alterTname()">修改</a></td>		
			</tr>		
		
			</tbody>
</table>
</body>
<script>
function deleteCoz()	//-删除-课程信息
	{
		var cno = prompt("输入课程号","")
		var cno_new=cno.replace("-","%2D")
		if(cno){
			window.location.href("${pageContext.request.contextPath}/cozMgmt/delete?cno="+cno_new);
		} 
	}

function alterCname()
{
	var cname = prompt("输入要将课程名修改为：","");	
	var cno="${course.getCno()}";
	var cno1=cno.replace("-","%2D");
	var url=encodeURI("${pageContext.request.contextPath}/cozMgmt/update?cno="+cno1+"&cname="+cname);
	if(cname)
		{
		//alert(url);
		//window.location.href(url);
		window.location.href("${pageContext.request.contextPath}/cozMgmt/update?cno="+cno1+"&cname="+cname);
		}
}
function alterTno()
{
	var tno = prompt("输入要将教师号修改为：","");	
	var cno="${course.getCno()}";
	var cno1=cno.replace("-","%2D");
	if(tno)
		{
		window.location.href("${pageContext.request.contextPath}/cozMgmt/update?cno="+cno1+"&tno="+tno);
		}
}
function alterTname()
{
	var tname = prompt("输入要将教师姓名修改为：","");	
	var cno="${course.getCno()}";
	var cno1=cno.replace("-","%2D");
	if(tname)
		{
		window.location.href("${pageContext.request.contextPath}/cozMgmt/update?cno="+cno1+"&tname="+tname);
		}
}
</script>
</html>