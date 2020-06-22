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
我是课程管理
<br>
	<a href="#" onclick="addCozInfo()">添加课程信息</a>
<br>
	<a href="#" onclick="alterCozInfo()">修改课程信息</a>
<br>
	<a href="#" onclick="deleteCozInfo()">删除课程信息</a>
<br>

<table class="table1"  border="1">
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

</body>
<script>
function addCozInfo()//-添加-课程信息
{
	var Cno   = prompt("输入课程号",""),
		Cname = prompt("输入课程名称",""),
		Tno   = prompt("输入任课教师名称",""),
		Tname = prompt("输入任课教师编号","");	
	//代码	  
}

function alterCozInfo()//-修改-课程信息
{
	var Cno = prompt("输入课程号","")
	var r = confirm("您确定修改课程号为"+Cno+"的信息吗？")	
	if (r == true) 
		{	
		//代码	
		}   
}

function deleteCozInfo()	//-删除-课程信息
{
	var Cno = prompt("输入课程号","")
	var r = confirm("您确定删除"+Cno+"该课程吗？")
	if(Cno){
		if (r == true) {
	
	} else {
		
	}  
}
	else{
		alert("不存在");
	}
	
	}
	
	



</script>
</html>