<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
<%@ include file="/WEB-INF/views/templates/include_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<br>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2 style="padding:0px; margin:0px;">VISTA USUARIO</h2>
					</div>
					<div class="panel-body">
						<label>username</label> ${user.name} <br>
						<label>password</label> ${user.password}<br>
						<label>type</label> ${user.type}
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-md-offset-3">
				<a href="<c:url value="/users"/>" class="btn btn-default btn-sm"><i class="fa fa-angle-double-left" aria-hidden="true"></i> Atrás</a>
			</div>
		</div>
	</div>
</body>
</html>