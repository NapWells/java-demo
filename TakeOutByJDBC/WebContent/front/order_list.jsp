<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,pojo.Order,java.util.Map,pojo.Goods" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>QK外卖 - 首页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link href="<%=basePath%>front/css/vendor.css" rel="stylesheet">
    
    <link href="<%=basePath%>front/css/main.css" rel="stylesheet">
    <link href="<%=basePath%>front/css/profile.css" rel="stylesheet">
    <link href="<%=basePath%>front/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <script src="<%=basePath%>front/js/vendor.js" type="text/javascript" crossorigin="anonymous"></script>
    <script src="<%=basePath%>front/js/main.js" type="text/javascript" crossorigin="anonymous"></script>
<script type="text/javascript"></script>
</head>
	<body>
    <div class="ng-isolate-scope">
        <div class=" ng-isolate-scope">
            <header class="topbar">
                <div class="container clearfix">
                    <h1>
                        <a href="<%=basePath%>index.jsp" class="topbar-logo icon-logo">
                            <img src="<%=basePath%>front/images/logo-50.png">
                            <span>QK外卖</span>
                        </a>
                    </h1>
                    <a href="<%=basePath%>index.html" class="topbar-item topbar-homepage">首页</a>
                    <a href="<%=basePath%>front/order_list.jsp" class="topbar-item focus">我的订单</a>
                    <a href="<%=basePath%>front/user_info.jsp" class="topbar-item">个人中心</a>
                    <a href="<%=basePath%>front/rider_application.jsp" class="topbar-item">成为骑士
                        <i class="fa fa-bicycle" style="position:relative;top:-5px;font-size:20px;color:yellow"></i>
                    </a>

                    <nav class="topbar-nav">
                        <div class="topbar-profilebox">
                            <c:if test="${not empty sessionScope.user}"><span>欢迎您&nbsp;&nbsp;|&nbsp;&nbsp;</span><a style="color:white;">${sessionScope.user["username"]}</a></c:if>
                            <c:if test="${empty sessionScope.user}"><span><a href="<%=basePath%>front/login.jsp">登录</a> | <a href="<%=basePath%>front/register.jsp">注册</a></span></c:if>
                        </div>
                    </nav>
                </div>
            </header>
        </div>
    </div>
    <div class="ng-scope">
      <div class="profile-container container user_order">
        <div class="clearfix" style="height:50px;"></div>
        <div class="profile-panel">
          <h3 class="profile-paneltitle ng-scope">
            <span class="ng-binding">所有订单</span>
            <span class="subtitle ng-binding"></span>
          </h3>
          <div class="orders-list">
          <c:forEach items="${listOrder}" var="order" varStatus="status">
          	<div class="order-v">
                <div class="brief-intro j-toggle-content ">
                  <div class="brief-intro-topconsole">
                    <div class="clearfix">
                      <a href="#" class="order-complaint">
                        <i class="fa fa-bars" style="margin-right: 10px;"></i>查看详情</a>
                    </div>
                  </div>
                  <a href="dish_list.html"  class="avatar fl">
                    <img style="width: 104px; height: 78px;" src="<%=basePath%>front/${listMerchant[status.index].picture}">
                  </a>
                  <div class="content">
                    <div class="rest-name clearfix">
                      <a  href="<%=basePath%>/DishListServlet?id=${listMerchant[status.index].id}" class="ca-deepgrey j-poi-name">
                        <span class="poi-name">${listMerchant[status.index].name }</span>
                      </a>
                      <span class="order-total">商家电话：${listMerchant[status.index].telphone }</span>
                    </div>
                    <div class="rest-detail">
                      <span class="order-id">订单号:${order.id}</span>
                        <span class="order-total">下单时间 :${order.create_Time}</span>
                    </div>
                    <div class="order-detail-table">
                      <table>
                        <tr>
                          <th class="img"></th>
                          <th class="name">名称</th>
                          <th class="num">数量</th>
                          <th class="price">金额</th>
                        </tr>
                        <c:forEach items="${listMapGoods[status.index]}" var="goods">
                        	 <tr>
                          <td class="img"><img src="<%=basePath%>front/${goods.key.imgUrl}"></td>
                          <td class="name">${goods.key.name}</td>
                          <td class="num">${goods.value}</td>
                          <td class="price">${goods.key.price}</td>
                        </tr>
                        </c:forEach>
                      </table>
                    </div>
                  </div>    
                </div>

              </div>
          </c:forEach>
