<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XML Reader</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				${msg}
				<c:forEach items="${list}" var="item">
			    	<br>${item}
				</c:forEach> 
			</div>
		</div>
	</div>
	
	<!-- include bootstrap -->
	<%@ include file="/WEB-INF/views/templates/include_bootstrap.jsp" %> 
</body>
</html>