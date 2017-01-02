<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
   <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
   <script src="JS/upload.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS/nav.css">
</head>
<body>

    <div class="panel panel-default">
        <div class="panel-heading text-center">
            上传新课程
        </div>
       <div class="panel-body">
          <form class="form-horizontal col-md-offset-3" role="form" method="post" enctype="multipart/form-data" action="uploadServlet">
            <div class="form-group">
                 <label  class="col-sm-2 control-label">课程名称</label>
                 <div class="col-sm-6">
                 <input type="text" name="name" class="form-control"
                 placeholder="请输课程名称">
                 </div>
            </div>
            <div class="form-group">
                 <label  class="col-sm-2 control-label">课程分类</label>
                 <div class="col-sm-6">
                 <select name="sort" class="form-control">
                    <option>--请选择--</option>
                    <option>公开课</option>
                    <option>企业安全</option>
                    <option>网站安全</option>
                    <option>客户端安全</option>
                    <option>通信安全</option>
                    <option>移动安全</option>
                    <option>安全理论</option>
                    <option>其他</option>
                    
                </select>
                </div> 
            </div>
            <div class="form-group">
                 <label  class="col-sm-2 control-label">课程难度</label>
                 <div class="col-sm-6">
                 <select name="difficult" class="form-control">
                    <option>--请选择--</option>
                    <option>初级</option>
                    <option>中级</option>
                    <option>高级</option>
                </select>
                </div> 
            </div>
            <div class="form-group">
                 <label  class="col-sm-2 control-label">收费模式</label>
                 <div class="col-sm-6">
                 <select name="charge" class="form-control">
                    <option>--请选择--</option>
                    <option>免费</option>
                    <option>收费</option>
                </select>
                </div> 
            </div>
            <div class="form-group">
                 <label  class="col-sm-2 control-label">总课时</label>
                 <div class="col-sm-6">
                 <input type="text" name="coursehour" class="form-control" placeholder="请输入课时数">
                 </div>
            </div>
            <div class="form-group">
                 <label  class="col-sm-2 control-label">课程标签</label>
                 <div class="col-sm-6">
                 <input type="text" name="label" class="form-control" placeholder="课程标签可帮助用户快速找到课程">
                 </div>
            </div>
          <div class="form-group">
                 <label  class="col-sm-2 control-label">课程LOGO</label>
                 <div class="col-sm-6">
                 <input type="file" name="file" class="form-control" >
                 </div>
            </div>
             <div class="form-group">
                 <label  class="col-sm-2 control-label">课程描述</label>
                 <div class="col-sm-6">
                  <textarea class="form-control" rows="3" name="courseintro" placeholder="请输入课程简介"></textarea>
                 </div>
            </div>
            <div><input class="btn btn-default col-md-offset-3"  type="submit" value="下一步">
            </div>
        </form>
         
       </div>
    </div>
   
</script>
</body>
</html>