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
<link href="<c:url value="/webjars/datatables/1.10.11/media/css/dataTables.bootstrap.min.css"/> rel="stylesheet"/>
<script src="<c:url value="/webjars/datatables/1.10.11/media/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/webjars/datatables/1.10.11/media/js/dataTables.bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="container">
		<!-- modal delete confirm -->
		<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                ...
		            </div>
		            <div class="modal-body">
		                ...
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
		                <a class="btn btn-danger btn-ok">Delete</a>
		            </div>
		        </div>
		    </div>
		</div>
	
		<br>
		<div class="row">
			<div class="col-md-12">
				<a href="<c:url value="/"/>" class="btn btn-default btn-sm"><i class="fa fa-angle-double-left" aria-hidden="true"></i> Atrás</a>
				<a href="<c:url value="/newuser"/>" class="btn btn-info btn-sm"><i class="fa fa-plus-circle" aria-hidden="true"></i> crear usuario</a>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<h3>Lista de Usuarios</h3>
				<hr>
				<c:if test="${!empty userList}">
					<table class="table table-striped table-hover" id="mydata">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Contraseña</th>
								<th>Permiso</th>
								<th>Borrar</th>
								<th>Editar</th>
								<th>Ver</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.name}</td>
									<td>${user.password}</td>
									<td>${user.type}</td>
									<td><a href="remove/${user.name}" class="btn btn-danger btn-sm"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
									<td><a href="edit/${user.name}" class="btn btn-info btn-sm"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
									<td><a href="viewuser/${user.name}" class="btn btn-primary btn-sm"><i class="fa fa-eye" aria-hidden="true"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		
	</div>
	<!-- datatables -->
	<script>
		$('#mydata')
				.dataTable(
						{
							columnDefs : [ {
								orderable : false
							} ],
							language : {
								processing : "Tratamiento en curso...",
								search : "Buscar ",
								lengthMenu : "Mostrar _MENU_ elementos",
								info : "Mostrando <strong>_START_</strong> a <strong>_END_</strong> registros de <strong>_TOTAL_</strong> totales",
								infoPostFix : "",
								loadingRecords : "Cargando tabla...",
								zeroRecords : "No existeSn elementos a mostrar",
								emptyTable : "No existen elementos a mostrar",
								paginate : {
									first : "Primera",
									previous : "Anterior",
									next : "Siguiente",
									last : "Última"
								}
							}
						});
	</script>
</body>
</html>