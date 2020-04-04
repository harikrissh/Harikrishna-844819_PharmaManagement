<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Pharmacies here</title>
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<h2 style="text-align: center; margin-top: 20px;">Our Pharmacies</h2>
</head>
<body style="background-image:url(resources/images/1.jpg)">
	<div class="container">
	<br>
		<table class="table table-hover">
			
			<thead class="thead-dark">
				<tr>
					<th>Pharmacy Name</th>
					<th>Pharmacy Address</th>
					<th>Pharmacy Mail</th>
					<th>Pharmacy Contact</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${p}" var="pharmacy">
					<tr>
						<td><a href="${pageContext.request.contextPath}/viewPharmacy/${pharmacy.pName}">${pharmacy.pName}</a></td>
						<td>${pharmacy.pAddr}</td>
						<td>${pharmacy.pMail}</td>
						<td>${pharmacy.pMob}</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>