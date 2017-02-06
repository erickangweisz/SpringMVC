<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
<title>Home</title>
</head>
<body>
	<div class="container">
		<br>
		<div class="jumbotron">
			<h1>Home <small>${id_session}</small></h1>
		</div>
		<div class="row">
			<div class="col-md-6">
				<a href="users" class="btn btn-primary">Usuarios con Hibernate</a><br><br>
				<a href="xmlForm" class="btn btn-primary">Formulario XML</a><br>
			</div>
		</div>
	</div>
	
	<!-- include bootstrap -->
	<%@ include file="/WEB-INF/views/templates/include_bootstrap.jsp" %>
</body>
</html>
