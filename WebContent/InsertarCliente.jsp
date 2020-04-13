<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<div class="d-flex">	
		<div class="card col-sm-6">
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
			 <input type="submit" name="accion" value="Agregar" class="btn btn-info" onclick="validacionIngresarCliente()"/>
			 </form>
		</div>
	</div>
	
		<div class="col-cm-8">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombres</th>
					<th>Apellidos</th>
					<th>Telefonos</th>
				</tr>
			</thead>
				
		</table>
		</div>
	</div>
 </fieldset>
</body>
</html>