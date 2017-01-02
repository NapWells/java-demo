/**
 * 
 */
function checkUsername(obj){
	var userName=document.getElementById(obj);
	if(userName.value.length>12||(userName.value.length<8&&userName.value.length!=0)){
			alert("用户名格式错误,请重新输入");
			document.getElementById(obj).value="";
			userName.focus();
		}
}
function checkPassword(){
	var password=document.getElementById("password").value;
	var rePassword=document.getElementById("repassword").value;
	if(password!==rePassword){
		alert("两次密码不一致");
		document.getElementById("repassword").value="";
		rePassword.focus();
	}
}
function checkForm(){
	var male=document.getElementById("male");
	var female=document.getElementById("female");
	if(document.getElementById("username").value==""){
		alert("用户名不能为空");
		return false;
	}
	else if(document.getElementById("password").value==""){
		alert("密码不能为空");
		return false;
	}
	else if(!male.checked&&!female.checked){
		alert("请选择性别");
		return false;
	}
	else if(document.getElementById("age").value==""){
		alert("请输入年龄");
		return fasle;
	}
	else if(document.getElementById("degree").selected){
		alert("请选择学历");
		return false;
	}
	else if(!document.getElementById("sleep").checked&&!document.getElementById("taoke").checked&&
			!document.getElementById("game").checked&&!document.getElementById("eat").checked){
		alert("兴趣爱好至少选择一项");
		return false;
	}
	else
		{
		var sex;
		if(male.checked)
			sex=male.value;
		else
			sex=female.value;
		
		var degree;
		if(document.getElementById("zhuanke").selected)
			degree=document.getElementById("zhuanke").value;
		if(document.getElementById("benke").selected)
			degree=document.getElementById("benke").value;
		if(document.getElementById("shuoshi").selected)
			degree=document.getElementById("shuoshi").value;
		if(document.getElementById("boshi").selected)
			degree=document.getElementById("boshi").value;
		
		var hobby="";
		if(document.getElementById("sleep").checked)
			hobby+=document.getElementById("sleep").value+"、";
		if(document.getElementById("taoke").checked)
			hobby+=document.getElementById("taoke").value+"、";
		if(document.getElementById("game").checked)
			hobby+=document.getElementById("game").value+"、";
		if(document.getElementById("eat").checked)
			hobby+=document.getElementById("eat").value;
		
		alert("用户名："+document.getElementById("username").value+"\n"
				+"密码："+document.getElementById("password").value+"\n"
				+"性别："+sex+"\n"
				+"年龄："+document.getElementById("age").value+"\n"
				+"学历："+degree+"\n"
				+"兴趣爱好："+hobby
				);
		return true;
		}
}