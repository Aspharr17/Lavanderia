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
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Cantidad</th>
					<th>Nombre</th>
					<th>Precio</th>
				</tr>
			</thead>
		</table>
		</div>
	</div>
 </fieldset>
</body>
</html>