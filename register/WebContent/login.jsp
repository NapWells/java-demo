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
	Cookie cookies[]=request.getCookies();
	String uname="";
	String pwd="";
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("username")){
					uname=cookies[i].getValue();
				}
				if(cookies[i].getName().equals("password")){
					pwd=cookies[i].getValue();
				}
		}	
	}
%>
<form method="post" action="login_deal.jsp">
用户名：<input type="text" name="username"value="<%=uname%>"><br><br>
密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="<%=pwd%>"><br><br>
<input type="submit" value="提交">
<input type="reset" value="重置">
</form>


</body>
</html>