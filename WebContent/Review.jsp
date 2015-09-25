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
  		<div class="col-md-12">

<h2 class="text-center">Here is the pizza you chose:</h2>
<form action="../payment/">

<table class="table table-striped table-bordered table-hover">

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
&#36;<%= String.format("%-4s", request.getParameter("sauce_price")).replace(' ', '0') %>
</td>
</tr>

<tr>
<td>Cheese type</td>
<td>
<%= request.getParameter("cheese") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("cheese_price")).replace(' ', '0') %>
</td>
</tr>

<tr>
<td>Topping type</td>
<td>
<%= request.getParameter("topping") %>
</td>
<td>
&#36;<%= String.format("%-4s", request.getParameter("topping_price")).replace(' ', '0') %>
</td>
</tr>

<tr>
<td>Size of pizza:</td>
<td>
<%= request.getParameter("size") %>
</td>
<td>
X <%= request.getParameter("size_price") %>
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
<input type="submit" value="Pay It!" class="btn btn-danger">
</form>
</td>

<td>
&nbsp;
</td>
</tr>

</table>
</form>

</div>
</div>
</div>
</body>
</html>