<!--               <div class="order-v"> -->
<!--                 <div class="brief-intro j-toggle-content "> -->
<!--                   <div class="brief-intro-topconsole"> -->
<!--                     <div class="clearfix"> -->
<!--                       <a href="#" class="order-complaint"> -->
<!--                         <i class="fa fa-bars" style="margin-right: 10px;"></i>查看详情</a> -->
<!--                     </div> -->
<!--                   </div> -->
<!--                   <a href="dish_list.html"  class="avatar fl"> -->
<!--                     <img style="width: 104px; height: 78px;" src="images/ea9fd17b28b08fe90adcc56a35a500e393144.jpg"> -->
<!--                   </a> -->
<!--                   <div class="content"> -->
<!--                     <div class="rest-name clearfix"> -->
<!--                       <a  href="dish_list.html" class="ca-deepgrey j-poi-name"> -->
<!--                         <span class="poi-name">何记烤肉拌饭</span> -->
<!--                       </a> -->
<!--                       <span class="order-total">商家电话：13600592707</span> -->
<!--                     </div> -->
<!--                     <div class="rest-detail"> -->
<!--                       <span class="order-id">订单号：10044290280273782</span> -->
<!--                         <span class="order-total">下单时间：2016-07-27 10:40</span> -->
<!--                     </div> -->

<!--                     <div class="order-detail-table"> -->
<!--                       <table> -->
<!--                         <tr> -->
<!--                           <th class="img"></th> -->
<!--                           <th class="name">名称</th> -->
<!--                           <th class="num">数量</th> -->
<!--                           <th class="price">金额</th> -->
<!--                         </tr> -->
<!--                         <tr> -->
<!--                           <td class="img"><img src="images/9bdeedd6bbc411da0ece91fe89785jpeg.jpeg"></td> -->
<!--                           <td class="name">手撕包心菜</td> -->
<!--                           <td class="num">1</td> -->
<!--                           <td class="price">8.00</td> -->
<!--                         </tr> -->
<!--                         <tr> -->
<!--                           <td class="img"><img src="images/1d3e8121424d6fff8b37e27438f84jpeg.jpeg"></td> -->
<!--                           <td class="name">番茄炒蛋</td> -->
<!--                           <td class="num">1</td> -->
<!--                           <td class="price">12.00</td> -->
<!--                         </tr> -->
<!--                       </table> -->
<!--                     </div> -->
<!--                   </div>     -->
<!--                 </div> -->

<!--               </div> -->

<!--               <div class="order-v"> -->
<!--                 <div class="brief-intro j-toggle-content "> -->
<!--                   <div class="brief-intro-topconsole"> -->
<!--                     <div class="clearfix"> -->
<!--                       <a href="#" class="order-complaint"> -->
<!--                         <i class="fa fa-bars" style="margin-right: 10px;"></i>查看详情</a> -->
<!--                     </div> -->
<!--                   </div> -->
<!--                   <a href="dish_list.html"  class="avatar fl"> -->
<!--                     <img style="width: 104px; height: 78px;" src="images/38d43710cdb1ca416496bb157279e3ee311664.jpg"> -->
<!--                   </a> -->
<!--                   <div class="content"> -->
<!--                     <div class="rest-name clearfix"> -->
<!--                       <a  href="dish_list.html" class="ca-deepgrey j-poi-name"> -->
<!--                         <span class="poi-name">莲池张</span> -->
<!--                       </a> -->
<!--                       <span class="order-total">商家电话：13600592707</span> -->
<!--                     </div> -->
<!--                     <div class="rest-detail"> -->
<!--                       <span class="order-id">订单号：10044290280273782</span> -->
<!--                         <span class="order-total">下单时间：2016-07-27 10:40</span> -->
<!--                     </div> -->
<!--                     <div class="order-detail-table"> -->
<!--                       <table> -->
<!--                         <tr> -->
<!--                           <th class="img"></th> -->
<!--                           <th class="name">名称</th> -->
<!--                           <th class="num">数量</th> -->
<!--                           <th class="price">金额</th> -->
<!--                         </tr> -->
<!--                         <tr> -->
<!--                           <td class="img"><img src="images/9bdeedd6bbc411da0ece91fe89785jpeg.jpeg"></td> -->
<!--                           <td class="name">手撕包心菜</td> -->
<!--                           <td class="num">1</td> -->
<!--                           <td class="price">8.00</td> -->
<!--                         </tr> -->
<!--                         <tr> -->
<!--                           <td class="img"><img src="images/1d3e8121424d6fff8b37e27438f84jpeg.jpeg"></td> -->
<!--                           <td class="name">番茄炒蛋</td> -->
<!--                           <td class="num">1</td> -->
<!--                           <td class="price">12.00</td> -->
<!--                         </tr> -->
<!--                       </table> -->
<!--                     </div> -->
<!--                   </div>     -->
<!--                 </div> -->

<!--               </div> -->
          </div>
        </div>
      </div>
    </div>

<div id="footer">
    <div class="footer-container">
        <p>轻课学院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp;</p>
    </div>
</div>


</body></html>