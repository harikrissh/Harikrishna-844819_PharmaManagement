<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<title>Invoice</title>
<h2 style="text-align:center">Invoice</h2>
</head>
<body style="background-image:url(resources/images/1.jpg)">

<div class="container">
<br>
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>Drug Name</th>
					<th>Drug Description</th>
					<th>Drug Cost</th>
					<th>Drug Mfd Date</th>
					<th>Drug Expiry Date</th>
					<th>Quantity</th>
					<th class="table-success">Total Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${set}" var="d">
					<tr>
						<td>${d.dName}</td>
						<td>${d.dDesc}</td>
						<td>${d.dCost}</td>
						<td><fmt:formatDate value="${d.mfdDate}" pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${d.expDate}" pattern="dd-MM-yyyy" /></td>
						<td>${qty}</td>
						<td class="table-success">${qty*d.dCost}</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			</div>
			<div class="buttons">
				<a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/viewDrugs">Go Back</a>
			</div>
</body>
</html>