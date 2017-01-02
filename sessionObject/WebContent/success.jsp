<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
</head>
<body>
<%
String correct_Values=session.getAttribute("random").toString();
int count=Integer.parseInt(session.getAttribute("number").toString());
Object d1=session.getAttribute("starttime");
Object d2=session.getAttribute("lasttime");
String s1=d1.toString();
String s2=d2.toString();
Date sd1=new Date(s1);
Date sd2=new Date(s2);
%>
<p>猜对了，恭喜你</p>
<p>你一共猜了<%=count%>次</p>
<p>用时<%=(sd2.getTime()-sd1.getTime())/1000%>秒</p>
<P>这个数字是<%=correct_Values%></P>
<a<%session.invalidate();%> href="guessForm.jsp">再来一次</a>
</body>
</html>