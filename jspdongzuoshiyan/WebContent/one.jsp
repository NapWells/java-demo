<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>one.jsp</title>
</head>
<body bgcolor=yellow>
	<jsp:include page="head.jsp"/>
		<form action="" method="get" name="form">
			请输入1至100之间的整数：<input type="text" name="number"><br>
			<input type="submit" value="送出" name="submit">
		</form>
	<%
		String num=request.getParameter("number");
		if(num==null){
			num="0";
		}
		try{
			int n=Integer.parseInt(num);
			if(n>=1&&n<=50){
	%>			<jsp:forward page="two.jsp">
				<jsp:param value="<%=n%>" name="number"/>
				</jsp:forward>
	<%		}
			else if(n>50&&n<=100){
	%>			<jsp:forward page="three.jsp">
				<jsp:param value="<%=n%>" name="number"/>
				</jsp:forward>
	<%		}	
		}
		catch(Exception e){
	%>			<jsp:forward page="error.jsp">
				<jsp:param value="<%=e.toString()%>" name="mess"/>
				</jsp:forward>	
	<% 	}
	%>
</body>
</html>