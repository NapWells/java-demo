/**
 * 
 */

function selectDelete(basePath,id) {
		$(":hidden").attr("value",id);
		$("#mainForm").attr("action",basePath+"DeleteOneServlet.action");
		$("#mainForm").submit();
}

function deleteBatch(basePath) {
		$("#mainForm").attr("action",basePath+"DeleteBatchServlet.action");
		$("#mainForm").submit();
}
