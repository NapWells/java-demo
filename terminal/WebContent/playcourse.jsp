<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="db.DBconnect"  %>
    <%@ page import="java.util.ArrayList"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>playcourse</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="JS/playcourse.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/course.css">
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<%String coursename = request.getParameter("course").toString();
String chapter = request.getParameter("chapter").toString();
String path = request.getParameter("path").toString();
String user = (String)session.getAttribute("user");
request.setCharacterEncoding("UTF-8");
	DBconnect course = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
	course.creatConnection();
	ArrayList list = course.query("select course1.course,author,path,name from course1,course2 where course1.course=course2.course and course1.course='"+coursename+"' order by course2.uploadtime");
	ArrayList kecheng=course.query("select course from course1 where author='"+list.get(1)+"'");
	ArrayList guanzhuList=course.query("select name,guanzhucourse from guanzhu1 where guanzhucourse = '"+list.get(0)+"' and name = '"+user+"'");
	ArrayList guanzhuList1=course.query("select name,guanzhucourse from guanzhu1 where guanzhucourse = '"+list.get(0)+"'");
	ArrayList guanzhuList2=course.query("select * from guanzhu2 where name='"+user+"' and author='"+list.get(1)+"'");
	ArrayList guanzhuzuozhe=course.query("select * from guanzhu2 ");
	ArrayList remarkList=course.query("select pinglunren,content,time,noname from remark where coursename = '"+list.get(0)+"' and chapter='"+chapter+"'");
	course.close();
%>
<div class="container">
		<p><a href="allcourse.html">全部课程</a>><a href="courseInfo?name=<%=list.get(0)%>"><span id="coursename"><%=coursename %></span></a>><span id="chaptername"><%=chapter %></span></p>
		<h2><%=chapter %></h2>
		<div class="row">
			<div class="col-md-9">
				<video width="900" height="460" controls>
					<source src="movie.ogg" type="video/ogg">
					<source src="<%=path %>" type="video/mp4">
					<source src="movie.webm" type="video/webm">
					<object src="<%=path %>">
					<embed src="<%=path %>">
					</object>
				</video>
				<h3>评论<span class="remarknum2"><%=remarkList.size()/4 %></span></h3>
				<hr>
				<form class="form" id="remarkForm" method="post" action="">
				      	<div class="form-group"><textarea type="text" class="form-control" name="content" id="content" placeholder="课程是否给力？请分享一下你的心得吧！（至少5字）"></textarea>
				      	</div>
				      	<div class="checkbox pull-right">
					         <label><input type="checkbox" id="radio1" name="radio1" value="匿名">匿名评论</label>
					         <input type="button" class="btn btn-default" onClick="remark()" value="评论">
      					</div>
				  </form>
				  	<br><br><br><br>
				   	<hr>
				   	<ul class="list-unstyled" id="remarkUl">
				   	<%     
			for(int i=0;i<remarkList.size();i+=4){
				if(remarkList.get(i+3).equals("0")){%>
					<li>
				    	  	<div class="row">
				    	  		<div class="col-md-2"><img src="image/touxiang.png"></div>
				    	  		<div class="col-md-10">
				    	  			<p><span id="user"><%=remarkList.get(i) %></span><span id="time">发表于：<%=remarkList.get(i+2) %></span></p>
				    	  			<p id="content"><%=remarkList.get(i+1) %></p>
				    	  		</div>
				    	  	</div>
				   	</li>
				   	<li><hr></li>
				<%}
				if(remarkList.get(i+3).equals("1")){%>
				<li>
			    	  	<div class="row">
			    	  		<div class="col-md-2"><img src="image/touxiang.png"></div>
			    	  		<div class="col-md-10">
			    	  			<p><span id="user">匿名用户</span><span id="time">发表于：<%=remarkList.get(i+2) %></span></p>
			    	  			<p id="content"><%=remarkList.get(i+1) %></p>
			    	  		</div>
			    	  	</div>
			   	</li>
			   	<li><hr></li>
			<%}
			}
	%>
				   	</ul>
			</div>

			<div class="col-md-3">
				<div class="row">
					<div class="col-sm-3"><img src="image/touxiang.png"></div>
					<div class="col-sm-9">
						<ul class="list-inline">
							<li id="author"><%=list.get(1) %></li>
							<li><span><img src="image/xin.png"><a id="follow1" 
						onCLick="guanzhu1()"><span id="guanzhu1"><%if(guanzhuList2.size()==0){%>关注<%}else{%>已关注<%}%></span></a></span>(<span id="guanzhunum2"><%=guanzhuzuozhe.size()/2 %></span>)</li>
						</ul>
						<br>
						<ul class="list-inline">
							<li>(<span id="guanzhunum"><%=guanzhuList1.size()/2 %></span>)<a id="follow" 
						onCLick="guanzhu()"><span id="guanzhu"><%if(guanzhuList.size()==0){%>关注<%}else{%>已关注<%}%></span></a></li>
							<li>45%好评</li>
							<li><%=kecheng.size() %>课程</li>
						</ul>
					</div>
				</div>
				<div class="charpercourse">
					<ul class="list-unstyled" >
					<li><br></li>
					<%for(int i=0;i<list.size();i+=4){
						if(list.get(i+3).equals(chapter)){%>
							<li><strong><%=list.get(i+3) %></strong></li>
							<li><br></li>
						<%}
						else{%>
							<li><a href="playcourse.jsp?chapter=<%=list.get(i+3)%>&course=<%=list.get(0)%>&path=<%=list.get(i+2)%>"><%=list.get(i+3) %></a></li>
							<li><br></li>
							<% }
					}
						%>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>