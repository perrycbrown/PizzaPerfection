<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

<c:forEach items="${allpizzas}" var="pizza" varStatus = "status">

<table class="table table-striped table-bordered table-hover">

	<c:if test="${pizza.getCrustType() != ''}">
	<tr>
	<td class="text-right">Crust type:</td>
	<td>
	${pizza.getCrustType()}
	</td>
	<td>
	&#36;${pizza.getCrustPrice()}
	</td>
	</tr>
	</c:if>
	
	<c:if test="${pizza.getSauceType() != ''}">
	<tr>
	<td class="text-right">Sauce type:</td>
	<td>
	${pizza.getSauceType()}
	</td>
	<td>
	&#36;${pizza.getSaucePrice()}
	</td>
	</tr>
	</c:if>

</table>

</c:forEach>

<table>

<tr>
<td>&nbsp;</td>
<td align="right">
Order total =
</td>
<td>
&#36;<%= request.getAttribute("total") %>
</td>
</tr>

<tr>
<td class="text-right">

<form action="../options/" method="post">
Go back and&nbsp;
<button type="submit" class="btn btn-primary">Change</button>
&nbsp;this pizza, or <a href="../options/"><button type="button" class="btn btn-primary">Add a new pizza</button></a>, or &rarr;
<input type="hidden" value="<%= request.getAttribute("pizzaid") %>" name="pizzaid">
</form>
</td>
<td align="right">
Finish and pay:
</td>
<td>
<a href="../payment/"><button type="button" class="btn btn-danger">Pay It!</button></a>
</td>
</tr>

</table>


</div>
</div>
</div>
</body>
</html>