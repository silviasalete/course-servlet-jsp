<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/mainServlet" var="linkInputServlet"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkInputServlet}">
		Login:    <input type="text" name="login"/>
		Password: <input type="password" name="password"/>
		
		<input type="hidden" name="action" value="Login">
		<input type="submit" value="Send"/>
	</form>
</body>
</html>