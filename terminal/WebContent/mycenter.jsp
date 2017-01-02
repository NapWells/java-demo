<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
   <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
   <script src="JS/mycenter.js"></script>
   <link rel="stylesheet" type="text/css" href="CSS/mycenter.css">
</head>
<body>
<%String user = (String)session.getAttribute("user"); %>
<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-3" id="colleft">
				<ul class="list-unstyled" id="list1">
					<li><img class="img-circle" src="image/touxiang.png"></li>
					<li ><%=user %><br></li>
					<li>管理中心<hr></li>
				</ul>
				<ul class="mycenter list-unstyled" id="usermsg">
					<li><a href="">已购课程 <span>(0)</span></a></li>
					<li><hr></li>
				</ul>
				
				<ul class="mydetail">
					<li class="mycenter">个人成长<ul class="list-unstyled" >
						<li id="xuexipaiming">学习排名</li>
						<li id="mycourse">我的课程</li>
					</ul></li>
					<li class="mycenter">消息中心<ul class="list-unstyled">
						<li>回复我（0）</li>
						<li>赞（0）</li>
						<li>系统消息(0)</li>
					</ul></li>

					<li class="mycenter">我的关注<ul class="list-unstyled">
						<li id="guanzhu0">关注的课程</li>
						<li id="guanzhu">关注的作者</li>
					</ul></li>

					<li class="mycenter">个人设置<ul class="list-unstyled">
						<li>个人信息</li>
						<li id="xiugai">修改密码</li>
					</ul></li>

					<li class="mycenter">我的课程<ul class="list-unstyled">
						<li id="upload1">上传课程</li>
					</ul></li>
				</ul>
			</div>
			<div class="col-md-9" >
				<div id="right">
					
						<br>
						<p class="yigoumai">已购课程（0）</p>
						<hr>
						<br>
						<div class="col-md-offset-3 yigoumai">暂无购买课程，请到 <a href="allcourse.jsp">全部课程</a> 选购！</div>
				</div>
				
			</div>
		</div>
	</div>

	
</body>
</html>