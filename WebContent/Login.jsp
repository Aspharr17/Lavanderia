<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Login</title>
	<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src ="js/val.js" type ="text/javascript"></script>
</head>
<body>
	<div class = "container mt-4 col-lg-4">
	<div class = "card">
	<div class = "card-body text-center">
	<form action="Controlador" method = "post">
		<div class = "form-group">
			<img src = "img/img1.jpg" alt="70" width="170"/>
			<label>Inicia Sesión</label>
			
		</div>
		<div class="form-group">
			<label>Usuario</label>
			<input type="text" id = "txtUser" class = "form-control">
		</div>
		<div class="form-group">
			<label>Contraseña</label>
			<input type="password" id = "txtPass" class = "form-control">
		</div>
		<input type = "submit"  class= "btn btn-primary btn-block" onclick = "validation();"> 
	</form>
	</div>
	</div>
	</div>

</body>
</html>