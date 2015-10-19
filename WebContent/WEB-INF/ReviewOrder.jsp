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

	<c:if test="${not empty allpizzas}">
		<c:forEach items="${allpizzas}" var="pizza" varStatus = "status">
		<c:set var="pizzaval" scope="request" value="${pizza.value}"/>

				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="heading${status.count}">
				      <h4 class="panel-title">
				          
				        Pizza #${status.count}: <fmt:formatNumber value="${pizzaval.getTotalPrice()}" type="currency"/>&nbsp;&rarr;&nbsp;
				        <a class="btn btn-success" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${status.count}" aria-expanded="false" aria-controls="collapse${status.count}">See details</a>&nbsp&nbsp;
				        <a href="../options/?pizzaid=${pizza.key}" class="btn btn-warning btn-sm">Change this pizza</a>&nbsp;&nbsp;
				        <a href="../delete/?pizzaid=${pizza.key}" class="btn btn-warning btn-sm">Delete this pizza</a>
				        
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
	</c:if>
	<c:if test="${not empty alladdons}">

	  <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="addons">
	      <h4 class="panel-title">
	          Extras: <fmt:formatNumber value="<%= request.getAttribute(\"grandTotalAddons\") %>" type="currency"/>&nbsp;&rarr;&nbsp;
	          <a class="btn btn-success" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseaddon${status.count}" aria-expanded="false" aria-controls="collapseaddon${status.count}">See details</a>&nbsp&nbsp;
	          <a href="../options/?addonsid=<%= session.getAttribute("addonsid") %>" class="btn btn-warning btn-sm">Change these extras</a>&nbsp;&nbsp;<a href="../delete/?addonsid=<%= session.getAttribute("addonsid") %>" class="btn btn-warning btn-sm">Delete these extras</a>
	        </a>
	      </h4>
	    </div>
	    <div id="collapseaddon" class="panel-collapse collapse" role="tabpanel" aria-labelledby="addons">
	      <div class="panel-body">

			<table class="table table-striped table-bordered table-hover">
			<c:forEach items="${alladdons}" var="addon" varStatus = "status">
			
				<c:if test="${not empty addon.getLabel()}">
				<tr>
				<td class="text-right">${addon.getType_label()}</td>
				<td>
				${addon.getLabel()}
				</td>
				<td>
				<fmt:formatNumber value="${addon.getPrice()}" type="currency"/>&nbsp;ea.&nbsp;X&nbsp;${addon.getQuantity()}&nbsp;=&nbsp;<fmt:formatNumber value="${addon.getTotal()}" type="currency"/>
				</td>
				</tr>
				</c:if>

			</c:forEach>
			
				<tr>
				<td class="text-right">&nbsp;</td>
				<td>
				Total price:
				</td>
				<td>
				<fmt:formatNumber value="<%= request.getAttribute(\"grandTotalAddons\") %>" type="currency"/>
				</td>
				</tr>
			</table>
		  </div>
		</div>
	  </div>

	</c:if>
	<c:if test="${empty alladdons && empty allpizzas}">
					<p class="text-center"><strong>You don't have anything in your order</strong></p>
	</c:if>


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
			<a href="../options/"><button type="button" class="btn btn-primary">Add a new item</button></a> or <a href="../payment/"><button type="button" class="btn btn-danger">Finish and Pay</button></a>
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