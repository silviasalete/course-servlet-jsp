<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.manager.model.bean.Company" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html  >
<html>
<head>
<meta http-equiv="Content-Type"  >
<title>Lista Empresas</title>
</head>
<body>

<ul>
	<c:forEach items="${listCompanies}" var="company">
		<li>${company.name} - <fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/></li>
	</c:forEach>
</ul>
</body>
</html>