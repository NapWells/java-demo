<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getInfo.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	String pwd=request.getParameter("passwd");
	String sex=request.getParameter("sex");
	String age=request.getParameter("age");
	String degree=request.getParameter("degree");
	String []hobby=request.getParameterValues("hobby");
	out.println("用户名为："+username+"<br>");
	out.println("密码为："+pwd+"<br>");
	out.println("性别为："+sex+"<br>");
	out.println("年龄为："+age+"<br>");
	out.println("学位为："+degree+"<br>");
	out.println("兴趣爱好为：");
	for(int i=0;i<hobby.length;i++)
		out.println(hobby[i]);
%>
</body>
</html>