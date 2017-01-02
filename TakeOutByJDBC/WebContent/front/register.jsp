<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>QK外卖 - 登录</title>
  <link href="<%=basePath%>front/css/app.css" rel="stylesheet">
    <link href="<%=basePath%>front/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src = "<%=basePath%>front/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src = "<%=basePath%>front/js/register.js"></script>
</head>
<body>
<header class="account-header"></header>
<div class="container">

  <div class="account-container">
    <div class="login">
      <img class="account-illustration" src="<%=basePath%>front/images/logo-register.png">
      <div class="account-main aside">
        <div class="account-line">
          <h3 class="account-title line-left">新用户注册</h3>

        </div>
        <div class="login-form">
          <form class="account-form" action="<%=basePath%>RegisterServlet" method="post" onsubmit="return validInput()"> 
            <div class="form-group compact"> 
              <input name="username" class="account-input withicon ng-pristine ng-invalid ng-invalid-required" placeholder="请输入手机号/邮箱/用户名" type="text">
              <i class="fa fa-user account-inputicon"></i>

            </div>
            <div class="form-group"> 
              <input name="password" type="password" class="account-input withicon ng-pristine ng-invalid ng-invalid-required ng-valid-minlength" placeholder="请输入密码">
              <i class="fa fa-lock account-inputicon"></i>
            </div> 
            <div class="form-group"> 
              <input name="repassword" type="password" class="account-input withicon ng-pristine ng-invalid ng-invalid-required ng-valid-minlength" placeholder="请确认密码">
              <i class="fa fa-lock account-inputicon"></i>
            </div> 
            <div class="form-group"> 
              <input class="account-btn submit ng-binding" type="submit" value="  立即注册">
            </div> 
          </form>
        </div>
      </div> 
    </div>
  </div>

  <footer class="account-footer">
    <p class="footer-line line-under">
      轻课学院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp;
    </p>
  </footer>
</div>



</body></html>