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
  <div class="card text-center">
  	<h5 class="card-header">Seleccione Cliente</h5>
  </div>
 
 <fieldset>
	<div class="d-flex" >	
		<div class="card col-sm-6" >
			<div class="card-body"  name = "Buscar" >
			<h5 class = "card-body text-center" >Buscar Cliente</h5>
			 <form id = "formularioBuscarCliente" >
				 <label> Nombre </label>
				 <input type="text" id = "info_cl" name="info_cl" class="form-control">				 
				 <input type="submit"  value = "Buscar"class="btn btn-info" onclick="validacionBuscarClientePedido()"/>
			 </form>
			<%
			List<Cliente> clienteBuscado =(List<Cliente>)request.getAttribute("clienteBuscado");
			pageContext.setAttribute("clienteBuscado",clienteBuscado);
			%>
				
			
			</div>
		</div>
		<div class="card col-sm-6" >
			<div class="card-body text-center"name = "Insertar">
				<h5 class = "card-body " >Nuevo Cliente</h5>
			 	<a type="submit" class="btn btn-info" href= "paginaClientes.do">Ingresar nuevo cliente</a>
			</div>
		</div>
	</div>
 </fieldset>
 <c:forEach var="cliente" items ="${clienteBuscado}">
			
				<c:out value="${cliente.getId_cl()}"></c:out>
				<c:out value="${cliente.getNom_cl()}"></c:out>
				<c:out value="${cliente.getApe_cl()}"></c:out>
				<c:out value="${cliente.getTel_cl()}"></c:out>
				<a class="btn btn-primary" href="datosNuevoPedido.do?id_cl=${cliente.getId_cl()}">Seleccionar</a>
			</c:forEach>
</body>
</html>