<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:forEach items="${p_single}" var="p1">
<title>${p1.pName}</title>
<h2>${p1.pName}</h2>
</c:forEach>
<link href="<c:url value="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/pharmacy-one.css"/>">
</head>
<body style="background-image:url(resources/images/1.jpg)">
	<div class="container">
	<br>
		<table class="table table-hover">
			
			<thead class="thead-light">
				<tr>
					<th>Pharmacy Name</th>
					<th>Pharmacy Address</th>
					<th>Pharmacy Mail</th>
					<th>Pharmacy Contact</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${p_single}" var="pharmacy">
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
	<br>
	<c:forEach items="${p_single}" var="p">
	<div id="view"><a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/viewDrugs">View drugs</a></div><br><br></c:forEach>
	<div class="topleftcorner"><a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/viewPharmacies">View all our pharmacies</a></div><br><br>
	<div class="toprightcorner"><a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/login">Logout</a></div>
	<div class="search">
	<form:form action="${pageContext.request.contextPath}/searchRes" modelAttribute="drug" method="post">
		<div class="form-group col-md-2">
		<form:input type="text" class="form-control" path="dName"/>
		</div>
		<button class="btn btn-success btn-sm">Search drug</button>
	</form:form>
	</div>
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>