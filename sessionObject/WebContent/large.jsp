<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>large</title>
<script type="text/javascript" src="checkForm.js">
</script>
</head>
<body>
<%int count=Integer.parseInt(session.getAttribute("number").toString());
%>
<p>所猜的数比实际的值大，请在猜：<br><br></p>
<p>你已经猜了<%=count%>次<br><br></p>
<p>请在输入你猜的数<br><br></p>
<form method="post" onsubmit="return checkform('input_num')" action="result.jsp">
<input type="text" name="input_num" id="input_num" onkeyup="value=value.replace(/[^\d]/g,'')">
<input type="submit" value="送出">
</form>
</body>
</html>