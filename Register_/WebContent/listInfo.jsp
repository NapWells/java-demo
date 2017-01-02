<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String DB_name="registerinfo";
		String DB_pwd="000000";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(url,DB_name,DB_pwd);
		Statement stmt  =conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from register");
		while(rs.next()){
			out.println("用户名："+rs.getString(1)+"<br>"
					+"密码："+rs.getString(2)+"<br>"
					+"性别："+rs.getString(3)+"<br>"
					+"年龄："+rs.getString(4)+"<br>"
					+"学历："+rs.getString(5)+"<br>"
					+"兴趣爱好："+rs.getString(6)+"<br>"
					);
		}
		rs.close();
		conn.close();
		stmt.close();
%>
</body>
</html>