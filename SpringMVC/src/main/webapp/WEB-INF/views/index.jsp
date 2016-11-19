<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>Home</h1>
		<br>
		<div class="row">
			<div class="col-md-6">
				<a href="users">Usuarios con Hibernate</a><br>
				<a href="provincias">Provincias con Hibernate</a>
			</div>
		</div>
	</div>
	
	<!-- include bootstrap -->
	<%@ include file="/WEB-INF/views/include_bootstrap.jsp" %>
</body>
</html>
