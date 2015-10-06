<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  		<div class="col-md-12">

			<h2 class="text-center">Here are the pizzas you ordered:</h2>

			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			  <div class="panel panel-default">
<c:choose>
	<c:when test="${not empty allpizzas}">
		<c:forEach items="${allpizzas}" var="pizza" varStatus = "status">
		<c:set var="pizzaval" scope="request" value="${pizza.value}"/>

				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="heading${status.count}">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${status.count}" aria-expanded="false" aria-controls="collapse${status.count}">
				          Pizza #${status.count}: <fmt:formatNumber value="${pizzaval.getTotalPrice()}" type="currency"/>&nbsp;&rarr;&nbsp;See details&nbsp|&nbsp;<a href="../options/?pizzaid=${pizza.key}">Change this pizza</a>&nbsp;|&nbsp;<a href="../delete/?pizzaid=${pizza.key}">Delete this pizza</a>
				        </a>
				      </h4>
				    </div>
				    <div id="collapse${status.count}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${status.count}">
				      <div class="panel-body">

						<table class="table table-striped table-bordered table-hover">
						
							<c:if test="${not empty pizzaval.getCrustType()}">
							<tr>
							<td class="text-right">Crust type:</td>
							<td>
							${pizzaval.getCrustType()}
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getCrustPrice()}" type="currency"/>
							</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty pizzaval.getSauceType()}">
							<tr>
							<td class="text-right">Sauce type:</td>
							<td>
							${pizzaval.getSauceType()}
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getSaucePrice()}" type="currency"/>
							</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty pizzaval.getCheeseType()}">
							<tr>
							<td class="text-right">Cheese type:</td>
							<td>
							${pizzaval.getCheeseType()}
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getCheesePrice()}" type="currency"/>
							</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty pizzaval.getToppingType()}">
							<tr>
							<td class="text-right">Topping type:</td>
							<td>
							${pizzaval.getToppingType()}
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getToppingPrice()}" type="currency"/>
							</td>
							</tr>
							</c:if>
						
							<c:if test="${not empty pizzaval.getSizeLabel()}">
							<tr>
							<td class="text-right">Size of pizza:</td>
							<td>
							${pizzaval.getSizeLabel()}
							</td>
							<td>
							X ${pizzaval.getSize()}
							</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty pizzaval.getCompleteType()}">
							<tr>
							<td class="text-right">Complete pizza:</td>
							<td>
							${pizzaval.getCompleteType()}
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getCompletePrice()}" type="currency"/>
							</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty pizzaval.getPizzaQuantity()}">
							<tr>
							<td class="text-right">&nbsp;</td>
							<td>
							Number of pizzas:
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getPizzaQuantity()}" type="number"/>
							</td>
							</tr>
							</c:if>
							
							<c:if test="${not empty pizzaval.getTotalPrice()}">
							<tr>
							<td class="text-right">&nbsp;</td>
							<td>
							Total price:
							</td>
							<td>
							<fmt:formatNumber value="${pizzaval.getTotalPrice()}" type="currency"/>
							</td>
							</tr>
							</c:if>
						</table>
					  </div>
					</div>
				  </div>
		</c:forEach>
	</c:when>
	<c:otherwise>
					<p class="text-center">You don't have any pizzas in your order</p>
	</c:otherwise>
</c:choose>

				</div>
			  </div>

			<table>
			
			<tr>
			<td class="text-left">
			<%
			Double grandtotal = (Double) request.getAttribute("grandtotal");
			%>
			<strong>Order total = <fmt:formatNumber value="${grandtotal}" type="currency"/></strong>
			<br><br>
			</td>
			<td >
			&nbsp;
			</td>
			<td>
			&nbsp;
			</td>
			</tr>
			
			<tr>
			<td class="text-left">
			<a href="../options/"><button type="button" class="btn btn-primary">Add a new pizza</button></a> or <a href="../payment/"><button type="button" class="btn btn-danger">Finish and Pay</button></a>
			</td>
			<td align="right">
			&nbsp;
			</td>
			<td>
			
			</td>
			</tr>
			
			</table>
		</div>
	</div>
</div>
</body>
</html>