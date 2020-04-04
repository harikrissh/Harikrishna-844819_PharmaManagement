<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Pharmacy Management</title>
<link href="<c:url value="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
<a href="${pageContext.request.contextPath}/login"><img id="logo" src="<c:url value="resources/images/medicine.png"/>"></a><h2>Pharmacy Login</h2>
</head>
<body style="background-image:url(resources/images/1.jpg)"> 
<br><br>
	<div class="container">
		<form:form class="loginForm" name="loginForm" modelAttribute="pharmacy" method="post" action="login">
		
		<div class="form-group col-md-11">
		 <label id="name">Pharmacy Name</label><form:input class="form-control" path="pName" /><br>
		 </div>
		 <div class="form-group col-md-11">
		 <label id="pwd">Password</label><form:password class="form-control" path="pPwd" />
		 </div>
		 <small style="color: red;"><c:if test="${not empty result}">${result}</c:if></small><br><br>
		 <button type="submit" class="btn btn-primary">Log In</button><br><br><br>
		<div class="link"><a href="${pageContext.request.contextPath}/AddPharmacy">New Pharmacy? Register here</a></div>
		</form:form>
	</div>
</body>
<footer class="footer">
      <div class="container">
        <span class="text-muted">&copy; Pharmacy Management</span>
      </div>
</footer>
</html>