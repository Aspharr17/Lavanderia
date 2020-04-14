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
			<h5 class = "card-body text-center" >Guardar Cliente</h5>
			 <form id = "formularioInsertarCliente" >
				 <div classs="form-group">
				 <label> Nombre </label>
				 <input type="text" id = "nom_cl" name="nom_cl" class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Apellido </label>
				 <input type="text" id = "ape_cl" name="ape_cl" class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Telefono </label>
				 <input type="text" name="tel_cl" id = "tel_cl" class="form-control">
				 </div>
				 <input type="submit"  class="btn btn-info" onclick="validacionIngresarCliente()"/>
			 </form>
			</div>
		</div>
		<div class="table">
		<%
		List<Cliente> listaClientes =(List<Cliente>)request.getAttribute("listaClientes");
		pageContext.setAttribute("listaClientes",listaClientes);
		%>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Telefonos</th>
				</tr>
			</thead>
		<c:forEach var="cliente" items ="${listaClientes}">
		<tr>
		<td><c:out value="${cliente.getId_cl()}"></c:out></td>
		<td><c:out value="${cliente.getNom_cl()}"></c:out></td>
		<td><c:out value="${cliente.getApe_cl()}"></c:out></td>
		<td><c:out value="${cliente.getTel_cl()}"></c:out></td>
		<td><a class="btn btn-danger" href="eliminarCliente.do?id_cl=${cliente.getId_cl()}">Eliminar</a></td>
		<td><a class="btn btn-warning" href="paginaeditarCliente.do?id_cl=${cliente.getId_cl()}
				&nom_cl=${cliente.getNom_cl()}&ape_cl=${cliente.getApe_cl()}&tel_cl=${cliente.getTel_cl()}">Editar</a></td>
			
		</tr>
		</c:forEach>	
				
		</table>
		</div>
	</div>
	
	
 </fieldset>
</body>
</html>