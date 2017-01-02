<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>以超链接形式传递中文参数的乱码问题</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/HrefLink?userName=gacl&name=<%=URLEncoder.encode("徐达沛", "UTF-8")%>">点击</a>
</body>
</html>