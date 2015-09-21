<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map.Entry" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<form action="../review/" method="post">

<table class="center">

<c:set var="prevtype" value=""  />
<c:forEach items="${pizzaelements}" var="element" varStatus = "status">

<c:set var="type" scope="session" value="${element.getType()}"/>

<c:if test="${prevtype == ''}">
<tr>
<td>${element.getType()}</td>
<td>
<select name="${element.getType()}" size="1" id="${element.getType()}" onChange="change_price(this);">
</c:if>

<c:if test="${type == prevtype || prevtype == ''}">
<option value="${element.getLabel()}" data-price="${element.getPrice()}">${element.getLabel()}</option>
</c:if>

<c:if test="${type != prevtype && prevtype != ''}">
</select>
<input type="hidden" name="${prevtype}_price" value="1.00" id="${prevtype}_price">
</td>
</tr>
<tr>
<td>${element.getType()}</td>
<td>
<select name="${element.getType()}" size="1" id="${element.getType()}" onChange="change_price(this);">
<option value="${element.getLabel()}" data-price="${element.getPrice()}">${element.getLabel()}</option>
</c:if>

<c:set var="prevtype" value="${type}"  />

<c:if test="${status.isLast()}" >
</select>
<input type="hidden" name="${type}_price" value="1.00" id="${type}_price">
</td>
</tr>
</c:if>
</c:forEach>


<tr>
<td>Size:</td>
<td>
<select name="size" size="1" id="size" onChange="change_price(this);">

<c:forEach items="${pizzasizeshash}" var="size">
<option value="${size.getLabel()}" data-price="${size.getMultiplier()}">${size.getLabel()}</option>
</c:forEach>

</select>
<input type="hidden" name="size_price" value="1.00" id="size_price">
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