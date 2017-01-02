/**
 * 
 */
function checkform(id){
	var n=document.getElementById(id);
	if(n.value==""){
		alert("输入不能为空");
		n.focus();
		return false;
	}
	else
		return true;
}