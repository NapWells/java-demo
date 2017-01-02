<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>QK外卖 - 首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link href="<%=basePath%>front/css/vendor.css" rel="stylesheet">

<link href="<%=basePath%>front/css/main.css" rel="stylesheet">
<link href="<%=basePath%>front/css/profile.css" rel="stylesheet">
<link href="<%=basePath%>front/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<script src="<%=basePath%>front/js/vendor.js" type="text/javascript"
	crossorigin="anonymous"></script>
<script src="<%=basePath%>front/js/main.js" type="text/javascript" crossorigin="anonymous"></script>
<script type="text/javascript"
	src="<%=basePath%>front/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%=basePath%>front/js/user_info.js"></script>
</head>
<body>
	<div class="ng-isolate-scope">
		<div class=" ng-isolate-scope">
			<header class="topbar">
				<div class="container clearfix">
					<h1>
						<a href="<%=basePath%>index.html" class="topbar-logo icon-logo"> <img
							src="<%=basePath%>front/images/logo-50.png"> <span>QK外卖</span>
						</a>
					</h1>
					<a href="<%=basePath%>index.html" class="topbar-item topbar-homepage">首页</a> <a
						href="<%=basePath%>front/order_list.jsp" class="topbar-item">我的订单</a> <a
						href="<%=basePath%>front/user_info.jsp" class="topbar-item focus">个人中心</a>

					<nav class="topbar-nav">
						<div class="topbar-profilebox">
							<c:if test="${not empty sessionScope.user}">
								<span>欢迎您&nbsp;&nbsp;|&nbsp;&nbsp;</span>
								<a style="color: white;">${sessionScope.user["username"]}</a>
							</c:if>
							<c:if test="${empty sessionScope.user}">
								<span><a href="<%=basePath%>front/login.jsp">登录</a> | <a
									href="<%=basePath%>front/register.jsp">注册</a></span>
							</c:if>
						</div>
					</nav>
				</div>
			</header>
		</div>
	</div>
	<div class="clearfix" style="height: 50px;"></div>
	<div class="">
		<div class="profile profile-container container">
			<div class="profile-panel">
				<div class="profile-footprint ">
					<div class="tabnavigation">
						<a class="active" data-item="self-info">个人信息</a> <a
							data-item="addr-info">地址管理</a> <a data-item="pw-info">修改密码</a>
					</div>
					<div class="profile-panelcontent active" id="self-info">
						<form action="<%=basePath%>UpdateUserInfo" method="post">
							<div class="profileinfo">
								<p class="profileinfo-item">
									<span class="profileinfo-label">用户名</span> <input type="text"
										name="username" value="${sessionScope.user['username']}">
								</p>
								<p class="profileinfo-item">
									<span class="profileinfo-label">手机号码</span> <input type="text"
										name="telphone" value="${sessionScope.user['telphone']}">
								</p>
								<p class="profileinfo-item">
									<span class="profileinfo-label">我的邮箱</span> <input type="text"
										name="eamil" value="${sessionScope.user['email']}">
								</p>
								<p class="profileinfo-item">
									<button>保存修改</button>
								</p>
							</div>
						</form>
					</div>
					<div class="profile-panelcontent" id="addr-info">
						<form action="<%=basePath%>UpdateUserInfo" method="post">
							<div class="profileinfo">
								<p class="profileinfo-item">
									<span class="profileinfo-label">收件人</span> <input type="text"
										name="name" value="${sessionScope.user['name']}">
								</p>
								<p class="profileinfo-item">
									<span class="profileinfo-label">联系电话</span> <input type="text"
										name="telphone" value="${sessionScope.user['telphone']}">
								</p>
								<p class="profileinfo-item">
									<span class="profileinfo-label">收件地址</span> <input type="text"
										name="address" value="${sessionScope.user['address']}"
										placeholder="请输入您的地址">
								</p>
								<p class="profileinfo-item">
									<button>保存修改</button>
								</p>
							</div>
						</form>
					</div>
					<div class="profile-panelcontent" id="pw-info">
						<form action="<%=basePath%>UpdateUserInfo" method="post">
							<div class="profileinfo">
								<p class="profileinfo-item">
									<span class="profileinfo-label">旧密码</span> <input
										name="oldPssword" type="password">
								</p>
								<p class="profileinfo-item">
									<span class="profileinfo-label">新密码</span> <input
										name="password" type="password">
								</p>
								<p class="profileinfo-item">
									<span class="profileinfo-label">确认密码</span> <input
										name="repassword" type="password">
								</p>
								<p class="profileinfo-item">
									<button >保存修改</button>
								</p>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<div class="footer-container">
			<p>轻课学院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp;</p>
		</div>
	</div>
</body>
</html>