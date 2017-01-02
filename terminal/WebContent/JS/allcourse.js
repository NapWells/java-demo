/**
 * 
 */
$(document).ready(function() {
	$("#1c").click(function(event) {
		window.location.reload();
	});
	
	
	$("#2c").click(function(event) {
		$("#sort").load("allcourse/gongkaike.jsp");
	});
	
	
	$("#3c").click(function(event) {
		$("#sort").load("allcourse/qiyeanquan.jsp");
	});


	$("#4c").click(function(event) {
		$("#sort").load("allcourse/wangzhananquan.jsp");
	});
	
	$("#5c").click(function(event) {
		$("#sort").load("allcourse/kehuduananquan.jsp");
	});
	
	
	$("#6c").click(function(event) {
		$("#sort").load("allcourse/tongxinanquan.jsp");
	});
	
	
	$("#7c").click(function(event) {
		$("#sort").load("allcourse/yidonganquan.jsp");
	});
	
	$("#8c").click(function(event) {
		$("#sort").load("allcourse/anquanlilun.jsp");
	});
	
	$("#9c").click(function(event) {
		$("#sort").load("allcourse/qita.jsp");
	});
});