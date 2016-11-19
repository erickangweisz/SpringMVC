<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Provincias</title>
</head>
<body>
	<div class="container">
		<h1>Añadir Provincia:</h1>
		<c:url var="addAction" value="/provincia/add"></c:url>
		<form:form action="${addAction}" commandName="provincia">
			<table>
				<tr>
					<td><form:label path="codigo">
							Código
						</form:label></td>
					<td><form:input path="codigo" class="form-control"/></td>
				</tr>
				<tr>
					<td><form:label path="descripcion">
							Descripcion
						</form:label></td>
					<td><form:input path="descripcion" class="form-control"/></td>
				</tr>
				<tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty provincia.codigo}">
							<input type="submit" value="Editar Provincia" />
						</c:if> 
						<c:if test="${empty provincia.codigo}"><br>
							<input type="submit" class="btn btn-primary" value="Añadir Provincia" />
						</c:if>
					</td>
				</tr>
			</table>
		</form:form>
		<hr>
		<h3>Lista de Provincias</h3>
		<c:if test="${!empty provinciaList}">
			<table class="table">
				<tr>
					<th>Código</th>
					<th>Descripción</th>
					<th colspan="2">Acción</th>
					<th></th>
				</tr>
				<c:forEach items="${provinciaList}" var="provincia">
					<tr>
						<td>${provincia.codigo}</td>
						<td>${provincia.descripcion}</td>
						<td><a href="removeprovincia/${provincia.codigo}" class="btn btn-danger">Borrar</a></td>
						<td><a href="editprovincia/${provincia.codigo}" class="btn btn-info">Editar</a></td>
						<td><a href="viewprovincia/${provincia.codigo}" class="btn btn-primary">Ver</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<!-- include bootstrap -->
	<%@ include file="/WEB-INF/views/include_bootstrap.jsp" %>
</body>
</html>