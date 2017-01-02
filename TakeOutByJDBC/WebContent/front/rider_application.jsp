<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>QK外卖 - 首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link href="css/vendor.css" rel="stylesheet">

<link href="css/main.css" rel="stylesheet">
<link href="css/profile.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<script src="js/vendor.js" type="text/javascript"
	crossorigin="anonymous"></script>
<script src="js/main.js" type="text/javascript" crossorigin="anonymous"></script>
<script type="text/javascript"></script>
</head>
<body>
	<div class="ng-isolate-scope">
		<div class=" ng-isolate-scope">
			<header class="topbar">
				<div class="container clearfix">
					<h1>
						<a href="index.html" class="topbar-logo icon-logo"> <img
							src="./images/logo-50.png"> <span>QK外卖</span>
						</a>
					</h1>
					<a href="index.html" class="topbar-item topbar-homepage">首页</a> <a
						href="order_list.html" class="topbar-item">我的订单</a> <a
						href="user_info.html" class="topbar-item">个人中心</a> <a
						href="rider_application.html" class="topbar-item focus">成为骑士 <i
						class="fa fa-bicycle"
						style="position: relative; top: -5px; font-size: 20px; color: yellow"></i>
					</a>

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
	<div id="rider_application">
		<div class="profile profile-container container">
			<div class="profile-panel">
				<div class="profile-footprint ">
					<h3 class="profile-paneltitle ng-scope">
						<span class="ng-binding"> 我要成为骑士！ </span>
					</h3>
					<div class="profile-panelcontent active" id="self-info">
						<div class="profileinfo">
							<p class="profileinfo-item">
								<span class="profileinfo-label">姓名</span> <input type="text"
									value="张三">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">手机号码</span> <input type="text"
									value="15000000000">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">我的邮箱</span> <input type="text"
									value="user@qk.com">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">身份证</span> <input type="text"
									value="" placeholder="请输入您的身份证">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">证件照</span> <input type="file">
							</p>
							<p class="profileinfo-item">
								<button>递交申请</button>
							</p>
						</div>
					</div>
					<div class="profile-panelcontent" id="addr-info">
						<div class="profileinfo">
							<p class="profileinfo-item">
								<span class="profileinfo-label">收件人</span> <input type="text"
									value="张三">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">联系电话</span> <input type="text"
									value="15000000000">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">收件地址</span> <input type="text"
									value="" placeholder="请输入您的地址">
							</p>
							<p class="profileinfo-item">
								<button>保存修改</button>
							</p>
						</div>
					</div>
					<div class="profile-panelcontent" id="pw-info">
						<div class="profileinfo">
							<p class="profileinfo-item">
								<span class="profileinfo-label">旧密码</span> <input
									type="password">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">新密码</span> <input
									type="password">
							</p>
							<p class="profileinfo-item">
								<span class="profileinfo-label">确认密码</span> <input
									type="password">
							</p>
							<p class="profileinfo-item">
								<button>保存修改</button>
							</p>
						</div>
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