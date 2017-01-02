<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result</title>
</head>
<body>
<%
int n=0;//统计输入次数
if(session.getAttribute("number")==null){
	n=1;
}
else{
	n = Integer.parseInt((String)session.getAttribute("number"));
	n+=1;
}
session.setAttribute("number", String.valueOf(n));

int num = Integer.parseInt(request.getParameter("input_num"));
int sessionValues=Integer.parseInt(session.getAttribute("random").toString()); 
if(num==sessionValues){
	Date ld=new Date(session.getLastAccessedTime());
	session.setAttribute("lasttime",ld);
	response.sendRedirect("success.jsp");
}
if(num>sessionValues){
	response.sendRedirect("large.jsp");
}
if(num<sessionValues){
	response.sendRedirect("small.jsp");
}
%>
</body>
</html>