<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="db.DBconnect" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
   <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
   <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
   <link rel="stylesheet" type="text/css" href="CSS/nav.css">
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
	DBconnect mycourse = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
	mycourse.creatConnection();
	String user = (String)session.getAttribute("user");
	ArrayList list=mycourse.query("select guanzhucourse,logo from guanzhu1,course1 where guanzhu1.name='"+user+"' and GUANZHUCOURSE=course1.course");
%>
<div >
	<br>
	<p style="font-family: '楷体';font-size:x-large;">我关注的 </p>
	<hr>
	<br>
	<% if(list.size()==0){%>
		<div class="col-md-offset-5" style="magrin-top:200px;font-family: '楷体';font-size:x-large;">您还没有关注任何 </div>
	<%}else{%>
		<ul class="list-inline" style="padding-left:20px;">
			<% for(int i=0;i<list.size();i+=2){%>
				<li><div><p class="text-center"><img src="<%=list.get(i+1) %>" width="250" height="150"></p><p class="text-center"><%=list.get(i) %></p></div></li>
			<%}%>
		</ul>
	<%}%>
	</div>
</body>
</html>