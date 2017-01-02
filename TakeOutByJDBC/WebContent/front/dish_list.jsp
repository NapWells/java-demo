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
<title>QK外卖 - 菜品列表</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<link href="<%=basePath%>front/css/vendor.css" rel="stylesheet">

<link href="<%=basePath%>front/css/main.css" rel="stylesheet">
<link href="<%=basePath%>front/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="<%=basePath%>front/js/vendor.js" type="text/javascript"
	crossorigin="anonymous"></script>
<script src="<%=basePath%>front/js/main.js" type="text/javascript"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="<%=basePath%>front/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%=basePath%>front/js/dish_list.js"></script>

</head>
<body style="position: relative;">

	<div class="ng-isolate-scope">
		<div class="">
			<header class="topbar">
				<div class="container clearfix">
					<h1>
						<a href="index.html" class="topbar-logo icon-logo"> <img
							src="<%=basePath%>front/images/logo-50.png"> <span>QK外卖</span>
						</a>
					</h1>
					<a href="index.html" class="topbar-item topbar-homepage">首页</a> <a
						href="<%=basePath%>front/order_list.jsp" class="topbar-item">我的订单</a>
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

	<div class="ng-scope">
		<div class="shopguide">
			<div class="container">
				<div class="shopguide-info">
					<img src="<%=basePath%>front/${merchant.picture}">
					<div class="shopguide-info-wrapper">
						<div>
							<h1 class="ng-binding">${merchant.name}</h1>
							<span class="addr">${merchant.address}</span>
						</div>
					</div>
				</div>
				<div class="shopguide-server">
					<span> <i class="fa fa-cny"></i> <em
						class="shopguide-server-value">${merchant.minSendPrice}元 <span>起送</span></em>
					</span> <span> <i class="fa fa-cny"></i> <em
						class="shopguide-server-value">${merchant.sendPrice}元 <span>配送费</span></em>
					</span>
				</div>
			</div>
		</div>
		<div class="shopmain clearfix container">
			<div class="shopmenu">
				<div class="shopmenu-main grid">
					<div>
						<div class="shopmenu-list clearfix">
							<c:forEach items="${listGoods}" var="goods" varStatus="status">
								<div class="shopmenu-food">
									<span class="col-1"> <a href="#"> <img
											src="<%=basePath%>front/${goods.imgUrl}">
									</a>
									</span>
									<div class="col-2 shopmenu-food-main">
										<h3 class="shopmenu-food-name ui-ellipsis">${goods.name}</h3>
										<p class="color-mute ui-ellipsis"></p>
									</div>
									<span class="col-3 shopmenu-food-price color-stress">${goods.price}</span>
									<span class="col-4">
										<div class="ng-isolate-scope">
											<div class="ng-scope">
												<button class="shop-cartbutton" id="${goods.id}" >加入购物车</button>
											</div>
										</div>
									</span>
								</div>
							</c:forEach>
						</div>
					</div>

					<div class="ng-isolate-scope" id="shop-cartbasket" style="display:none;">
						<div class="shop-cart">
							<div class="shop-cartbasket" id="shopbasket">
								<div class="ng-isolate-scope">
									<div class="shop-grouphead single">
										<div class="shop-grouphead-row">购物车</div>
									</div>
								</div>
							</div>
							<div class="shop-cartfooter">
								<span class="icon-cart shop-carticon"> <i
									class="fa fa-shopping-cart"
									style="color: #fff; font-size: 24px;"></i>
								</span>
								<p class="shop-cartfooter-text price ng-binding ng-scope" >
									<span id="price">0</span> <span  style="font-size: 12px; color: #fafafa;">
									(共 <span>0</span>件)</span>
								</p>
								<div class="shop-cartfooter-text extras"></div>
								<form style="display:none">
									<input type="hidden" name="totalPrice" value="">
									<input type="hidden" name="dishList" value="">
									<input type="hidden" name="totalPiece" value="">
									<input type="hidden" name="foodname" value="">
									<input type="hidden" name="merchantId" value="${merchant.id}">
								</form>
								<a href="javascript:void(0)"  class="shop-cartfooter-checkout" id="buyList">买单</a>
							</div>
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