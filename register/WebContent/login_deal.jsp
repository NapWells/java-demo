<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String uname=request.getParameter("username");
String pwd=request.getParameter("password");
if(uname.equals("zhangsan")&&pwd.equals("123456")){
	Cookie username_cookie=new Cookie("username",uname);
	Cookie password_cookie=new Cookie("password",pwd);
	response.addCookie(username_cookie);
	response.addCookie(password_cookie);
	out.println("用户名:"+uname+"<br>");
	out.println("密码："+pwd);
}
else
	response.sendRedirect("login.jsp");
%>
</body>
</html>