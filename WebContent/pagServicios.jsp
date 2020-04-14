<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Registar cliente</title>
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
			<h3>Registro</h3>
			
		<div class="card">
		<div class="card-body">
			 <form>
			 <div classs="form-group">
			 <label> Nombre </label>
			 <input type="text" name="nom_cl" class="form-control">
			 </div>
			 <div classs="form-group">
			 <label> Apellido </label>
			 <input type="text" name="ape_cl" class="form-control">
			 </div>
			 <div classs="form-group">
			 <label> Telefono </label>
			 <input type="text" name="tel_cl" class="form-control">
			 </div>
			 <input type="submit" name="accion" value="Agregar" class="btn btn-info">
			 </form>
		</div>
	</div>
		<input type = "submit"  value="Guardar" onclick="validacionIngresarCliente()" > 
	</form>
	</div>
	</div>
	</div>

</body>
</html>