<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="db.DBconnect" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
 <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type="text/css" href="CSS/nav.css">

</head>
<body>
					<div >
<%
                 	 request.setCharacterEncoding("UTF-8");
          			DBconnect course = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
          			course.creatConnection();
          			ArrayList list = course.query("select course,logo from course1 where sort='公开课'");
          			course.close();
          			
                  %>
					<ul class="list-inline">
					<%for(int i=0;i<list.size();i+=2){ %>
						<li><div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list.get(i)%>">
	 						<img  class="img-responsive" src="<%=list.get(i+1)%>"  width="250" height="150">
	  						</a>
	 					 <div class="desc"><%=list.get(i)%></div>
						</div>
						</a></li>
					<%}
					%>
					</ul>
					</div>
				

</body>
</html>