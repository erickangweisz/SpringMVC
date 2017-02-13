<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.springframework.util.StringUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>persist users</h1>
				<hr>
				<c:if test="${!empty userListForm.userList}">
					<form:form action="persistUsers" method="post" modelAttribute="userListForm">
						<c:forEach items="${userListForm.userList}" var="user" varStatus="i">
							<form:hidden path="userList[${i.index}].name"/> ${user.name}
							<form:hidden path="userList[${i.index}].password"/> ${user.password}
							<form:hidden path="userList[${i.index}].type"/> ${user.type}
						</c:forEach>
						<br>
						<button type="submit" value="Persistir"
							class="btn btn-success pull-left btn-sm">
							<i class="fa fa-check" aria-hidden="true"> Confirmar</i>
						</button>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
	
	
	<!-- include bootstrap -->
	<%@ include file="/WEB-INF/views/templates/include_bootstrap.jsp" %>
</body>
</html>