<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizza Options</title>
<script language="javascript" type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
function change_price(element) {
	  var price = $(element).find(':selected').data("price");
	  //alert(price + " and name is: " + $(element).attr("name"));
	  $("#"+$(element).attr("name")+"_price").val(price);
}
</script>
<style>
h2 {
  text-align: center;
}
table.center {
    margin-left:auto; 
    margin-right:auto;
}

td {
	padding: 5px;
}
</style>

</head>
<body>

<h2>Choose the options to build your pizza:</h2>
<form action="/options/">

<table class="center">

<tr>
<td>Crust type</td>
<td>
<select name="crust" size="1" id="crust" onChange="change_price(this);">
<option value="regular crust" data-price="1.00">Regular crust</option>
<option value="thick crust" data-price="2.00">Thick crust</option>
</select>
<input type="hidden" name="crust_price" value="1.00" id="crust_price">
</td>
</tr>

<tr>
<td>Sauce type</td>
<td>
<select name="sauce" size="1" id="sauce" onChange="change_price(this);">
<option value="regular sauce" data-price="1.00">Regular sauce</option>
<option value="extra sauce" data-price="2.00">Extra sauce</option>
</select>
<input type="hidden" name="sauce_price" value="1.00" id="sauce_price">
</td>
</tr>

<tr>
<td>Cheese type</td>
<td>
<select name="cheese" size="1" id="cheese" onChange="change_price(this);">
<option value="regular cheese" data-price="1.00">Regular cheese</option>
<option value="extra cheese" data-price="2.00">Extra cheese</option>
</select>
<input type="hidden" name="cheese_price" value="1.00" id="cheese_price">
</td>
</tr>

<tr>
<td>Topping type</td>
<td>
<select name="topping" size="1" id="topping" onChange="change_price(this);">
<option value="pepperoni" data-price="1.00">Pepperoni</option>
<option value="mushrooms" data-price="1.00">Mushrooms</option>
<option value="sausage" data-price="2.00">Sausage</option>
</select>
<input type="hidden" name="topping_price" value="1.00" id="topping_price">
</td>
</tr>

<tr>
<td>Submit your pizza:</td>
<td>
<input type="submit" value="Send It!">
</td>
</tr>

</table>
</form>


</body>
</html>