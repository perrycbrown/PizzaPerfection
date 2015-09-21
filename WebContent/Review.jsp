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

<h2>Here are the options you chose for your pizza:</h2>
<form action="../payment/">

<table class="center">

<tr>
<td>Crust type</td>
<td>
<%= request.getParameter("crust") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("crust_price")).replace(' ', '0') %>
</td>
</tr>

<tr>
<td>Sauce type</td>
<td>
<%= request.getParameter("sauce") %>
</td>
<td>
&#36;<%= request.getParameter("sauce_price") %>
</td>
</tr>

<tr>
<td>Cheese type</td>
<td>
<%= request.getParameter("cheese") %>
</td>
<td>
&#36;<%= request.getParameter("cheese_price") %>
</td>
</tr>

<tr>
<td>Topping type</td>
<td>
<%= request.getParameter("topping") %>
</td>
<td>
&#36;<%= request.getParameter("topping_price") %>
</td>
</tr>

<tr>
<td>Size of pizza:</td>
<td>
<%= request.getParameter("size") %>
</td>
<td>
&nbsp;
</td>
</tr>

<tr>
<td>Order total</td>
<td>
=
</td>
<td>
&#36;<%= request.getAttribute("total") %>
</td>
</tr>

<tr>
<td>Finish and pay:</td>
<td>
<form action="payment" method="post">
<input type="submit" value="Pay It!">
</form>
</td>
</tr>

</table>
</form>


</body>
</html>