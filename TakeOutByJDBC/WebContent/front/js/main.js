$(document).ready(function(){

	$(".order-complaint").click(function(){
		var detail_table = $(this).parents().closest(".brief-intro").find(".order-detail-table");
		if(!detail_table.is(":visible")) {
			detail_table.slideDown();
		} else {
			detail_table.slideUp();
		}
		return false;
	});

	$(".tabnavigation a").click(function(){
		var item = $(this).attr("data-item");

		$(".tabnavigation a").removeClass("active");
		$(".profile-panelcontent").removeClass("active");
		$(this).addClass("active");
		$("#" + item).addClass("active");
	});
});