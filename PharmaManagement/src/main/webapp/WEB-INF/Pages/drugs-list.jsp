<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Drugs here</title>
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<h2 style="text-align: center">Drugs</h2>
</head>
<body style="background-image:url(resources/images/1.jpg)">
<br><br>
	<div class="container"><form action="${pageContext.request.contextPath}/cart" method="post">
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>Buy?</th>
					<th>Drug Name</th>
					<th>Drug Description</th>
					<th>Drug Cost</th>
					<th>Drug Mfd Date</th>
					<th>Drug Expiry Date</th>
					<th>Update</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${drugs}" var="d">
					<tr>
						<td><input type="radio" name="drug" value="${d}"></td>
						<td>${d.dName}</td>
						<td>${d.dDesc}</td>
						<td>${d.dCost}</td>
						<td><fmt:formatDate value="${d.mfdDate}" pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${d.expDate}" pattern="dd-MM-yyyy" /></td>
						<td><a href="${pageContext.request.contextPath}/updateDrug/${d.dId}">Update ${d.dName}?</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		<label>Quantity</label><input class="input-group-text" type="text" name="qty"/><br>
		<button class="btn btn-dark">Buy</button></form>
	</div>

<script src=<c:url value="webjars/jquery/3.3.1/jquery.min.js"/>></script>
<script src=<c:url value="webjars/bootstrap/4.1.0/js/bootstrap.min.js"/>></script>
</body>
</html>