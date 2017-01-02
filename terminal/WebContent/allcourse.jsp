<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="db.DBconnect" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
 <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type="text/css" href="CSS/allcourse.css">
 <script src="JS/allcourse.js"></script>
<title>全部课程表</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<table class="table table-bordered text-center">
					<th id="1c"><h2 class="text-center">全部课程</h2></th>
					<tr  id="2c">
						<td>
							<p>公开课</p>
							
						</td>
					</tr>
					<tr  id="3c">
						<td>
							<p>企业安全</p>
							
						</td>
					</tr>
					<tr  id="4c">
						<td>
							<p>网站安全</p>
							
						</td>
					</tr>
					<tr id="5c">
						<td>
							 <p>客户端安全</p>
							
						</td>
					</tr>
					<tr  id="6c">
						<td>
							<p>通信安全</p>
							
						</td>
					</tr>
					<tr  id="7c">
						<td>
							<p>移动安全</p>
							
						</td>
					</tr>
					<tr  id="8c">
						<td>
							<p>安全理论</p>
							
						</td>
					</tr>
					<tr  id="9c">
						<td>
							<p>其他</p>
							
						</td>
					</tr>
				</table>
			</div>

			<div class="col-md-9" id="sort">
			
					
					<div >
						 <%
                 	 request.setCharacterEncoding("UTF-8");
          			DBconnect course = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
          			course.creatConnection();
          			ArrayList list = course.query("select course,logo from course1");
          			course.close();
          			
                  %>
					<ul class="list-inline" >
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
		
			</div>
		</div>
	</div>
</body>
</html>