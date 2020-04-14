<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla Servicios</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src ="js/val.js" type ="text/javascript"></script>
</head>
<body>
 <fieldset>
	<div class="d-flex" >	
		<div class="table">
		<%
		List<Servicio> listaServicios =(List<Servicio>)request.getAttribute("listaServicios");
		pageContext.setAttribute("listaServicios",listaServicios);
		%>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Servicio</th>
					<th>Costo</th>
					<th>Medida</th>
				</tr>
			</thead>
		<c:forEach var="servicio" items ="${listaServicios}">
		<tr>
		<td><c:out value="${servicio.getNom_ser()}"></c:out></td>
		<td><c:out value="${servicio.getCost_ser()}"></c:out></td>
		<td><c:out value="${servicio.getMed_ser()}"></c:out></td>
		</tr>
		</c:forEach>	
				
		</table>
		</div>
	</div>
 </fieldset>
</body>
</html>