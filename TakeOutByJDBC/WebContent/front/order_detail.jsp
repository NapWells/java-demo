<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript"
	src="<%=basePath%>front/js/order_detail.js"></script>

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
					<a href="<%=basePath%>index.html"
						class="topbar-item topbar-homepage">首页</a> <a
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
		<div class="checkoutguide">
			<div class="container">
				<span class="checkoutguide-text">订单信息</span>
			</div>
		</div>
		<div class="container clearfix">
			<div class="checkout-cart">
				<div class="checkoutcart-container">
					<div class="checkoutcart-title">
						<h2>订单详情</h2>
						<a href="dish_list.html"
							style="color: #0089dc; font-size: 16px; font-weight: bold;"><i
							class="fa fa-reply"></i> 返回</a>
					</div>
					<div class="checkoutcart-tablerow tablehead">
						<div class="cell itemname">商品</div>
						<div class="cell itemquantity">份数</div>
						<div class="cell itemtotal">小计（元）</div>
					</div>
					<ul class="ng-scope">
						<%List foodnames = (List)request.getAttribute("foodnames");
                   		 List dishLists = (List)request.getAttribute("dishLists");
                   		 for(int i = 0 ; i <= foodnames.size()-3;i=i+3){%>
						<li class="checkoutcart-tablerow extra">
							<div class="cell itemname">
								<span class="ng-binding"><%=foodnames.get(i)%></span>
							</div>
							<div class="cell itemquantity"><%=foodnames.get(i+1)%></div>
							<div class="cell itemtotal">
								¥<%=foodnames.get(i+2)%></div>
						</li>
						<%}
                   		 %>


						<li class="checkoutcart-tablerow extra">
							<div class="cell itemname">
								<span class="ng-binding">餐盒</span>
							</div>
							<div class="cell itemquantity"></div>
							<div class="cell itemtotal">¥1.00</div>
						</li>
						<li class="checkoutcart-tablerow extra">
							<div class="cell itemname">
								<span class="ng-binding">配送费</span> <span
									class="icon-circle-help"></span>
							</div>
							<div class="cell itemquantity"></div>
							<div class="cell itemtotal">¥4.00</div>
						</li>
					</ul>
					<div class="checkoutcart-total color-stress">
						¥<span class="num">${totalPrice}</span>
					</div>
					<div class="checkoutcart-totalextra">
						共 <span class="ng-binding">${totalPiece}</span> 份商品
					</div>
				</div>
			</div>
			<div class="checkout-content">
				<div class="checkout-select">
					<h2>收货地址</h2>
					<c:forEach items="${listAddress}" var="addr" varStatus="status">
						<a class="checkout-noaddress">送餐地址：&nbsp;${addr.name}
							&nbsp;&nbsp;收货人：&nbsp;${sessionScope.user["name"]}&nbsp;联系电话：&nbsp;${sessionScope.user["telphone"]}</a>
						<hr>
					</c:forEach>
					<a class="checkout-noaddress" href="javascript:address()">+
						添加新地址</a>
				</div>
				<div>
					<button class="btn-stress" style="float: right;" id="buyOrder">买单</button>
					<form style="display:none" method="post">
						<input type="hidden" name="totalPrice" value="${totalPrice}">
						<input type="hidden" name="dishList" value="${dishList}">
						<input type="hidden" name="totalPiece" value="${totalPiece}">
						<input type="hidden" name="merchantId" value="${merchantId}">
					</form>
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