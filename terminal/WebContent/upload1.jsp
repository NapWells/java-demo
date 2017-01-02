<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="db.DBconnect"%>
 <%@ page import="java.util.ArrayList"%>
 <%@ page import= "java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
   <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap-3.3.5-dist/js/jquery-2.2.3.min.js"></script>
   <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
   <script src="JS/upload.js"></script>
   
</head>
<body>
<%String course =(String)request.getAttribute("course");  %>
<jsp:include page="nav.jsp"/>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            上传新课程
        </div>
       <div class="panel-body">
          <form class="form-horizontal col-md-offset-3" role="form" enctype="multipart/form-data" method="post" action="upload1Servlet">
            <div class="form-group">
                 <label  class="col-sm-2 control-label" >视频名称</label>
                 <div class="col-sm-5">
                 <input type="text" name="chaptername" class="form-control"
                 placeholder="请输入课时名称">
                 </div>
            </div>
 			<div class="form-group">
                 <label  class="col-sm-2 control-label">所属章节</label>
                 <div class="col-sm-5">
                <select name="chapter" class="form-control">
                    <option>--请选择--</option>
                    <option>第一章</option>
                    <option>第二章</option>
                    <option>第三章</option>
                    <option>第四章</option>
                    <option>第五章</option>
                    <option>第六章</option>
                    <option>第七章</option>
                    <option>第八章</option>
                    
                </select>
                 </div>
            </div>
            <div class="form-group">
                 <label  class="col-sm-2 control-label">课程价格</label>
                 <div class="col-sm-5">
                 <input type="number" name="chapterprice" class="form-control"
                 placeholder="请输入课时收费">
                 </div>
            </div>
          
            <div class="form-group">
                 <label  class="col-sm-2 control-label">视屏路径</label>
                 <div class="col-sm-5">
                 <input type="file" name="path" class="form-control" >
                 </div>
            </div>
             <div style="display:none;"><input type="text" name="course" value="<%=course %>"></div>
            <div><input class="btn btn-default col-md-offset-4" type="submit"  value="添加">
            </div>
        </form>
        <br><br>

        <table class="table table-striped table-bordered table-hover table-condensed">
			   <caption class="text-center"><%=course %></caption>
			   <thead>
			      <tr>
			         <th>章节数</th>
			         <th>视屏名称</th>
			         <th>文件名</th>
			         <th>视屏价格</th>
			         <th>上传状态</th>
			      </tr>
			   </thead>
			   <tbody>
			      <%DBconnect course2 = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
					course2.creatConnection();
					List<String> list=course2.query("select chapter,name,filename,price from course2 where course ='"+course+"'");
					for(int i=0;i<list.size();i+=4){%>
						<tr>
							<td><%=list.get(i) %></td>
							<td><%=list.get(i+1) %></td>
							<td><%=list.get(i+2) %></td>
							<td><%=list.get(i+3) %></td>
							<td>100%</td>
						</tr>
					<%}
					%>
			   </tbody>
			</table>
       
		<div style="margin-top:30px;"><button class="btn btn-default col-md-offset-6"><a href="mycenter.jsp">完成</a></button>
         </div>
       </div>
    </div>
   
</div>
</body>
</html>