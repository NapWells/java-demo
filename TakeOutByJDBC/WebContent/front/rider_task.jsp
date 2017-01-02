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
                    <a href="user_info.html" class="topbar-item">个人中心</a>
                    <a href="rider_task.html" class="topbar-item focus">立即抢单
                        <i class="fa fa-bell" style="color: red;position:relative;top: -8px;"></i>
                    </a>

                    <nav class="topbar-nav">
                        <div class="topbar-profilebox">
                            <span><a href="login.html">登录</a> | <a href="register.html">注册</a></span>
                        </div>
                    </nav>
                </div>
            </header>
        </div>
    </div>
    <div class="ng-scope">
      <div class="profile-container container">
        <div class="clearfix" style="height:50px;"></div>
        <div class="profile-panel">
          <h3 class="profile-paneltitle ng-scope">
            <span class="ng-binding">当前订单</span>
            <span class="subtitle ng-binding"></span>
          </h3>
          <div id="rider_task_list">
            <table>
              <tr>
                <td class="img"><img style="width: 104px; height: 78px;" src="images/38d43710cdb1ca416496bb157279e3ee311664.jpg"></td>
                <td class="shop">小小和记</td>
                <td class="addr">杭州市西湖区翠苑一区</td>
                <td class="price">¥18.00</td>
                <td class="action"><button>立即抢单</button></td>
              </tr>
              <tr>
                <td class="img"><img style="width: 104px; height: 78px;" src="images/38d43710cdb1ca416496bb157279e3ee311664.jpg"></td>
                <td class="shop">小小和记</td>
                <td class="addr">杭州市西湖区翠苑一区</td>
                <td class="price">¥18.00</td>
                <td class="action"><button>立即抢单</button></td>
              </tr>
              <tr>
                <td class="img"><img style="width: 104px; height: 78px;" src="images/38d43710cdb1ca416496bb157279e3ee311664.jpg"></td>
                <td class="shop">小小和记</td>
                <td class="addr">杭州市西湖区翠苑一区</td>
                <td class="price">¥18.00</td>
                <td class="action"><button>立即抢单</button></td>
              </tr>
              <tr>
                <td class="img"><img style="width: 104px; height: 78px;" src="images/38d43710cdb1ca416496bb157279e3ee311664.jpg"></td>
                <td class="shop">小小和记</td>
                <td class="addr">杭州市西湖区翠苑一区</td>
                <td class="price">¥18.00</td>
                <td class="action"><button>立即抢单</button></td>
              </tr>
              <tr>
                <td class="img"><img style="width: 104px; height: 78px;" src="images/38d43710cdb1ca416496bb157279e3ee311664.jpg"></td>
                <td class="shop">小小和记</td>
                <td class="addr">杭州市西湖区翠苑一区</td>
                <td class="price">¥18.00</td>
                <td class="action"><button>立即抢单</button></td>
              </tr>
            </table>
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