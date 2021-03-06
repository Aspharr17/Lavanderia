<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lavanderia Lavamas</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src ="js/val.js" type ="text/javascript"></script>
</head>
<body>
<%
Pedido pedido =(Pedido)request.getAttribute("pedido");
pageContext.setAttribute("pedido",pedido);


Cliente clientePedido  = (Cliente)request.getAttribute("clientePedido"); 
pageContext.setAttribute("clientePedido",clientePedido);

List<Servicio> listaServicios = (List<Servicio>)request.getAttribute("listaServicios");
pageContext.setAttribute("listaServicios",listaServicios);

List<detallePedido> listaDetallesDePedido = (List<detallePedido>)request.getAttribute("listaDetallesDePedido");
pageContext.setAttribute("listaDetallesDePedido",listaDetallesDePedido);
%>
				
			
<div class="row">

  <div class="col-sm-8">
  <div class="card-body">
        <h5 class="card-title">Datos del cliente</h5>
        <a class="card-text"><c:out value="${clientePedido.getNom_cl()} ${clientePedido.getApe_cl()}"></c:out></a>
        <a class="card-text"><c:out value="${clientePedido.getTel_cl()}"></c:out></a>
      </div>
   <h5 class="card-title"># Pedido: <c:out value = "${pedido.getId_ped()}"></c:out></h5>
   	<div class="table">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Servicio</th>
					<th>Cantitad</th>
					<th>Precio</th>
					<th>Medida</th>
					<th>Total</th>
				</tr>
			</thead>
			<c:forEach var="detalles" items ="${listaDetallesDePedido}">
				<tr>
				<td><c:out value="${detalles.getServicio().getNom_ser()}"></c:out></td>
				<td><c:out value="${detalles.getCant_dped()}"></c:out></td>
				<td><c:out value="${detalles.getServicio().getCost_ser() }"></c:out></td>
				<td><c:out value="${detalles.getServicio().getMed_ser() }"></c:out></td>
				<td><c:out value="${detalles.getTot_dped()}"></c:out></td>
				</tr>
			</c:forEach>	
		</table>
	</div>
	<div class = "card-footer d-flex">

		<div><h5>Total: </h5></div>
		<div class="col-sm-4 ml-auto">
			<input type = "text" class="form-control" name = "tot_ped" value ="${pedido.getTot_ped() }">		        
		</div>
	</div>
			<div class = "col-sm-6">
			<a href="insertarPedido.do" class="btn btn-success " onclick="print()" >Generar Pedido</a>
		</div>
  </div>
</div>
</body>
</html>