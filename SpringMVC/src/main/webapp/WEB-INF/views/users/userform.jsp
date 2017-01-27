<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
			<br>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h1 style="margin:0px; padding:0px;">A�adir Usuario:</h1>
					</div>
					<div class="panel-body">
						<c:url var="addAction" value="/user/add"></c:url>
						<form:form action="${addAction}" commandName="user">
							<table class="table table-hover">
								<tr>
									<td><form:label path="name">Nombre</form:label></td>
									<td><form:input path="name" class="form-control" required="true"/></td>
								</tr>
								<tr>
									<td><form:label path="password">Contrase�a</form:label></td>
									<td><form:input path="password" class="form-control" required="true"/></td>
								</tr>
								<tr>
									<td><form:label path="type">Permiso</form:label></td>
									<td>
										<form:select path="type" class="form-control">
											<form:option value="superadmin"> Superadmin</form:option>
											<form:option value="admin"> Admin</form:option>
											<form:option value="normal"> Normal</form:option>
										</form:select>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<c:if test="${!empty user.name}"><br>
											<input type="submit" class="btn btn-success form-control" value="Editar Usuario" />
										</c:if> 
										<c:if test="${empty user.name}"><br>
											<input type="submit" class="btn btn-success form-control" value="A�adir Usuario" />
										</c:if>
									</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>