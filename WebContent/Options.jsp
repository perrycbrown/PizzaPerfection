<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizza Options</title>
<c:import url="/includes/head.jsp" />
</head>
<body>

<c:import url="/includes/top.jsp" />

<div class="container">
	<div class="row center-block">
  		<div class="col-md-12 ">

<h2 class="text-center">Choose the options to build your pizza:</h2>
<form action="../review/" method="post" id="theform">

<table class="table table-striped table-bordered table-hover">

<c:set var="prevtype" value=""  />
<c:set var="pizza" value="${pizza}" scope="application" />
<c:forEach items="${pizzaelements}" var="element" varStatus = "status">

	<c:set var="type" scope="session" value="${element.getType()}"/>
	<c:set var="label" value="${element.getLabel()}" />

	<c:if test="${prevtype == ''}">
		<tr>
		<td class="text-right">Type of ${element.getType()}:</td>
		<td class="left">
		<select name="${element.getType()}" class="form-control" size="1" id="${element.getType()}" onChange="change_price(this);">
	</c:if>

	<c:if test="${type == prevtype || prevtype == ''}">
		<c:choose>
			<c:when test="${label == pizza.getCrustType() || label == pizza.getSauceType() || label == pizza.getCheeseType() || label == pizza.getToppingType()}">
				<option value="${element.getLabel()}" data-price="${element.getPrice()}" selected>${element.getLabel()}</option>
			</c:when>
			<c:otherwise>
				<option value="${element.getLabel()}" data-price="${element.getPrice()}">${element.getLabel()}</option>
			</c:otherwise>
		</c:choose>
	</c:if>

	<c:if test="${type != prevtype && prevtype != ''}">
		</select>
		<input type="hidden" name="${prevtype}_price" value="1.00" id="${prevtype}_price">
		</td>
		</tr>
		<tr>
		<td class="text-right">Type of ${element.getType()}:</td>
		<td>
		<select name="${element.getType()}" class="form-control" size="1" id="${element.getType()}" onChange="change_price(this);">
		<c:choose>
			<c:when test="${label == pizza.getCrustType() || label == pizza.getSauceType() || label == pizza.getCheeseType() || label == pizza.getToppingType()}">
				<option value="${element.getLabel()}" data-price="${element.getPrice()}" selected>${element.getLabel()}</option>
			</c:when>
			<c:otherwise>
				<option value="${element.getLabel()}" data-price="${element.getPrice()}">${element.getLabel()}</option>
			</c:otherwise>
		</c:choose>	</c:if>

	<c:set var="prevtype" value="${type}"  />

	<c:if test="${status.isLast()}" >
		</select>
		<input type="hidden" name="${type}_price" value="1.00" id="${type}_price">
		</td>
		</tr>
		</c:if>
</c:forEach>


<tr>
<td class="text-right">Size of pizza:</td>
<td>
<select name="size" class="form-control" size="1" id="size" onChange="change_price(this);">

<c:set var="pizzasize" scope="session" value="${pizza.getSize()}"/>
<c:forEach items="${pizzasizeshash}" var="size">
	<c:choose>
		<c:when test="${pizzasize == size.getMultiplier()}">
			<option value="${size.getLabel()}" data-price="${size.getMultiplier()}" selected>${size.getLabel()}</option>
		</c:when>
		<c:otherwise>
			<option value="${size.getLabel()}" data-price="${size.getMultiplier()}">${size.getLabel()}</option>
		</c:otherwise>
	</c:choose>
</c:forEach>

</select>
<input type="hidden" name="size_price" value="1.00" id="size_price">
</td>
</tr>

<tr>
<td class="text-right">Review your pizza:</td>
<td class="left">
<input type="submit" value="Review It!" class="btn btn-danger">
</td>
</tr>

</table>
</form>

</div>
</div>
</div>
<script>
$( document ).ready(function() {
	options = ['crust','sauce','cheese','topping','size'];
	for (i=0; i<options.length; i++) {
    	var price = $("#theform #"+options[i]+" option:selected").attr("data-price");
    	$("#theform #"+options[i]+"_price").val(price);
	}
});
</script>
</body>
</html>