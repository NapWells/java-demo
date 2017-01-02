<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
     //刷新验证码
    function changeImg(obj,createTypeFlag){
        document.getElementById(obj.id).src="${pageContext.request.contextPath}/PicIdentifyCode2?createTypeFlag="+createTypeFlag+"&"+Math.random();
    }
    </script>
</head>
<body>
	  <form action="${pageContext.request.contextPath}/CheckValidServlet" method="post">
          数字字母混合验证码：<input type="text" name="validateCode"/>
           <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/PicIdentifyCode2" id="validateCodeImg1" onclick="changeImg(this,'nl')">
           <br/>
<!--             中文验证码：<input type="text" name="validateCode"/> -->
<%--             <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/PicIdentifyCode2?createTypeFlag=ch" id="validateCodeImg2" onclick="changeImg(this,'ch')"> --%>
<!--            <br/> -->
<!--           英文验证码：<input type="text" name="validateCode"/> -->
<%--            <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/PicIdentifyCode2?createTypeFlag=l" id="validateCodeImg3" onclick="changeImg(this,'l')"> --%>
<!--           <br/> -->
<!--           数字验证码：<input type="text" name="validateCode"/> -->
<%--              <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/PicIdentifyCode2?createTypeFlag=n" id="validateCodeImg4" onclick="changeImg(this,'n')"> --%>
<!--            <br/> -->
            <input type="submit" value="提交">
         </form>
  </body>
</body>
</html>