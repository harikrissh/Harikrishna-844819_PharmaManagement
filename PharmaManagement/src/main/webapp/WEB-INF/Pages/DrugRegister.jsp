<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Drug to your Pharmacy</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/PharmaRegister.css" rel="stylesheet" >
<h2>Add Drug</h2>
</head>
<body>
<div class="container">
<form:form id="drugReg" name="drugReg" modelAttribute="drug" method="post" action="registerDrug">
		<label>Drug Name<sup>*</sup></label><form:input class="left" name="dName" path="dName" /><br>
		<label>Description<sup>*</sup></label><form:textarea class="left" name="dDesc" path="dDesc"/><br>
		<label>Mfd Date<sup>*</sup></label><form:input class="left" type="date" name="mfdDate" path="mfdDate"/><br>
		<label>Expiry Date<sup>*</sup></label><form:input class="left" type="date" name="expDate" path="expDate"/><br>
		<label>Cost<sup>*</sup></label><form:input class="left" name="dCost" path="dCost"/><br>
		<button type="submit" class="btn btn-primary">Add Drug</button>
	</form:form><br>
	<a class="btn btn-info" href="${pageContext.request.contextPath}/viewPharmacies">View all our pharmacies</a>
	</div>
	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>