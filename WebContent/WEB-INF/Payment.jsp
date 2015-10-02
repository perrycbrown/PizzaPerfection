<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jwad.pizzaperfection.domainmodel.PizzaImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pizza Options</title>
<script language="javascript" type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>

<h2>Here are the options you chose for your pizza:</h2>

<% PizzaImpl pizza = (PizzaImpl) request.getAttribute("pizza"); %>

<table class="center">

<tr>
<td>Crust:</td>
<td>
<%= pizza.getCrustType() %>
</td>
<td>
&#36;<%= String.format("%1$,.2f", pizza.getCrustPrice()) %>
</td>
</tr>

<tr>
<td>Sauce:</td>
<td>
<%= pizza.getSauceType() %>
</td>
<td>
&#36;<%= String.format("%1$,.2f", pizza.getSaucePrice()) %>
</td>
</tr>



</table>



</body>
</html>