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

<h2 class="text-center">Here is the pizza you chose:</h2>
<form action="../payment/">

<table class="table table-striped table-bordered table-hover">

<% if (request.getParameterMap().containsKey("crust")) { %>
<tr>
<td>Crust type</td>
<td>
<%= request.getParameter("crust") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("crust_price")).replace(' ', '0') %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("sauce")) { %>
<tr>
<td>Sauce type</td>
<td>
<%= request.getParameter("sauce") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("sauce_price")).replace(' ', '0') %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("cheese")) { %>
<tr>
<td>Cheese type</td>
<td>
<%= request.getParameter("cheese") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("cheese_price")).replace(' ', '0') %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("topping")) { %>
<tr>
<td>Topping type</td>
<td>
<%= request.getParameter("topping") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("topping_price")).replace(' ', '0') %>
</td>
</tr>
<% } %>

<% if (request.getParameterMap().containsKey("size")) { %>
<tr>
<td>Size of pizza:</td>
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
<td>
<%= request.getParameter("complete") %>
</td>
<td>
&#36;<%= String.format("%-5s", request.getParameter("complete_price")).replace(' ', '0') %>
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
Go back and&nbsp;
<a href="../options/"><button type="button" class="btn btn-primary">Change</button></a>
&nbsp;your order, or &rarr;
</td>
<td align="right">
Finish and pay:
</td>
<td>
<a href="../payment/"><button type="button" class="btn btn-danger">Pay It!</button></a>
</td>
</tr>

</table>
</form>

</div>
</div>
</div>
</body>
</html>