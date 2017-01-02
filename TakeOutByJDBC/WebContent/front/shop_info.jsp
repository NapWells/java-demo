<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>QK外卖 - 首页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link href="css/vendor.css" rel="stylesheet">
    
    <link href="css/main.css" rel="stylesheet">
    <link href="css/profile.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <script src="js/vendor.js" type="text/javascript" crossorigin="anonymous"></script>
    <script src="js/main.js" type="text/javascript" crossorigin="anonymous"></script>
    <script type="text/javascript"></script>
</head>
<body>
    <div class="ng-isolate-scope">
        <div class=" ng-isolate-scope">
            <header class="topbar">
                <div class="container clearfix">
                    <h1>
                        <a href="index.html" class="topbar-logo icon-logo">
                            <img src="./images/logo-50.png">
                            <span>QK外卖</span>
                        </a>
                    </h1>
                    <a href="index.html" class="topbar-item topbar-homepage">首页</a>
                    <a href="order_list.html" class="topbar-item">我的订单</a>
                    <a href="user_info.html" class="topbar-item focus">商家信息</a>

                    <nav class="topbar-nav">
                        <div class="topbar-profilebox">
                            <span><a href="login.html">登录</a> | <a href="register.html">注册</a></span>
                        </div>
                    </nav>
                </div>
            </header>
        </div>
    </div>
    <div class="clearfix" style="height:50px;"></div>
    <div class="">
        <div class="profile profile-container container">
            <div class="profile-panel">
                <div class="profile-footprint ">
                    <div class="tabnavigation">
                        <a class="active" data-item="self-info">基本信息</a>
                        <a data-item="pw-info">修改密码</a>
                        <a data-item="dish-info">菜单</a>
                    </div>
                    <div class="profile-panelcontent active" id="self-info">
                        <div class="profileinfo">
                            <p class="profileinfo-item">
                                <span class="profileinfo-label">商铺名称</span>
                                <input type="text" value="小小和记">
                            </p>
                            <p class="profileinfo-item">
                                <span class="profileinfo-label">联系电话</span>
                                <input type="text" value="15000000000">
                            </p>
                            <p class="profileinfo-item">
                                <span class="profileinfo-label">商铺地址</span>
                                <input type="text" value="" placeholder="请完善您的地址信息">
                            </p>
                            <p class="profileinfo-item">
                                <button>保存修改</button>
                            </p>
                        </div>
                    </div>
                    <div class="profile-panelcontent" id="dish-info">
                        <table>
                            <tr>
                              <th class="img"></th>
                              <th class="name">名称</th>
                              <th class="desc">简介</th>
                              <th class="num">限量</th>
                              <th class="price">金额</th>
                              <th class="action"></th>
                            </tr>
                            <tr>
                              <td class="img"><img src="images/9bdeedd6bbc411da0ece91fe89785jpeg.jpeg"></td>
                              <td class="name">手撕包心菜</td>
                              <td class="desc">微辣</td>
                              <td class="num">20</td>
                              <td class="price">8.00</td>
                              <td><button>修改</button></td>
                            </tr>
                            <tr>
                              <td class="img"><img src="images/1d3e8121424d6fff8b37e27438f84jpeg.jpeg"></td>
                              <td class="name">番茄炒蛋</td>
                              <td class="desc">经典杭帮菜</td>
                              <td class="num">100</td>
                              <td class="price">12.00</td>
                              <td><button>修改</button></td>
                            </tr>
                            <tr>
                              <td class="img"><input type="file"></td>
                              <td class="name"><input type="text"></td>
                              <td class="desc"><input type="text"></td>
                              <td class="num"><input type="text"></td>
                              <td class="price"><input type="text"></td>
                              <td><button>添加</button></td>
                            </tr>
                        </table>
                    </div>
                    <div class="profile-panelcontent" id="pw-info">
                        <div class="profileinfo">
                            <p class="profileinfo-item">
                                <span class="profileinfo-label">旧密码</span>
                                <input type="password">
                            </p>
                            <p class="profileinfo-item">
                                <span class="profileinfo-label">新密码</span>
                                <input type="password">
                            </p>
                            <p class="profileinfo-item">
                                <span class="profileinfo-label">确认密码</span>
                                <input type="password">
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