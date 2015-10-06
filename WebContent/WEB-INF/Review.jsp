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

<h2 class="text-center">This pizza has been added to your order:</h2>

<table class="table table-striped table-bordered table-hover">

<% if (request.getParameterMap().containsKey("crust")) { %>
<tr>
<td class="text-right">Crust type:</td>
<td>
<%= request.getParameter("crust") %>
</td>
<td>
&#36;<%= request.getParameter("crust_price") %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("sauce")) { %>
<tr>
<td class="text-right">Sauce type:</td>
<td>
<%= request.getParameter("sauce") %>
</td>
<td>
&#36;<%= request.getParameter("sauce_price") %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("cheese")) { %>
<tr>
<td class="text-right">Cheese type:</td>
<td>
<%= request.getParameter("cheese") %>
</td>
<td>
&#36;<%= request.getParameter("cheese_price") %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("topping")) { %>
<tr>
<td class="text-right">Topping type:</td>
<td>
<%= request.getParameter("topping") %>
</td>
<td>
&#36;<%= request.getParameter("topping_price") %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("size")) { %>
<tr>
<td class="text-right">Size of pizza:</td>
<td>
<%= request.getParameter("size") %>
</td>
<td>
X <%= request.getParameter("size_price") %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("complete")) { %>
<tr>
<td class="text-right">Type of pizza:</td>
<td class="text-right">
<%= request.getParameter("complete") %>
</td>
<td>
&#36;<%= request.getParameter("complete_price") %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("quantity")) { %>
<tr>
<td>&nbsp;</td>
<td class="text-right">
Number of pizzas:
</td>
<td>
<%= request.getParameter("quantity") %>
</td>
</tr>
<% } %>

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
Review your complete order:
</td>
<td>
<a href="../revieworder/"><button type="button" class="btn btn-danger">Review Order</button></a>
</td>
</tr>

</table>


</div>
</div>
</div>
</body>
</html>