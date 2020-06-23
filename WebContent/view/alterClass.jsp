<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/alterStyle.css"/ >
<body>
	<div class="select">
		<a href="${pageContext.request.contextPath}/clsMgmt/">查询所有班级</a> <a
			href="${pageContext.request.contextPath}/view/addClass.jsp">添加班级信息</a>
		<a href="${pageContext.request.contextPath}/view/alterClass.jsp">修改班级信息</a>
		<a href="#" onclick=deleteClass()>删除班级信息</a>
	</div>
	<form action="${pageContext.request.contextPath}/clsMgmt/clno">
		<div class="txtb">
			<input type="text" name="clno" value="" placeholder="请输入想要修改的班级号">
			<br> <br>
		</div>
		<div align="center">
			<input class="input1" type="submit" value="提交">
		</div>

	</form>
	<table class="table1" border="1">
		<br> 
		${controllerMsg}

		<thead>
			<th>班级号</th>
			<th>班级名</th>
			<th>班主任</th>
			<th>班主任教师号</th>
		</thead>
		<tbody>

			<tr align="center">
				<td>${cls.getClno()}</td>
				<td>${cls.getClname()}<a href="#"onclick="alterClname()">修改</a></td>
				<td>${cls.getHtname()}<a href="#"onclick="alterHtname()">修改</a></td>
				<td>${cls.getHtno()}<a href="#"onclick="alterHtno()">修改</a></td>
			</tr>

		</tbody>
	</table>
</body>
<script>
function deleteClass()//-删除-班级信息
{
	var clno = prompt("输入班级号","");	
	if(clno)
		{
		window.location.href("${pageContext.request.contextPath}/clsMgmt/delete?clno="+clno);
		}
	//代码	  
}
function alterClname()
{
	var clname = prompt("输入要将班级名修改为：","");	
	if(clname)
		{
		window.location.href("${pageContext.request.contextPath}/clsMgmt/update?clno=${cls.getClno()}&clname="+clname);
		}
}
function alterHtno()
{
	var htno = prompt("输入要将教师号修改为：","");	
	if(htno)
		{
		window.location.href("${pageContext.request.contextPath}/clsMgmt/update?clno=${cls.getClno()}&htno="+htno);
		}
}
function alterHtname()
{
	var htname = prompt("输入要将教师姓名修改为：","");	
	if(htname)
		{
		window.location.href("${pageContext.request.contextPath}/clsMgmt/update?clno=${cls.getClno()}&htname="+htname);
		}
}
</script>
</html>