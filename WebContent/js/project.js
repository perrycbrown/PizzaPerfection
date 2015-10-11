
function change_price(element) {
	  var price = $(element).find(':selected').data("price");
	  //alert(price + " and name is: " + $(element).attr("name"));
	  $("#"+$(element).attr("name")+"_price").val(price);
}

function select_quantity(element) {
	val = $(element).val();
	if ($(element).is(":checked")) {
		$("#" + val + "_quantity").val("1");
	}
	else {
		$("#" + val + "_quantity").val("");
	}
}

function set_checkbox (element) {
	var id = parseInt($(element).attr("id"));
	if ($(element).val() == "") {
		$("#" + id + "_checkbox").prop( "checked", false );
	}
	else {
		$("#" + id + "_checkbox").prop( "checked", true );
	}
}
