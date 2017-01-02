<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
     <%@page import="db.DBconnect" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>course</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
<script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="JS/course.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/course.css">
</head>
<body>	
<%ArrayList course = (ArrayList)request.getAttribute("course1"); 
ArrayList detail=(ArrayList)request.getAttribute("course2");
DBconnect remark = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
remark.creatConnection();
String user = (String)session.getAttribute("user");

ArrayList remarkList=remark.query("select pinglunren,content,time,noname from remark where coursename = '"+course.get(0)+"'");
ArrayList guanzhuList=remark.query("select name,guanzhucourse from guanzhu1 where guanzhucourse = '"+course.get(0)+"' and name = '"+user+"'");
ArrayList guanzhuList1=remark.query("select name,guanzhucourse from guanzhu1 where guanzhucourse = '"+course.get(0)+"'");
ArrayList kecheng=remark.query("select course from course1 where author='"+course.get(1)+"'");
ArrayList guanzhuList2=remark.query("select * from guanzhu2 where name='"+user+"' and author='"+course.get(1)+"'");
ArrayList guanzhuzuozhe=remark.query("select * from guanzhu2 ");
remark.close();
%>
<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<p><a href="allcourse.jsp">全部课程</a>><span id="coursename"><%=course.get(0) %></span><span id="chaptername"></span></p>
		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-7"><img src="<%=course.get(2) %>" alt="First slide" width="430" height="320"></div>
					<ul class="col-md-5 list-unstyled" id="info">
						<li><h4><%=course.get(0) %></h4></li>
						<li><span>xx</span>人已学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="remarknum1"><%=remarkList.size()/4 %></span>评论</li>
						<li>难易程度：<span><%=course.get(6) %></span></li>
						<li>更新时间：<span><%=course.get(3) %></span></li>
						<li>总价：<span>xx</span></li>
						<li><ul class="list-inline">
							<li>课程标签：</li>
							<li><%=course.get(5) %></li>
							</ul>
						</li>
						<li><h2 id="price"><%=course.get(4) %></h2><small><span><img src="image/xin.png"><a id="follow" 
						onCLick="guanzhu()"><span id="guanzhu"><%if(guanzhuList.size()==0){%>关注<%}else{%>已关注<%}%></span></a></span></small></li></ul>
				</div>
				<div>
					<ul id="myTab" class="nav nav-tabs">
					   <li class="active">
					      <a href="#catalog" data-toggle="tab">
					         课程目录
					      </a>
					   </li>
					   <li><a href="#comment" data-toggle="tab">评论X<span class="remarknum2"><%=remarkList.size()/4 %></span></a></li>
					</ul>
				</div>
				<div id="myTabContent" class="tab-content">
				   <div class="tab-pane fade in active" id="catalog">
				   		<br>
				     	<strong>课程简介</strong>
				     	<br>
				     	<br>
				     	<p><%=course.get(8) %></p>
				     	<br>
				     	<%ArrayList chapter = new ArrayList(); 
				     	for(int i=0;i<detail.size();i+=4)
				     		if(!chapter.contains(detail.get(i+2)))
				     			chapter.add(detail.get(i+2));
				     	for(int k=0;k<chapter.size();k++){
				     		%><strong><%=chapter.get(k)%></strong>
				     		<br><%
				     		for(int j=0;j<detail.size();j+=4){
					     		if(detail.get(j+2).equals(chapter.get(k))){%>
					     			<ul>
					     				<li><a href="playcourse.jsp?chapter=<%=detail.get(j)%>&course=<%=course.get(0)%>&path=<%=detail.get(j+3)%>"><%=detail.get(j) %></a></li>
					     			</ul>
					     		<%}
					     	}
				     	}
				     	%>

				     	<p>后续章节敬请期待</p>
				   </div>
				   <div class="tab-pane fade" id="comment">
				      <form class="form" id="remarkForm" method="post" action="">
				      	<div class="form-group"><textarea type="text" class="form-control" name="content" id="content" placeholder="课程是否给力？请分享一下你的心得吧！（至少5字）"></textarea>
				      	</div>
				      	<div class="checkbox pull-right">
					         <label><input type="checkbox" id="radio1" name="radio1" value="匿名">匿名评论</label>
					         <input type="button"  class="btn btn-default" onClick="remark()" value="评论">
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
				</div>
			</div>
			<div class="col-md-3">
				<div class="authorinfo">
					<table class="table">
						<tr><td rowspan="2"><img src="image/touxiang.png" width="80px" height="100px"></td><td><h3 id="author"><%=course.get(1) %></h3></td></tr>
						<tr><td ><span><img src="image/xin.png"><a id="follow1" 
						onCLick="guanzhu1()"><span id="guanzhu1"><%if(guanzhuList2.size()==0){%>关注<%}else{%>已关注<%}%></span></a></span>(<span id="guanzhunum2"><%=guanzhuzuozhe.size()/2 %></span>)</td></tr>
					</table>

					<ul class="list-inline content text-center">
						<li><span id="guanzhunum"><%=guanzhuList1.size()/2 %></span><br>关注</li>
						<li><img class="img-responsive" src="image/fenggexian.png" ></li>
						<li>92%<br>好评</li>
						<li><img class="img-responsive"  src="image/fenggexian.png"></li>
						<li><%=kecheng.size() %><br>课程</li>
					</ul>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>