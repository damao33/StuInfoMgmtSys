<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addStyle.css" />
<body>
<div class="lable">
<a href="${pageContext.request.contextPath}/sysMgmt/">查询所有用户</a>
<a href="${pageContext.request.contextPath}/view/addSysuser.jsp">增加用户</a>
<a href="#" onclick="deleteSysuser()">删除用户</a>	
<a href="${pageContext.request.contextPath}/view/alterSysuser.jsp">修改密码</a>
<a href="#" onclick="exitSys()">退出系统</a>
</div>
<br>

<form class="add-form" action="${pageContext.request.contextPath}/sysMgmt/insert">
<h1>
请输入将添加的管理员信息
</h1>
<div class="txtb">
	<input type="text" name="account" value="" placeholder="这里是账号">			
</div>
	<div class="txtb">
	<input type="password" name="password" value="" placeholder="这里是密码">		
	</div>	
		<div align="center">
		<input class="input1" type="submit" value="添加" >
		</div>
</form>
</body>
<script>
	function deleteSysuser(){
		var account = prompt("输入账号","");
		
		if(account)
			{
				window.location.href("${pageContext.request.contextPath}/sysMgmt/delete?account="+account);
			}
		//代码	
	}
	function exitSys()
	{
		var flag = confirm("是否确定退出系统？");
		if(flag)
		{
			window.top.location.href("${pageContext.request.contextPath}/login.jsp");
		}
		
	}
</script>
</html>