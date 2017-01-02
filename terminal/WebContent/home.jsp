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
   <script src="JS/home.js" type="text/javascript"></script>
   <link rel="stylesheet" type="text/css" href="CSS/home.css">
   <script src="JS/home.js" type="text/javascript"></script>
</head>
<body><jsp:include page="nav.jsp"></jsp:include>
   <div class="container">
      <div class="row">
            <div class="col-md-6" style="padding-left:0;">
               <div id="myCarousel" class="carousel slide " style="width:600px;">
                  <!-- 轮播（Carousel）指标 -->
                  <ol class="carousel-indicators">
                     <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                     <li data-target="#myCarousel" data-slide-to="1"></li>
                     <li data-target="#myCarousel" data-slide-to="2"></li>
                     <li data-target="#myCarousel" data-slide-to="3"></li>
                  </ol>   
                  <!-- 轮播（Carousel）项目 -->
                  <%
                 	 request.setCharacterEncoding("UTF-8");
          			DBconnect course = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
          			course.creatConnection();
          			ArrayList list1 = course.query("select course,logo from course1 order by 'uploadtime'");
          			course.close();
          			
                  %>
                  <div class="carousel-inner">
                     <div class="item active">
                        <a href="courseInfo?name=<%=list1.get(0)%>"><img src="<%=list1.get(1)%>" alt="First slide" style="width: 100%;"></a>
                     </div>
                     <div class="item">
                        <a href="courseInfo?name=<%=list1.get(2) %>"><img src="<%=list1.get(3)%>" alt="Second slide" style="width: 100%;"></a>
                     </div>
                     <div class="item">
                        <a href="courseInfo?name=<%=list1.get(4) %>"><img src="<%=list1.get(5)%>" alt="Third slide" style="width: 100%;"></a>
                     </div>
                     <div class="item">
                        <a href="courseInfo?name=<%=list1.get(6) %>"><img src="<%=list1.get(7)%>" alt="Fourth slide" style="width: 100%;"></a>
                     </div>
                  </div>
                  <!-- 轮播（Carousel）导航 -->
                  <a class="carousel-control left" href="#myCarousel" 
                     data-slide="prev">&lsaquo;</a>
                  <a class="carousel-control right" href="#myCarousel" 
                     data-slide="next">&rsaquo;</a>
               </div> 
            </div>
         
         <div class="col-md-6 " style="padding-left:30px;">
            <div class="col-md-3"></div>
            <ul id="myTab" class="nav nav-tabs ">
               <li class="active">
                  <a href="#new" data-toggle="tab">
                     	最新课程帮
                  </a>
               </li>
               <li><a href="#hot" data-toggle="tab">最热课程榜</a></li>
            </ul>
            <div id="myTabContent" class="tab-content row">
               <div class="col-xs-6 col-md-offset-3 tab-pane fade in active" id="new">
                     <ul class="list-unstyled">
                       <%for(int i=0;i<list1.size()-4;i+=2) {%>
                       	<li><%=list1.get(i) %></li>
                       	<li><br></li>
                      <% }%>
                     </ul>
               </div>
               <div class=" col-xs-6 col-md-offset-3 tab-pane fade" id="hot">
                  <ul class="list-unstyled">
                      <%for(int i=0;i<list1.size()-4;i+=2) {%>
                       	<li><%=list1.get(i) %></li>
                       	<li><br></li>
                      <% }%>
                  </ul>
               </div>
            </div>
         </div>
      </div>

      <div class="row">
         <br><br>
         <p>今日热门</p>
             <table class="table ">
               <tr>
                  <td>
	                  <div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list1.get(8) %>">
	 						<img class="img-responsive" src="<%=list1.get(9)%>" width="304" height="150">
	  						</a>
	 					 <div class="desc"><%=list1.get(8)%></div>
					</div>
				 </td>
				 
                  <td>
	                  <div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list1.get(10)%>">
	 						<img  class="img-responsive" src="<%=list1.get(11)%>"   width="304" height="150">
	  						</a>
	 					 <div class="desc"><%=list1.get(10)%></div>
					</div>
				 </td>
                   <td>
	                  <div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list1.get(12)%>">
	 						<img  class="img-responsive" src="<%=list1.get(13)%>"  width="304" height="150">
	  						</a>
	 					 <div class="desc"><%=list1.get(12)%></div>
					</div>
				 </td>
               </tr>
               <tr>
                   <td>
	                  <div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list1.get(14)%>">
	 						<img class="img-responsive" src="<%=list1.get(15)%>"  width="304" height="150" >
	  						</a>
	 					 <div class="desc"><%=list1.get(14)%></div>
					</div>
				 </td>
                   <td>
	                  <div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list1.get(16)%>">
	 						<img class="img-responsive" src="<%=list1.get(17)%>" alt="Third slide" width="304" height="150" >
	  						</a>
	 					 <div class="desc"><%=list1.get(16)%></div>
					</div>
				 </td>
				  <td>
	                  <div class="imge">
	  						<a target="_blank" href="courseInfo?name=<%=list1.get(18)%>">
	 						<img class="img-responsive" src="<%=list1.get(19)%>" alt="Third slide" width="304" height="150" >
	  						</a>
	 					 <div class="desc"><%=list1.get(18)%></div>
					</div>
				 </td>
               </tr>
            </table>  
         </div>
      </div>

</body>
</html>