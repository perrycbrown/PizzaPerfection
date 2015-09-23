
function change_price(element) {
	  var price = $(element).find(':selected').data("price");
	  //alert(price + " and name is: " + $(element).attr("name"));
	  $("#"+$(element).attr("name")+"_price").val(price);
}
