/**
 * 
 */
$(document).ready(function() {
	$("#submit").click(function(event) {

		$("#tab").append("<tr>"+
				"<td>"+$("#chapter").val()+"</td>"+
				"<td>"+$("#chaptername").val()+"</td>"+
				"<td>"+$("#path").val()+"</td>"+
				"<td>"+$("#chapterprice").val()+"</td>"+
				"</tr>");
	});
});