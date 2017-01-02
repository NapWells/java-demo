<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error.jsp</title>
</head>
<body style="background-color:yellow">
	<jsp:include page="head.jsp"/>
	<p style="font-size:15px;color:red;">this is error.jsp.</p>
	<p style="font-size:20px;color:green;">
		<%String a=request.getParameter("mess");
		out.println("传递过来的错误信息"+a);
		%>
	</p>


</body>
</html>