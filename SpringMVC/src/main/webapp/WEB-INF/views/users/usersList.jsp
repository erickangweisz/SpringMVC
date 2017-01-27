<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<%@ include file="/WEB-INF/views/templates/include_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-12">
				<a href="<c:url value="/newuser"/>" class="btn btn-success">crear usuario</a>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<h3>Lista de Usuarios</h3>
				<c:if test="${!empty userList}">
					<table class="table">
						<tr>
							<th>Nombre</th>
							<th>Contraseña</th>
							<th>Permiso</th>
							<th colspan="3">Acción</th>
						</tr>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td>${user.name}</td>
								<td>${user.password}</td>
								<td>${user.type}</td>
								<td><a href="remove/${user.name}" class="btn btn-danger">Borrar</a></td>
								<td><a href="edit/${user.name}" class="btn btn-info">Editar</a></td>
								<td><a href="viewuser/${user.name}" class="btn btn-primary">Ver</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<a href="<c:url value="/"/>" class="btn btn-default">Atrás</a>
			</div>
		</div>
	</div>
</body>
</html>