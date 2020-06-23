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
		<a href="${pageContext.request.contextPath}/stuMgmt/">查询所有学生</a>
		<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
		<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>
		<a href="#" onclick="deleteStudent()">删除学生信息</a>
	</div>	
	<br>
	<form action="${pageContext.request.contextPath}/stuMgmt/ssno">
		<div class="txtb"   >
		<input type="text" name="sno" value="" placeholder="请输入想要修改的学号">			<br><br>
			</div>
		<div align="center">
		<input class="input1" type="submit" value="提交">
		</div>
	</form>

	<table class="table1" border="1">
	<br>
	<br>
	${controllerMsg}
	<thead>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>班级</th>		
				<th>所在学院</th>		
				<th>所在系部 </th>	
				
	</thead>
	<tbody>	
			<tr align = "center">			
				<td> ${student.getSno()} 			</td>
				<td> ${student.getSname()} 			<a href="#"onclick="alterSname()" >修改</a></td>
				<td> ${student.getSsex()} 			<a href="#"onclick="alterSsex()">修改</a></td>
				<td> ${student.getSbirthdayString()} <a href="#"onclick="alterSbirthday()">修改</a></td>
				<td> ${student.getClno()}			 <a href="#"onclick="alterClno()">修改</a></td>
				<td> ${student.getSschool()} 		<a href="#"onclick="alterSschool()">修改</a></td>
				<td> ${student.getSfaculty()}		 <a href="#"onclick="alterSfaculty()">修改</a></td>
			</tr>		

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
	function deleteStudent(){
		var sno= prompt("输入学号","");
		
		if(sno)
			{
			window.location.href("${pageContext.request.contextPath}/stuMgmt/delete?sno="+sno);
			}
		
		//代码	
	}
	function alterSname(){


		var sname= prompt("输入要将姓名修改为","");
		//在这给sname设定一下编码 UTF8不行就GB2312，方法百度（JS 设定编码）
		
		if(sname)
			{
				var ssname=encodeURI(sname);
				window.location.href("${pageContext.request.contextPath}/stuMgmt/update?sno=${student.getSno()}&sname="+ssname);
			}
		
		//代码	
	}
	function alterSsex(){


		var ssex= prompt("输入要将性别修改为","");
		//在这给sname设定一下编码 UTF8不行就GB2312，方法百度（JS 设定编码）
		
		if(ssex)
			{
				var sssex=encodeURI(ssex);
				window.location.href("${pageContext.request.contextPath}/stuMgmt/update?sno=${student.getSno()}&ssex="+sssex);
			}
		
		//代码	
	}
	function alterSbirthday(){


		var sbirthday= prompt("输入要将生日修改为","");
		//在这给sname设定一下编码 UTF8不行就GB2312，方法百度（JS 设定编码）
		
		if(sbirthday){
		
			var ssbirthday=encodeURI(sbirthday);
				window.location.href("${pageContext.request.contextPath}/stuMgmt/update?sno=${student.getSno()}&sbirthday="+ssbirthday);
			}
		
		//代码	
		}

	function alterClno(){


		var clno= prompt("输入要将班级号修改为","");
		//在这给sname设定一下编码 UTF8不行就GB2312，方法百度（JS 设定编码）
		
		if(clno)
			{
				var sclno=encodeURI(clno);
				window.location.href("${pageContext.request.contextPath}/stuMgmt/update?sno=${student.getSno()}&clno="+sclno);
			}
		
		//代码	
	}	
	function alterSschool(){


		var sschool= prompt("输入要将学院修改为","");
		//在这给sname设定一下编码 UTF8不行就GB2312，方法百度（JS 设定编码）
		
		if(sschool)
			{
				var ssschool=encodeURI(sschool);
				window.location.href("${pageContext.request.contextPath}/stuMgmt/update?sno=${student.getSno()}&sschool="+ssschool);
			}
		
		//代码	
	}	
	function alterSfaculty(){


		var sfaculty= prompt("输入要将专业修改为","");
		//在这给sname设定一下编码 UTF8不行就GB2312，方法百度（JS 设定编码）
		
		if(sfaculty)
			{
				var ssfaculty=encodeURI(sfaculty);
				window.location.href("${pageContext.request.contextPath}/stuMgmt/update?sno=${student.getSno()}&sfaculty="+ssfaculty);
			}
		
		//代码	
	}
	
	
</script>
</html>