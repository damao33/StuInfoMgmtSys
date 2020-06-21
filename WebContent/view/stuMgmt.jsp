<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
我是学生管理
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