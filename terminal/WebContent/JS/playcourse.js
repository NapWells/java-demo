/**
 * 
 */
charset=UTF-8;
function getnowtime() {
	var mydate = new Date();
	mydate.getYear(); //获取当前年份(2位)
	var year=mydate.getFullYear(); //获取完整的年份(4位,1970-????)
	var month=mydate.getMonth()+1; //获取当前月份(0-11,0代表1月)
	var day=mydate.getDate(); //获取当前日(1-31)
	mydate.getDay(); //获取当前星期X(0-6,0代表星期天)
	mydate.getTime(); //获取当前时间(从1970.1.1开始的毫秒数)
	var hour=mydate.getHours(); //获取当前小时数(0-23)
	var min=mydate.getMinutes(); //获取当前分钟数(0-59)
	var second=mydate.getSeconds(); //获取当前秒数(0-59)
	mydate.getMilliseconds(); //获取当前毫秒数(0-999)
	mydate.toLocaleDateString(); //获取当前日期
	var mytime=mydate.toLocaleTimeString(); //获取当前时间
	mydate.toLocaleString( ); //获取日期与时间alert( month);
	return year+"年"+month+"月"+day+"日"+"  "+hour+":"+min+":"+second;
}
function remark(){
	var course = $("#coursename").text();
	var chapter = $("#chaptername").text();
	var content =$("#content").val();
	if(document.getElementById("radio1").checked)
		var radio = 1;
	else
		var radio = 0;
	$.ajax({
		cache: false,
		type: "POST",
		url:"remarkServlet",	//把表单数据发送到servlet
		data:{A:content,B:course,C:chapter,D:radio},	//要发送的是ajaxFrm表单中的数据
		async: false,
		error: function(request) {
			alert("发送请求失败！");
		},
		success: function(data) {

			$(".remarknum2").html(parseInt($(".remarknum2").text())+1);
				$("#remarkUl").prepend(data);
				$('#remarkForm')[0].reset();
				$('#remarkForm')[1].reset();
		}
	});
}
function guanzhu1(){
	var author = $("#author").text();
	var guanzhu = $("#follow1").text();
	$.ajax({
		cache: false,
		type: "POST",
		url:"gaunzhuServlet1",	//把表单数据发送到servlet
		data:{A:author,B:guanzhu},	//要发送的是ajaxFrm表单中的数据
		async: false,
		error: function(request) {
			alert("发送请求失败！-");
		},
		success: function(data) {
			if(data=="成功关注"){
				$("#guanzhunum2").html(parseInt($("#guanzhunum2").text())+1);
				$("#guanzhu1").replaceWith("<span id='guanzhu1'>已关注</span>");
			}
			else{
				$("#guanzhunum2").html(parseInt($("#guanzhunum2").text())-1);
				$("#guanzhu1").replaceWith("<span id='guanzhu1'>关注</span>");
				
			}
		}
	});
}
function guanzhu(){
	var course = $("#coursename").text();
	var guanzhu = $("#follow").text();
	$.ajax({
		cache: false,
		type: "POST",
		url:"gaunzhuServlet",	//把表单数据发送到servlet
		data:{A:course,B:guanzhu},	//要发送的是ajaxFrm表单中的数据
		async: false,
		error: function(request) {
			alert("发送请求失败！-");
		},
		success: function(data) {
			if(data=="成功关注"){
				$("#guanzhunum").html(parseInt($("#guanzhunum").text())+1);
				$("#guanzhu").replaceWith("<span id='guanzhu'>已关注</span>");
			}
			else{
				$("#guanzhunum").html(parseInt($("#guanzhunum").text())-1);
				$("#guanzhu").replaceWith("<span id='guanzhu'>关注</span>");
				
			}
		}
	});
}