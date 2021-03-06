<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/alterStyle.css" / >
<body>
<div class="select">
		<a href="${pageContext.request.contextPath}/view/addStu.jsp">添加学生信息</a>
	<a href="${pageContext.request.contextPath}/view/alterStu.jsp">修改学生信息</a>
	<a href="${pageContext.request.contextPath}/stuInfo/" target="ContentFrame">查询所有学生</a>
</div>
<br>	
	<table class="table1"  border="1">
			<colgroup>
				<col width="5%" />
				<col width="10%" />
				<col width="5%" />
				<col width="20%" />
				<col width="10%" />
				<col width="30%" />
				<col width="20%" />
			</colgroup>			
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
	<div class="passage">	
	<a href="${pageContext.request.contextPath}/stuMgmt${mapname}?currentPage=${studentlist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/stuMgmt${mapname}?currentPage=${studentlist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${studentlist.getPageNum()}/${studentlist.getPages()}页
	</div>
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
</script>
</html>