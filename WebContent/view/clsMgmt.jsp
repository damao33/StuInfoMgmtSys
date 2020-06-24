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
		<a href="${pageContext.request.contextPath}/clsMgmt/">查询所有班级</a>
		<a href="${pageContext.request.contextPath}/view/addClass.jsp">添加班级信息</a>
		<a href="${pageContext.request.contextPath}/view/alterClass.jsp">修改班级信息</a>
		<a href="#" onclick=deleteClass()>删除班级信息</a>	
	</div>
	<br>
	<center>${controllerMsg}</center>
	<table class="table1"  border="1">
			<thead>
				<th>班级号</th>
				<th>班级名</th>
				<th>班主任</th>
				<th>班主任教师号</th>					
			</thead>
		<tbody>
		<c:forEach items="${classlist.getList()}" var="cls">			
			<tr align = "center">			
				<td> ${cls.getClno()}</td>
				<td> ${cls.getClname()}</td>
				<td> ${cls.getHtname()}</td>
				<td> ${cls.getHtno()}</td>								
			</tr>		
		</c:forEach>
			</tbody>
	</table>
	<div class="passage">	
	<a href="${pageContext.request.contextPath}/clsMgmt${mapname}?currentPage=${classlist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/clsMgmt${mapname}?currentPage=${classlist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${classlist.getPageNum()}/${classlist.getPages()}页
	</div>

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

function deleteClass()//-删除-班级信息
{
	var clno = prompt("输入班级号","");	
	if(clno)
		{
		window.location.href("${pageContext.request.contextPath}/clsMgmt/delete?clno="+clno);
		}
	//代码	  
}
</script>
</html>