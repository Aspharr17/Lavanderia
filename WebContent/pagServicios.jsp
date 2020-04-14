<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Clientes</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src ="js/val.js" type ="text/javascript"></script>
</head>
<body>
 <fieldset>
	<div class="d-flex" >	
		<div class="card col-sm-4" >
			<div class="card-body"name = "Insertar">
			<!-- action="insertarCliente.do" -->
			<h5 class = "card-body text-center" >Servicios</h5>
			 <form id = "formularioInsertarServicio" >
				 <div classs="form-group">
				 <label> Nombre </label>
				 <input type="text" id = "nom_ser" name="nom_ser" class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Costo </label>
				 <input type="text" id = "cost_ser" name="cost_ser" class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Medida </label>
				 <input type="text" name="med_ser" id = "med_ser" class="form-control">
				 </div>
				 <input type="submit"  class="btn btn-info" onclick="validacionInsertarServicios()"/>
			 </form>
			</div>
		</div>
		<div class="table">
		<%
		List<Servicio> listaServicios =(List<Servicio>)request.getAttribute("listaServicios");
		pageContext.setAttribute("listaServicios",listaServicios);
		%>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Servicio</th>
					<th>Costo</th>
					<th>Medida</th>
				</tr>
			</thead>
		<c:forEach var="servicio" items ="${listaServicios}">
		<tr>
		<td><c:out value="${servicio.getId_ser()}"></c:out></td>
		<td><c:out value="${servicio.getNom_ser()}"></c:out></td>
		<td><c:out value="${servicio.getCost_ser()}"></c:out></td>
		<td><c:out value="${servicio.getMed_ser()}"></c:out></td>
		<td><a class="btn btn-danger" href="eliminarServicio.do?id_ser=${servicio.getId_ser()}">Eliminar</a></td>
		<td><a class="btn btn-warning" href="paginaEditarServicio.do?id_ser=${servicio.getId_ser()}
				&nom_ser=${servicio.getNom_ser()}&cost_ser=${servicio.getCost_ser()}&med_ser=${servicio.getMed_ser()}">Editar</a></td>
			
		</tr>
		</c:forEach>	
				
		</table>
		</div>
	</div>
	
	
 </fieldset>
</body>
</html>