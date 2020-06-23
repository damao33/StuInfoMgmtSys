<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sysMgmtStyle.css" />
<body>
<div class="select">
<a href="${pageContext.request.contextPath}/sysMgmt/">查询所有用户</a>
<a href="${pageContext.request.contextPath}/view/addSysuser.jsp">增加用户</a>
<a href="#" onclick="deleteSysuser()">删除用户</a>	
<a href="${pageContext.request.contextPath}/view/alterSysuser.jsp">修改密码</a>
<a href="#" onclick="exitSys()">退出系统</a>
</div>
	<br>
	${controllerMsg}
	<table class="table1"  border="1">
			<thead>
				<th>账户</th>
				<th>密码</th>					
			</thead>
		<tbody>
			<c:forEach items="${sysuserlist.getList()}" var="sysuser">			
				<tr align = "center">			
					<td> ${sysuser.getAccount()}</td>
					<td> ${sysuser.getPassword()}</td>					
				</tr>		
			</c:forEach>
		</tbody>
	</table>
	<div class="passage">	
	<a href="${pageContext.request.contextPath}/sysMgmt${mapname}?currentPage=${sysuserlist.getPrePage()}${attributeType}${attributeValue}" >上一页</a>		
	<a href="${pageContext.request.contextPath}/sysMgmt${mapname}?currentPage=${sysuserlist.getNextPage()}${attributeType}${attributeValue}">下一页</a>
	第${sysuserlist.getPageNum()}/${sysuserlist.getPages()}页
	</div>
</body>
<script>
	function deleteSysuser(){
		var account = prompt("输入账号","");
		
		if(account)
			{
				alert("account："+account);
			}
		window.location.href("${pageContext.request.contextPath}/sysMgmt/delete?account="+account);
		//代码	
	}
	
	function alterPw(){
		//代码
	}
	
	function exitSys(){
		//退出系统
	}
	
	
</script>
</html>