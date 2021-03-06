<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jwad.pizzaperfection.domainmodel.PizzaImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl" %>
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
  		<br/>
  		
<!--  tab navigation -->
<ul class="nav nav-pills" role="tablist">
<li role="presentation" class="<%= request.getAttribute("pizzaClass") %> bg-success"><a href="#buildapizza" aria-controls="home" role="tab" data-toggle="tab">Build-A-Pizza</a></li>
<li role="presentation" class="<%= request.getAttribute("completeClass") %> bg-success"><a href="#completepizzas" aria-controls="profile" role="tab" data-toggle="tab">Complete Pizzas</a></li>
<li role="presentation" class="<%= request.getAttribute("addonsClass") %> bg-success"><a href="#addons" aria-controls="profile" role="tab" data-toggle="tab">Drinks, Desserts, etc.</a></li>
<li role="presentation" class="bg-warning"><a href="../revieworder/" role="tab">Review Pizza Order</a></li>
</ul>
<!--  end tab navigation -->

<div class="tab-content">

<!--  start build-a-pizza tab -->
<div role="tabpanel" class="tab-pane fade <%= "in " + request.getAttribute("pizzaClass") %>" id="buildapizza">
<form action="../review/" method="post" id="theform">

<table class="table table-striped table-bordered table-hover">
<tr>
<td colspan="3" align="center">
<h2 class="text-center"><%= request.getAttribute("buildapizzaTitle") %></h2>
</td>
</tr>

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
			<c:when test="${label == pizza.getCrustType() || label == pizza.getSauceType() || label == pizza.getCheeseType() || pizza.getToppingType().contains(label)}">
				<option value="${element.getLabel()}" data-price="${element.getPrice()}" selected>${element.getLabel()} @ <fmt:formatNumber value="${element.getPrice()}" type="currency"/></option>
			</c:when>
			<c:otherwise>
				<option value="${element.getLabel()}" data-price="${element.getPrice()}">${element.getLabel()} @ <fmt:formatNumber value="${element.getPrice()}" type="currency"/></option>
			</c:otherwise>
		</c:choose>
	</c:if>

	<c:if test="${type != prevtype && prevtype != ''}">
		</select>
		<c:choose>
			<c:when test="${type == 'topping'}">
		<input type="hidden" name="${prevtype}_price" value="${pizza.getToppingPrice()}" id="${prevtype}_price">
			</c:when>
			<c:otherwise>
		<input type="hidden" name="${prevtype}_price" value="${element.getPrice()}" id="${prevtype}_price">			
			</c:otherwise>
		</c:choose>
		</td>
		</tr>
		<tr>
		<td class="text-right">Type of ${element.getType()}:</td>
		<td>
		<select name="${element.getType()}" class="form-control" id="${element.getType()}" onChange="change_price(this);" ${element.getType() == "topping" ? "multiple size='4'" : "size='1'"}>
		<c:choose>
			<c:when test="${label == pizza.getCrustType() || label == pizza.getSauceType() || label == pizza.getCheeseType() || pizza.getToppingType().contains(label)}">
				<option value="${element.getLabel()}" data-price="${element.getPrice()}" selected>${element.getLabel()} @ <fmt:formatNumber value="${element.getPrice()}" type="currency"/></option>
			</c:when>
			<c:otherwise>
				<option value="${element.getLabel()}" data-price="${element.getPrice()}">${element.getLabel()} @ <fmt:formatNumber value="${element.getPrice()}" type="currency"/></option>
			</c:otherwise>
		</c:choose>	</c:if>

	<c:set var="prevtype" value="${type}"  />
	<c:if test="${status.isLast()}" >
		</select>
		<c:choose>
			<c:when test="${type == 'topping'}">
		<input type="hidden" name="${prevtype}_price" value="${pizza.getToppingPrice()}" id="${prevtype}_price">
			</c:when>
			<c:otherwise>
		<input type="hidden" name="${prevtype}_price" value="${element.getPrice()}" id="${prevtype}_price">			
			</c:otherwise>
		</c:choose>
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
			<option value="${size.getLabel()}" data-price="${size.getMultiplier()}" selected>${size.getLabel()} (pizza ingrediants X ${size.getMultiplier()})</option>
		</c:when>
		<c:otherwise>
			<option value="${size.getLabel()}" data-price="${size.getMultiplier()}">${size.getLabel()} (all pizza ingrediants X ${size.getMultiplier()})</option>
		</c:otherwise>
	</c:choose>
</c:forEach>

</select>
<input type="hidden" name="size_price" value="1.00" id="size_price">
</td>
</tr>

<tr>
<td class="text-right">Number of pizzas:</td>
<td>
<select name="quantity" class="form-control" size="1" id="quantity">
<c:set var="pizzaquantity" scope="session" value="${pizza.getPizzaQuantity()}"/>
<c:forEach var="i" begin="1" end="10">
	<c:choose>
		<c:when test="${pizzaquantity == i}">
			<option value="${i}" selected>${i}</option>
		</c:when>
		<c:otherwise>
			<option value="${i}" >${i}</option>
		</c:otherwise>
	</c:choose>
</c:forEach>

</select>
<!--  <input type="hidden" name="size_price" value="1.00" id="size_price"> -->
</td>
</tr>

<tr>
<td class="text-right">Add and review your pizza:</td>
<td class="left">
<input type="hidden" value="<%= request.getAttribute("pizzaid") %>" name="pizzaid">
<input type="submit" value="Go!" class="btn btn-danger">
</td>
</tr>

