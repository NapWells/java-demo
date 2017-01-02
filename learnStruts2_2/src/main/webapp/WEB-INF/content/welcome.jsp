<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><s:text name="succPage"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>本站访问的次数为：<s:property value="#application.counter" /></h1>
	<h2><s:property value="#session.user" />,您已经登录！</h2>
	<h3><s:property value="#request.tip" /></h3>
	<h4>cookie为：<s:property value="#cookie.user.value" /></h4>
</body>
</html>
