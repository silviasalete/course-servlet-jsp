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
	
	Welcome ${user.login}
	
	<br><br><br>
	
	<c:if test="${not empty nameCompany}">
		Company ${nameCompany} created !
	</c:if>

	<c:if test="${empty nameCompany}">
		No company created !
	</c:if>
	
	<ul>
		<c:forEach items="${listCompanies}" var="listCompanies">
			<li>
				${listCompanies.name} - <fmt:formatDate value="${listCompanies.openingDate}" pattern="dd/MM/yyyy"/>
				<a href="/manager/mainServlet?action=ShowCompanies&id=${listCompanies.id}">edit</a> - 
				<a href="/manager/mainServlet?action=RemoveCompanies&id=${listCompanies.id}">remover</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>