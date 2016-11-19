<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>

	<c:forEach items="${users}" var="item">
    <br><a href="user/${item.getName()}">${item.getName()}</a>
	</c:forEach> <br>
	Fecha: ${fecha}
</body>
</html>