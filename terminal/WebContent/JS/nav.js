/**
 * 
 */
function doFind(){

	$.ajax({
		cache: false,
		type: "POST",
		url:"loginServlet",	//把表单数据发送到ajax.jsp
		data:$('#loginForm').serialize(),	//要发送的是ajaxFrm表单中的数据
		async: false,
		error: function(request) {
			alert("发送请求失败！");
		},
		success: function(data) {
			if(data=="false")
				$("#failLogin").html("账号或密码错误");	//将返回的结果显示到ajaxDiv中
			else
				window.location.href="home.jsp";
		}
	});
}
function checkUsername(){
	var reg=/^[a-zA-Z0-9_u4e00-u9fa5]+$/;
	var userName=document.getElementById("user").value;
	if(userName.match(reg)==null||userName==""){
			$("#span1").css("display","inline");
			return false;
		}
	else{
		$("#span1").css("display","none");
		return true;
	}
}
function checkPhone(){
	var reg =/^((\(\d{3}\))|(\d{3}\-))?13\d{9}|14[57]\d{8}|15\d{9}|18\d{9}$/;
	var phone = document.getElementById("phone").value;
	if(phone.match(reg)==null||phone==""){
		$("#span2").css("display","inline");
		return false;
	}
	else{
		$("#span2").css("display","none");
		return true;
	}
}

function checkPassword1(){
	var reg = /^\w+$/;
	var password1=document.getElementById("password1").value;
	if(password1.match(reg)==null||password1==""){
		$("#span3").css("display","inline");
		return false
	}
	else{
		$("#span3").css("display","none");
		return true;
	}
}
function checkPassword2(){
	var password1=document.getElementById("password1").value;
	var Password2=document.getElementById("password2").value;
	if(password1!==Password2){
		$("#span4").css("display","inline");
		return false;
	}
	else{
		$("#span4").css("display","none");
		return true;
	}
}
function checkForm(){
	
	if(checkUsername()==false||checkPhone()==false||checkPassword1()==false||checkPassword2()==false)
		return false;
	else
		return true;
}

