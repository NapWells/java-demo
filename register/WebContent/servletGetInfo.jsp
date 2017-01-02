<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "java.util.ArrayList"%>
    <%@page import = "register.Info" %>
    <%@page import = "register.InfoServlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Info info = (Info)session.getAttribute("registerInfo");
String uname = info.getUsername();
String pwd = info.getPassword();
String sex = info.getSex();
String age = info.getAge();
String degree = info.getDegree();
String []hobby = info.getHobby();
String str="";
for(int i=0;i<hobby.length;i++){
	str +=hobby[i]+" ";
}
%>
<p>用户名：<%=uname%></p>
<p>密码：<%=pwd %></p>
<p>性别：<%=sex %></p>
<p>年龄：<%=age %></p>
<p>学历：<%=degree%></p>
<p>兴趣爱好：<%=str %></p>
<%
session.invalidate();
%>
</body>
</html>