</table>
</form>
</div>
<!--  end build-a-pizza tab -->

<!--  start complete pizzas tab -->
<div role="tabpanel" class="tab-pane fade <%= "in " + request.getAttribute("completeClass") %>" id="completepizzas">
<form action="../review/" method="post" id="thecompleteform">

<table class="table table-striped table-bordered table-hover">
<tr>
<td colspan="3" align="center">
<h2 class="text-center"><%= request.getAttribute("completepizzaTitle") %></h2>
</td>
</tr>

<tr>
<td class="text-right">Type of complete pizza:</td>
<td class="left">
<select name="complete" class="form-control" size="1" id="complete" onChange="change_price(this);">
<c:forEach items="${pizzacomplete}" var="complete" varStatus = "status">

<c:choose>
	<c:when test="${complete.getLabel() == pizza.getCompleteType()}">
		<option value="${complete.getLabel()}" data-price="${complete.getPrice()}" selected>${complete.getLabel()} @ <fmt:formatNumber value="${complete.getPrice()}" type="currency"/></option>
	</c:when>
	<c:otherwise>
		<option value="${complete.getLabel()}" data-price="${complete.getPrice()}">${complete.getLabel()} @ <fmt:formatNumber value="${complete.getPrice()}" type="currency"/></option>
	</c:otherwise>
</c:choose>

</c:forEach>
</select>
<input type="hidden" name="complete_price" value="1.00" id="complete_price">
</td>
</tr>

<tr>
<td class="text-right">Number of pizzas:</td>
<td>
<select name="quantity" class="form-control" size="1" id="quantity">
<c:set var="pizzaquantity" scope="session" value="${pizza.getPizzaQuantity()}"/>
<c:forEach var="i" begin="1" end="10">
	<c:choose>
		<c:when test="${pizzaquantity == i}">
			<option value="${i}" selected>${i}</option>
		</c:when>
		<c:otherwise>
			<option value="${i}" >${i}</option>
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
<input type="hidden" value="<%= request.getAttribute("pizzaid") %>" name="pizzaid">
<input type="submit" value="Review It!" class="btn btn-danger">
</td>
</tr>
</table>
</form>
</table>

</div>
<!--  end complete pizzas tab -->

<!--  start addons tab -->
<div role="tabpanel" class="tab-pane fade <%= "in " + request.getAttribute("addonsClass") %>" id="addons">
<form action="../reviewaddons/" method="post" id="theaddonsform">

<table class="table table-striped table-bordered table-hover">
<tr>
<td colspan="3" align="center">
<h2 class="text-center"><%= request.getAttribute("addonsTitle") %></h2>
</td>
</tr>

<c:forEach items="${pizzaaddons}" var="addon" varStatus = "status">
<c:set var="type" value="${addon.getType_label()}"  />
<c:set var="id" value="${addon.getId()}"  />

<c:if test="${type != prevtype || prevtype == ''}">
<tr>
<td class="text-right"><strong>${addon.getType_label()}</strong></td>
<td class="left">
<strong>Price</strong>
</td>
<td>
<strong>Quantity</strong>
</td>
</tr>
</c:if>


<tr>
<td class="text-right">${addon.getLabel()}</td>
<td class="left">
<c:choose>
<c:when test="${requestedaddonsids.containsKey(id)}">
	<input type="checkbox" name="addons" value="${addon.getId()}" id="${addon.getId()}_checkbox" checked onclick="select_quantity(this)">
</c:when>
<c:otherwise>
	<input type="checkbox" name="addons" value="${addon.getId()}" id="${addon.getId()}_checkbox" onclick="select_quantity(this)">
</c:otherwise>
</c:choose>
&nbsp;<fmt:formatNumber value="${addon.getPrice()}" type="currency"/>&nbsp;ea.
</td>
<td>
<select name="${addon.getId()}_quantity" class="form-control" size="1" id="${addon.getId()}_quantity" onchange="set_checkbox(this)">
<option value="">Select one:</option>
<c:set var="addonquantity" scope="application" value="${requestedaddonsids.get(addon.getId())}"/>
<c:forEach var="i" begin="1" end="10">
	<c:choose>
		<c:when test="${addonquantity == i}">
			<option value="${i}" selected>${i}</option>
		</c:when>
		<c:otherwise>
			<option value="${i}" >${i}</option>
		</c:otherwise>
	</c:choose>
</c:forEach>

</select>
</td>
</tr>

<c:set var="prevtype" value="${addon.getType_label()}"  />
</c:forEach>

<tr>
<td class="text-right">Review these extras:</td>
<td class="left" colspan="2">
<input type="hidden" value="<%= request.getAttribute("addonsid") %>" name="addsonid">
<input type="submit" value="Review It!" class="btn btn-danger">
</td>
</tr>
</table>
</form>

</div>
<!--  end addons tab -->
</div>

</div>
</div>
</div>
<script>
$( document ).ready(function() {
	options = ['crust','sauce','cheese','size'];
	for (i=0; i<options.length; i++) {
    	var price = $("#theform #"+options[i]+" option:selected").attr("data-price");
    	$("#theform #"+options[i]+"_price").val(price);
	}
	var completeprice = $("#thecompleteform #complete option:selected").attr("data-price");
	$("#thecompleteform #complete_price").val(completeprice);
});
</script>
</body>
</html>