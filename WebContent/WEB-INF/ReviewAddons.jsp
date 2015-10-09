<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h2 class="text-center">These extras have been added to your order:</h2>

<table class="table table-striped table-bordered table-hover">

<c:forEach items="${pizzaaddons}" var="addon" varStatus = "status">
<c:set var="type" value="${addon.getType_label()}"  />

<c:if test="${type != prevtype || prevtype == ''}">
<tr>
<td class="text-right"><strong>${addon.getType_label()}</strong></td>
<td class="left">&nbsp;
</td>
<td class="left">&nbsp;
</td>
</tr>
</c:if>

<tr>
<td class="left">&nbsp;
</td>
<td class="text-right">${addon.getLabel()}</td>
<td class="left">
<fmt:formatNumber value="${addon.getPrice()}" type="currency"/>
</td>
</tr>
<c:set var="prevtype" value="${addon.getType_label()}"  />
</c:forEach>

<tr>
<td>&nbsp;</td>
<td align="right">
<strong>Extras total =</strong>
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
&nbsp;these addons, or <a href="../options/"><button type="button" class="btn btn-primary">Add a new pizza</button></a>, or &rarr;
<input type="hidden" value="<%= request.getAttribute("addonsid") %>" name="addonsid">
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