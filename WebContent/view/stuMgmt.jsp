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
	<a href="#" onclick="addStuInfo()">添加学生信息</a>
<br>
	<a href="#" onclick="alterStuInfo()">修改学生信息</a>
<br>
	<a href="#" onclick="addStuFacInfo()">添加学生系部信息</a>
<br>
	<a href="#" onclick="alterStuFacInfo()">修改学生系部信息</a>
<br>
	<a href="#" onclick="addStuSchInfo()">添加学生学院信息</a>
<br>
	<a href="#" onclick="alterStuSchInfo()">修改学生学院信息</a>
<br>
	<table class="table1"  border="1">
			<thead>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>班级</th>		
				<th>所在学院</th>		
				<th>所在系部</th>		
			</thead>
		<tbody>
		<c:forEach items="${studentlist.getList()}" var="student">			
			<tr align = "center">			
				<td> ${student.getSno()}</td>
				<td> ${student.getSname()}</td>
				<td> ${student.getSsex()}</td>
				<td> ${student.getSbirthdayString()}</td>
				<td> ${student.getClno()}</td>
				<td> ${student.getSschool()}</td>
				<td> ${student.getSfaculty()}</td>
			</tr>		
		</c:forEach>
			</tbody>
	</table>

</body>

<script>
	function addStuInfo()//-添加-学生信息
	{
		var sno = prompt("输入学号","学号"),
			sname = prompt("输入姓名","姓名"),
			ssex = prompt("输入性别","性别"),
			sbirth = prompt("输入出生日期","出生日期"),
			sclass = prompt("输入班级","班级");
		if(sno)
		{
			alert("学号为："+sno+"的信息已输入");
		}
		//代码
		  
	}
	
	function alterStuInfo()//-更改-学生信息
	{
		var sno = prompt("输入学号","学号"),
			sname = prompt("输入姓名","姓名");			
			
		if(sno)
		{
			//代码
		}
		else
		{
			alert("系统中不存在该学生");//代码
		}		
	}
	
	function addStuFacInfo()//-添加-学生系部信息 faculty是系
	{
		var sno = prompt("输入学号","学号"),
			sname = prompt("输入姓名","姓名");			
			
		if(sno)
		{
			//代码
		}
		else
		{
			alert("系统中不存在该学生");//代码
		}		
	}	
	
	function alterStuFacInfo()//-修改-学生系部信息 faculty是系
	{
		var sno = prompt("输入学号",""),
			sname = prompt("输入姓名","");				
		if(sno)
		{
			alert("不能输入空值");
		}
		else
		{
			//代码
		}		
	}
	
	function addStuSchInfo()//-添加-学生学院信息school学院
	{
		var sno = prompt("输入学号",""),
			sname = prompt("输入姓名","");			
			
		if(sno)
		{
			//代码
		}
		else
		{
			alert("系统中不存在该学生");//代码
		}		
	}
	
	function alterStuSchInfo()//-修改-学生学院信息 
	{
		var sno = prompt("输入学号",""),
			sname = prompt("输入姓名","");			
			
		if(sno)
		{
			//代码
		}
		else
		{
			alert("系统中不存在该学生");
		}		
	}
	
</script>
</html>