<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>QK外卖 - 登录</title>
  <link href="<%=basePath%>front/css/app.css" rel="stylesheet">
    <link href="<%=basePath%>front/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src = "<%=basePath%>front/js/jquery-3.1.1.js"></script>
     <script type="text/javascript" src = "<%=basePath%>front/js/login.js"></script>
</head>
<body>
<header class="account-header"></header>
<div class="container">

  <div class="account-container">
    <div class="login">
      <div class="account-main aside">
        <div class="account-line">
          <h3 class="account-title line-left">登录</h3>

        </div>
        <div class="login-form">
          <form class="account-form" action = "<%=basePath%>LoginServlet" method="post" onsubmit="return validInput()"> 
            <div class="form-group compact"> 
              <input name="username" class="account-input withicon ng-pristine ng-invalid ng-invalid-required" placeholder="手机号/邮箱/用户名" type="text">
              <i class="fa fa-user account-inputicon"></i>

            </div>
            <div class="form-group"> 
              <input name="password" class="account-input withicon ng-pristine ng-invalid ng-invalid-required ng-valid-minlength" placeholder="密码" type="password" >
              <i class="fa fa-lock account-inputicon"></i>
            </div> 
            <div class="form-group"> 
              <input class="account-btn submit ng-binding" type="submit" value="登陆">
            </div> 
          </form>
        </div>
          <div class="line-right" id="account-register"> 
            <a href="register.jsp" class="register_link">新用户注册</a>
          </div>
      </div> 
      <img class="account-illustration" src="images/logo.png">
    </div>
  </div>

  <footer class="account-footer">
    <p class="footer-line line-under">
      轻课学院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp;
    </p>
  </footer>
</div>



</body></html>