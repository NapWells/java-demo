<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="getScore.jsp">
		<table>
		<tr><td>学号</td><td><input type="text" name="stuId"></td></tr>
		<tr><td>姓名</td><td><input type="text" name="stuName"></td></tr>
		<tr><td>课程名称</td><td><input type="text" name="course"></td></tr>
		<tr><td>成绩</td><td><input type="text" name="grade"></td></tr>
		<tr><td colspan="2" ALIGN="center"> <input type="submit" value="提交"> <input type="reset"
			value="重置"></td></tr>
		</table>
	</form>
</body>
</html>
