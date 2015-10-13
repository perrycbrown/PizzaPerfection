
function change_price(element) {
	  var total_price = 0;
	  $(element).find(':selected').each(function() {
		  total_price += parseFloat($(this).data("price"));
	  });
	  $("#"+$(element).attr("name")+"_price").val(total_price);
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
