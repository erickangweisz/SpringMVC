<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
	<%@ include file="/WEB-INF/views/include_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Añadir Usuario:</h1>
		<c:url var="addAction" value="/user/add"></c:url>
		<form:form action="${addAction}" commandName="user">
			<table>
				<tr>
					<td><form:label path="name">
							Nombre
						</form:label></td>
					<td><form:input path="name" class="form-control" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="password">
							Contraseña
						</form:label></td>
					<td><form:input path="password" class="form-control" required="true"/></td>
				</tr>
				<tr>
					<td><form:label path="type">
							Permiso
						</form:label></td>
					<td><form:select path="type">
							<form:option value="superadmin"> Superadmin</form:option>
							<form:option value="admin"> Admin</form:option>
							<form:option value="normal"> Normal</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${!empty user.name}">
						<input type="submit" value="Editar Usuario" />
						</c:if> <c:if test="${empty user.name}"><br>
							<input type="submit" class="btn btn-primary" value="Añadir Usuario" />
						</c:if>
					</td>
				</tr>
			</table>
		</form:form>
		<hr>
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
	
	
</body>
</html>