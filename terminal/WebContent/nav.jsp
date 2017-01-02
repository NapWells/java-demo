<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home-ixuexi</title>
   <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
   <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
   <script src="JS/nav.js" type="text/javascript"></script>
   <link rel="stylesheet" type="text/css" href="CSS/nav.css">
</head>
<body>
<nav class="navbar navbar-default" role="navigation" >
   <div class="container">
      <div class="row">
         <div class="navbar-header col-md-3 col-md-offset-1">
            <button type="button" class="navbar-toggle" data-toggle="collapse" 
               data-target="#example-navbar-collapse">
               <span class="sr-only">切换导航</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><strong>i学习学院</strong></a>
         </div>

         <div class="collapse navbar-collapse col-md-3 " id="example-navbar-collapse">
            <ul class="nav navbar-nav">
               <li id="homepage"><a href="home.jsp">首页</a></li>
               <li id="allcourse"><a href="allcourse.jsp">全部课程</a></li>
            </ul>
         </div>

         <div class="col-md-3">
            <form class="navbar-form navbar-right" role="search">
               <div class="form-group col-md-8">
                  <input type="text" class="form-control" placeholder="Search">
               </div>
               <button type="submit" class="col-md-4 btn btn-default">搜索</button>
            </form>    
         </div>
         <%
         if(session.getAttribute("user") == null){
        	 %>
        	 <div class="col-md-3 text-center" style="margin-top:15px;">
             <a data-toggle="modal" data-target="#myModal1" >登陆</a>
             <a data-toggle="modal" data-target="#myModal2" >注册</a>
          </div>
         <%
         }
         else{
        	 String user=session.getAttribute("user").toString();
           
         %>
        	 <div class="col-md-3 text-center dropdown" id="mycenter"" style="margin-top:15px;">
        	 <a href="mycenter.jsp"><%=user %>&nbsp;&nbsp;|&nbsp;个人中心</a>
        	 <a style="padding-left:20px" href="logoffServlet">注销</a>
        	 </div> 
        <%
     	}
         %>
      </div>
   </div>
</nav>


<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content" style="background-image:url('image/loginbg.gif');height:300px;">
            <div class="modal-header">
               <button type="button" class="close" 
                  data-dismiss="modal" aria-hidden="true">
                     &times;
               </button>
               <h4 class="modal-title text-center" id="myModalLabel">
                  用户登陆
               </h4>
            </div>
            <div class="modal-body">
            <%Cookie cookies[]=request.getCookies();
        	String uname="";
        	String pwd="";
        	if(cookies!=null){
        		for(int i=0;i<cookies.length;i++){
        				if(cookies[i].getName().equals("username")){
        					uname=cookies[i].getValue();
        				}
        				if(cookies[i].getName().equals("password")){
        					pwd=cookies[i].getValue();
        				}
        		}	
        	} %>
               <form class="form col-md-offset-3" role="form" style="width:300px;" id="loginForm" method="post" action="">
               		<div class="text-center" id="failLogin"></div>
                  <div class="form-group">
                     <label for="user">用户名</label>
                     <input type="username" class="form-control" id="username" name="username" value="<%=uname %>" placeholder="Username">
                  </div>
                  <div class="form-group">
                     <label for="pass">密码</label>
                     <input type="password" class="form-control" id="password" name="password" value="<%=pwd %>" placeholder="Password">
                  </div>
                  <div class="row ">
                        <div class="col-md-4" style="padding-top:5px;"><input type="checkBox" name="radio" value="记住密码">记住密码</div>
                        <div class="col-md-3"><input class="btn btn-default" type="button" onClick="doFind();" value="登陆">
                        </div>
                  </div>
               </form>
            </div>
         </div><!-- /.modal-content -->
      </div><!-- /.modal -->
   </div>


   <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content" style="background-image:url('image/loginbg.gif');height:500px;">
            <div class="modal-header">
               <button type="button" class="close" 
                  data-dismiss="modal" aria-hidden="true">
                     &times;
               </button>
               <h4 class="modal-title text-center" id="myModalLabel">
                  注册用户
               </h4>
            </div>
            <div class="modal-body">
                  <form class="bs-example bs-example-form col-md-offset-3" style="width:300px;" onsubmit="return checkForm()" role="form" method="post" action="registerServlet">
                      <div class="input-group">
                        <span class="input-group-addon"><img src="image/user.png"></span>
                        <input type="text" class="form-control" name="user" id="user"  onkeyup="checkUsername()"  placeholder="请输入昵称，注册成功后不可修改！">                    
                     </div>
                     <span id="span1">*至少2位，只支持汉字、子母、数字、下划线组合</span>
                     <br>

                     <div class="input-group">
                        <span class="input-group-addon"><img src="image/phone.png"></span>
                        <input type="text" class="form-control" name="phone" id="phone" onkeyup="checkPhone()" placeholder="请输入您的手机号（可作为登陆账号）！">
                     </div>
                     <span id="span2">*手机号码错误</span>
                      <br>
                      
                      <div class="input-group">
                        <span class="input-group-addon"><img src="image/pwd1.png"></span>
                        <input type="password" class="form-control" name="password1" id="password1" onkeyup="checkPassword1()"  placeholder="请输入密码">
                     </div>
                     <span id="span3">*至少6位，只支持子母、数字、下划线组合</span>
                     <br>
                      <div class="input-group">
                        <span class="input-group-addon"><img src="image/pwd2.png"></span>
                        <input type="password" class="form-control" name="password2" id="password2" onkeyup="checkPassword2()" placeholder="请再次输入密码">
                     </div>
					<span id="span4">*两次密码不一致</span>
                     <br>
                      
                     <br>
                     <div class="row">
                        <div class="col-md-7">
                           <div class="input-group " >
                              <span class="input-group-addon"><img src="image/phonecheck.png"></span>
                              <input type="text" class="form-control" name="yanzhenma2" placeholder="请输入短信验证码">
                           </div>
                        </div>
                        <div class="col-md-5">
                           <button type="submit" class="btn btn-default pull-right">获取验证码</button>
                        </div>
                    </div>
                     <br>

                    <div class="input-group col-md-offset-3" >
                        <input class="btn btn-default" type="submit" value="注册">
                        <input class="btn btn-default" type="reset" value="重置">

                    </div>
                   </form>
            </div>
         </div><!-- /.modal-content -->
      </div><!-- /.modal -->
   </div>
</body>
</html>