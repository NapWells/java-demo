<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page import="db.DBconnect" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
   <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
   <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
   <script src="JS/xiugaimima.js"></script>
   <link rel="stylesheet" type="text/css" href="CSS/nav.css">
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
	DBconnect client = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
	client.creatConnection();
	String user = (String)session.getAttribute("user");
	ArrayList list=client.query("select guanzhucourse,logo from guanzhu1,course1 where guanzhu1.name='"+user+"' and GUANZHUCOURSE=course1.course");
%>
 <form class="form col-md-offset-4" role="form" id="xiugaiForm" style="width:300px;margin-top:100px;" method="post" action="">
               		<div class="text-center" id="checktwopassword"></div>
                  <div class="form-group">
                     <label >请输入密码</label>
                     <input type="password" class="form-control" id="password" name="password">
                  </div>
                  <div class="form-group">
                     <label >请输入新密码</label>
                     <input type="password" class="form-control" id="password1" name="password1">
                  </div>
                  <div class="form-group">
                     <label >请再次输入密码</label>
                     <input type="password" class="form-control" id="password2" onblur="checkpassword();" name="password2">
                  </div>
                  <div class="row input-group col-md-offset-3">
                        <div class="col-md-4"><input class="btn btn-default" type="button" onClick="xiugaimima();" value="确定"></div>
                        <div class="col-md-3" ><input class="btn btn-default" type="reset" value="重置"></div>
                  </div>
               </form>
</body>
</html>