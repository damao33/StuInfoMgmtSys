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

<br>
	<a href="#" onclick="addClassInfo()">添加班级信息</a>
<br>
	<a href="#" onclick="alterClassInfo()">修改班级信息</a>
<br>
	<a href="#" onclick="deleteClassInfo()">删除班级信息</a>
<br>	

<table class="table1"  border="1">
			<thead>
				<th>班级号</th>
				<th>班级名</th>
				<th>班主任</th>
				<th>班主任教师号</th>					
			</thead>
		<tbody>
		<c:forEach items="${classlist.getList()}" var="class">			
			<tr align = "center">			
				<td> ${class.getClno()}</td>
				<td> ${class.getClname()}</td>
				<td> ${class.getHtname()}</td>
				<td> ${class.getHtno()}</td>								
			</tr>		
		</c:forEach>
			</tbody>
	</table>

</body>
<script>
function addStuInfo()//-添加-班级信息
{
	var Cno = prompt("输入班级号",""),
		Cname = prompt("输入班级名称",""),
		Htname = prompt("输入班主任名称",""),
		Htno = prompt("输入班主任教师号","");
	
	//代码	  
}

function alterClassInfo()//-修改-班级信息
{
	var Cno = prompt("输入班级号","");
	//代码	  
}

function deleteClassInfo()//-删除-班级信息
{
	var Cno = prompt("输入班级号","");
	
	if(cno)
		{
			alert("是否确认删除学号为"+cno+"的班级");
		}
	//代码	  
}
</script>
</html>