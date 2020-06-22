<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
我是班级资料管理
<br>
	<a href="#" onclick="addClassInfo()">添加班级信息</a>
<br>
	<a href="#" onclick="alterClassInfo()">修改班级信息</a>
<br>
	<a href="#" onclick="deleteClassInfo()">删除班级信息</a>
<br>	

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