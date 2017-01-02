<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="jspJavaBean.studentInfo" %>
    <jsp:useBean id="student" class="jspJavaBean.studentInfo">
    	<jsp:setProperty property="*" name="student"/>
    </jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>学号:<jsp:getProperty property="stuId" name="student"/></p>
<p>姓名:<jsp:getProperty property="stuName" name="student"/></p>
<p>课程名称:<jsp:getProperty property="course" name="student"/></p>
<p>成绩:<jsp:getProperty property="grade" name="student"/></p>
</body>
</html>