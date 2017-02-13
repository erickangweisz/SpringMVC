<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				Cargar fichero para leer: <br>
				<form:form action="xmlReader"  method="post" enctype="multipart/form-data">
					<input type="file" name="xmlFile"/>
					<input type="submit" value="Ver contenido" class="btn btn-success btn-xs">
				</form:form>
				<br>
				Cargar users.xml para persistir en bd: <br>
				<form:form action="xmlReaderUsers"  method="post" enctype="multipart/form-data">
					<input type="file" name="xmlUserFile"/>
					<input type="submit" value="Ver contenido" class="btn btn-success btn-xs">
				</form:form>
				<br>
				Introducir url para cargar: <br>
				<form action="xmlReaderWebService" method="post">
					<input type="text" name="xmlURL"/><br>
					<input type="submit" value="Ver contenido" class="btn btn-success btn-xs">
				</form>
			</div>
		</div>
	</div>
	
	<!-- include bootstrap -->
	<%@ include file="/WEB-INF/views/templates/include_bootstrap.jsp" %>
</body>
</html>