<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>" rel="stylesheet">

<title>Search</title>
</head>
<body>
<table class="table table-hover">
			
			<thead class="thead-light">
				<tr>
					<th>Drug Name</th>
					<th>Drug Description</th>
					<th>Drug Cost</th>
					<th>Drug Mfd Date</th>
					<th>Drug Expiry Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${drugres}" var="d">
					<tr>
						<td>${d.dName}</td>
						<td>${d.dDesc}</td>
						<td>${d.dCost}</td>
						<td><fmt:formatDate value="${d.mfdDate}" pattern="dd-MMM-yyyy" /></td>
						<td><fmt:formatDate value="${d.expDate}" pattern="dd-MMM-yyyy" /></td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
</body>
</html>