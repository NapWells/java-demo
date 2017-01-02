/**
 * 
 */
function checkpassword(){
	if($("input[name='password1']").val()!=$("input[name='password2']").val()){
		$("#checktwopassword").html("两次密码不一致");
		return false;
	}
	else{
		$("#checktwopassword").html("");
		return true;
	}
}
function xiugaimima(){
	if(checkpassword){}
		ajax({
		cache: false,
		type: "POST",
		url:"xiugaimimaServlet",	//把表单数据发送到ajax.jsp
		data:$('#xiugaiForm').serialize(),	//要发送的是ajaxFrm表单中的数据
		async: false,
		error: function(request) {
			alert("发送请求失败！");
		},
		success: function(data) {
			if(data=="false"){
				$("#checktwopassword").html("初始密码错误");
			}
			if(data=="true"){
				alert("修改密码成功");
				window.location.href="mycenter.jsp";
			}
		}
	});
}

