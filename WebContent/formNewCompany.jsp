<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/newCompany" var="fullLinkNewCompany" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create Company</title>
</head>
<body>
	<form action="${fullLinkNewCompany}" method="post">
		Name        : <input type="text" name="name">
		Opening Date: <input type="date" name="openingDate">
					  <input type="submit" value="Send">
	</form>
</body>
</html>