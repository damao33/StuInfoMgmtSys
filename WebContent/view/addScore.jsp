<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addStyle.css" / >
<body>
<div class="lable">
	<a href="${pageContext.request.contextPath}/scoreMgmt/">查询所有成绩</a>
	<a href="${pageContext.request.contextPath}/view/alterScore.jsp">成绩修改</a>
	<a href="${pageContext.request.contextPath}/view/addScore.jsp">成绩添加</a>
		<a href="#" onclick="deleteScore()">成绩删除</a>
</div>

<form class="add-form" action="${pageContext.request.contextPath}/scoreMgmt/insert">
<h1>
请输入想要添加的成绩信息
</h1>
<div class="txtb">	
	<input type="text" name="sno" value="" placeholder="这里是学号" >	
	</div>	
<div class="txtb">		
	<input type="text" name="sname" value="" placeholder="这里是姓名">		
	</div>	
<div class="txtb">		
	<input type="text" name="cno" value="" placeholder="这里是课程号">		
</div>	
<div class="txtb">	
	<input type="text" name="cname" value="" placeholder="这里是课程名">		
</div>		
<div class="txtb">		
	<input type="text" name="degrees" value="" placeholder="这里是成绩">		
</div>		
	<div align="center">
		<input class="input1" type="submit" value="提交" >
		</div>
</form>
</body>
<script>
function deleteScore(){
        var sno = prompt("输入学号","");		
		if(sno)
			{
			window.location.href("${pageContext.request.contextPath}/scoreMgmt/delete?sno="+sno);
			}
		
		//跳转
	}
</script>
</html>