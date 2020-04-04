<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register your Pharmacy</title>
<link href="webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/PharmaRegister.css">
<h2>Pharmacy Registration</h2>
</head>
<body style="background-image:url(resources/images/1.jpg)">
<div class="container">
<br>
	<form:form class="form-inline" id="pharmaReg" name="pharmaReg" modelAttribute="pharma" method="post" action="registerPharma">
	<div class="form-group">
	<br><br>
		<label class="form-check-label">Pharmacy Name</label><form:input class="form-control left" name="pName" path="pName" />
		<small><form:errors path="pName" cssClass="invalid"/></small>
		</div><br>
		<div class="form-group">
		<label class="form-check-label">Password</label><form:password class="form-control left" name="pPwd" path="pPwd"/>
		<small><form:errors path="pPwd" cssClass="invalid"/></small>
		</div><br>
		<div class="form-group">
		<label class="form-check-label">Address</label><form:textarea class="form-control left" name="pAddr" path="pAddr"/>
		<small><form:errors path="pAddr" cssClass="invalid"/></small>
		</div><br>
		<div class="form-group">
		<label class="form-check-label">EMail Address</label><form:input class="form-control left" name="pMail" path="pMail"/>
		<small><form:errors path="pMail" cssClass="invalid"/></small>
		</div><br>
		<div class="form-group">
		<label class="form-check-label">Contact</label><form:input class="form-control left" name="pMob" path="pMob"/>
		<small><form:errors path="pMob" cssClass="invalid"/></small>
		</div><br>
		<div class="form-group">
		<label class="form-check-label">Select Drugs Available</label><form:select class="form-control left" items="${drugList}" itemLabel="dName" itemValue="dName" multiple="true" path="pharmaDrugs"></form:select><br/><br>
		<small><form:errors path="pharmaDrugs" cssClass="invalid"/></small>
		</div><br>
		<button class="btn btn-success" type="submit" class="btn btn-primary">Register</button>
	</form:form><br>
	<div style="text-align: center">
	Already a member?<a href="${pageContext.request.contextPath}/login">&nbsp;Log In</a>
	</div> 
	</div>
	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</body>
</html>