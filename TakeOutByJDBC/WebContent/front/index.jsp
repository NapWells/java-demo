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

<link href="<%=basePath%>front/css/vendor.css" rel="stylesheet">

<link href="<%=basePath%>front/css/main.css" rel="stylesheet">
<link href="<%=basePath%>front/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="<%=basePath%>front/js/vendor.js" type="text/javascript"
	crossorigin="anonymous"></script>
<script src="<%=basePath%>front/js/main.js" type="text/javascript"
	crossorigin="anonymous"></script>

</head>
<body style="position: relative;">

	<div class="ng-isolate-scope">
		<div class=" ng-isolate-scope">
			<header class="topbar">
				<div class="container clearfix">
					<h1>
						<a href="index.html" class="topbar-logo icon-logo"> <img
							src="<%=basePath%>front/images/logo-50.png"> <span>QK外卖</span>
						</a>
					</h1>
					<a href="<%=basePath%>/index.html"
						class="topbar-item topbar-homepage focus">首页</a> <a
						href="<%=basePath%>OrderListServlet" class="topbar-item">我的订单</a>
					<a href="<%=basePath%>front/user_info.jsp" class="topbar-item">个人中心</a>
					<a href="<%=basePath%>front/rider_application.jsp"
						class="topbar-item">成为骑士 <i class="fa fa-bicycle"
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

	<div id="search-box" class="clearfix">
		<div class="place-search">
			<i class="fa fa-search place-search-btn icon-search"></i> <input
				id="globalsearch" class="place-search-input ng-pristine ng-valid"
				placeholder="搜索商家,美食...">
		</div>
	</div>

	<div class="container">
		<div class="excavator container">
			<div class="excavator-filter ">
				<span class="excavator-filter-name">商家分类:</span> <a
					class="excavator-filter-item focus" href="＃">全部商家</a>
				<c:forEach items="${listClazz}" var="clazz" varStatus="status">
					<a class="excavator-filter-item" href="#">${clazz.name}</a>
				</c:forEach>
			</div>
		</div>

		<div class="place-rstbox clearfix">
			<div class="clearfix">
				<c:forEach items="${listMerchant}" var="merchant" varStatus="status">
					<a href="<%=basePath%>DishListServlet?id=${merchant.id}" class="rstblock">
						<div class="rstblock-logo">
							<img src="<%=basePath%>front/${merchant.picture}"
								class="rstblock-logo-icon">
						</div>
						<div class="rstblock-content">
							<div class="rstblock-title">${merchant.name}</div>
							<div class="rstblock-cost">${merchant.minSendPrice}元起送</div>
							<div class="rstblock-cost">配送费${merchant.sendPrice}元</div>
						</div>
					</a>
				</c:forEach>
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