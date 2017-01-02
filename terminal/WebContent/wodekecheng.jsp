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
	ArrayList list=mycourse.query("select course from course1 where author='"+user+"'");
%>
<div class="panel panel-default">
   <div class="panel-heading text-center">
      我的课程
   </div>
   <div class="panel-body">
      <table class="table table-bordered">
		<thead>
	      <tr >
	         <th class="text-center">课程名称</th>
	         <th class="text-center">操作</th>

	      </tr>
	     </thead>
	      <tbody>
	      <%for(int i=0;i<list.size();i++){%>
	    	  <tr>
	         <td class="text-center"><%=list.get(i) %></td>
	         <td class="text-center">
	         	<ul class="list-inline">
	         	<li>编辑</li>
	         	<li>删除</li>
	         	</ul>
	         </td>
	      </tr>
	      <%}
	      %>
	   </tbody>

	</table>
   </div>
</div>
	
</div>
</body>
</html>