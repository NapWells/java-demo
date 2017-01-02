<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>three.jsp</title>
</head>
<body bgcolor=yellow>
	<jsp:include page="head.jsp"/>
	<p style="font-size:20px color:blue;">this is three.jsp.</p>
	<p style="font-size:25px;color:red;">
		<%String a=request.getParameter("number");
		out.println("传递过来的值是"+a);
		%>
	</p>

</body>
</html>