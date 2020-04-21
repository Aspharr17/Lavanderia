<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src ="js/val.js" type ="text/javascript"></script>
</head>
<body>
<%
List<Pedido> listaPedidos = (List<Pedido>)request.getAttribute("listaPedidos");
pageContext.setAttribute("listaPedidos",listaPedidos);

List<Cliente> clienteBuscado =(List<Cliente>)request.getAttribute("clienteBuscado");
pageContext.setAttribute("clienteBuscado",clienteBuscado);

List<Estado> listaEstados = (List<Estado>)request.getAttribute("listaEstados");
pageContext.setAttribute("listaEstados",listaEstados);
%>

<div class = "d-flex">
	<div class="card col-sm-4" >
		<div class="card text-center ">
			<!-- action="insertarCliente.do" -->
		<h5 class = "card-body text-center" >Busqueda por</h5>
		 <form id = "formFiltroEstado" action ="filtroEstado.do" >
			 <div classs="form-group text-center">
			 <label> Estatus </label>
			 <p>
			 <select name = "sel_estado" id ="sel_estado" >
				<option value = "seleccionar" >seleccionar</option>
				<c:forEach var="estado" items ="${listaEstados}">
					<c:if test = "${estado.getNom_est()!= pedido.getEst_ped()}">
						<option value = "${estado.getNom_est()}">${estado.getNom_est()}</option>      
					</c:if>
				</c:forEach>
				</select>
			 </p>
			 </div>
			 <input type="submit" value="Buscar" class="btn btn-info mb-3" onclick="valFiltroEst()"/>
			<p><a href = "paginaPedidos.do" class = "btn btn-info mb-3">Buscar todos</a></p> 	
		 </form>
		</div>
		
		 <div class = "card text-center">
		 <form id = "formularioBuscarCliente" action ="filtroCliente.do">
				 <label class ="label mt-3"> Cliente</label>
				 <input type="text" id = "info_cl" name="info_cl" class="form-control mb-3">				 
				 <input type="submit"  value = "Buscar"class="btn btn-info mb-5" />
		</form>
		</div>
	</div>
	
	
	
	<div class="table">
		<table class="table table-hover" >
			<thead>
				<tr>
					<th># Pedido</th>
					<th># Cliente</th>
					<th>Total</th>
					<th>Fecha</th>
					<th>Estado</th>
				</tr>
			</thead>
			<c:forEach var="pedido" items ="${listaPedidos}">
				<tr >
				<td><c:out value="${pedido.getId_ped()}"></c:out></td>
				<td><c:out value="${pedido.getIdcl_ped()}"></c:out></td>
				<td>$<c:out value="${pedido.getTot_ped() }"></c:out></td>
				<td><c:out value="${pedido.getDate_ped() }"></c:out></td>
				<td><c:out value="${pedido.getEst_ped()}"></c:out></td>
				<td><a class="btn btn-primary" href="buscarPedido.do?id_ped= ${pedido.getId_ped()}">Ver Pedido</a></td>
				</tr>
			</c:forEach>	
		</table>
	</div>
	
</div>
</fieldset>
</body>
</html>