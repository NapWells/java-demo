$(document).ready(function(){
    $.each($(".shop-cartbutton"), function(i,vals){
         $(this).click(function(){
             $("#shop-cartbasket").show();
             $("#shopbasket .ng-isolate-scope").append("<div class='shop-cartbasket-tablerow'>"+
                     "<div class='cell itemname' id='"+$(this).attr("id")+"'>"+$(this).parents("span").siblings().find("h3").text()+"</div>"+
                "<div class='cell itemquantity'>"+
                "<button  class='reduce'>-</button>"+
                "<input class='ng-pristine ng-valid' value='1'>"+
                "<button class='addtion'>+</button>"+
                "</div>"+
                "<div class='cell itemtotal ng- binding'>"+$(this).parents("span").prev().text()+"</div>"+
                "</div>");
             $("#price").text($("#price").text()*1+$(this).parents("span").prev().text()*1);
             $("#price").next().children().text( $("#price").next().children().text()*1+1);
             $.each($(".reduce"), function(i,val){
            	 $(this).click(function(){
                	 var value = $(this).next().val()*1-1;
                     if(value==0){
                    	 $(val).parents().find(".shop-cartbasket-tablerow").eq(i).remove();
                    	 $("#price").text($("#price").text()*1-$(vals).parents("span").prev().text()*1);
                    	 $("#price").next().children().text( $("#price").next().children().text()*1-1);
                     }else{
                    	 $(this).next().val(value);
                     }
                     if(!$(".shop-cartbasket-tablerow").length>0){
                    	 $("#shop-cartbasket").css("display","none");
                     }
                 });
             });
             
             $.each($(".addtion"), function(i,val){
            	  $(this).click(function(){
                 	 var value = $(this).prev().val()*1+1;
                 	 $(this).prev().val(value);
                 	$("#price").text($("#price").text()*1+$(vals).parents("span").prev().text()*1);
                 	$("#price").next().children().text( $("#price").next().children().text()*1+1);
                  });
             });
         });
         $("#buyList").click(function(){
          	var totalPrice = $("#price").text()*1;
          	var totalPiece = $("#price").next().children().text()*1;
          	var dishList = "";
          	var foodname = "";
          	var basePath = $("input[name='basePath']").val();
          	$.each($(".itemname"), function(i,vals){
          		dishList =dishList+ $(this).attr("id")+" "+$(this).next().children("input").val()+" ";
          		foodname = foodname + $(this).text()+" "+$(this).next().children("input").val()+" " + $(this).siblings("div:last").text()+" ";
          	});
          	$("input[name='totalPrice']").val(totalPrice);
          	$("input[name='totalPiece']").val(totalPiece);
          	$("input[name='dishList']").val(dishList);
          	$("input[name='foodname']").val(foodname);
          	$("form:first").attr("action","OrderDetailServlet");
          	$("form:first").submit();
          });
      });
    
  
});
