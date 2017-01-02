<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Random" %>
 <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>guessForm</title>
<script type="text/javascript" src="checkForm.js">
</script>
</head>
<body>
<%
Random rand =new Random();
int num=rand.nextInt(101);
session.setAttribute("random", num);
Date d=new Date(session.getCreationTime());
session.setAttribute("starttime",d);
%>
<p>随机分给了逆一个1到100之间的数字，请猜猜这个数<br><br>你猜的数</p>
<form method="post" onsubmit="return checkform('input_num')" action="result.jsp">
<input type="text" name="input_num" id="input_num" onkeyup="value=value.replace(/[^\d]/g,'')">
<input type="submit" value="送出">
</form>
</body>
</html>