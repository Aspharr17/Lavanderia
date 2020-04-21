<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Servicios</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 <script src ="js/val.js" type ="text/javascript"></script>
 	
</head>
<body>
<%
String id_ser = (String)request.getAttribute("id_ser");
pageContext.setAttribute("id_ser",id_ser);
String nom_ser = (String)request.getAttribute("nom_ser");
pageContext.setAttribute("nom_ser",nom_ser);
String cost_ser = (String)request.getAttribute("cost_ser");
pageContext.setAttribute("cost_ser",cost_ser);
String med_ser = (String)request.getAttribute("med_ser");
pageContext.setAttribute("med_ser",med_ser);
%>
<fieldset>
	<div class="d-flex" >	
		<div class="card col-sm-4" >
			<div class="card-body"name = "EditarServicios">
			<!-- action="insertarCliente.do" -->
			<h5 class = "card-body text-center" >Editar Servicios</h5>
			 <form id = "formularioEditarServicio" >
			 	<div classs="form-group">
			 	 <label> Id </label>
				 <input type="text" id = "id_ser" name="id_ser" class="form-control"  value= "${id_ser}" readonly >
				 </div>
				 <div classs="form-group">
				 <label> Nombre </label>
				 <input type="text" id = "nom_ser" name="nom_ser" class="form-control"  value= "${nom_ser}" >
				 </div>
				 <div classs="form-group">
				 <label> Costo </label>
				 <input type="text" id = "cost_ser" name="cost_ser" value = "${cost_ser}"  class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Medida </label>
				 <input type="text" id = "med_ser" name="med_ser" value = "${med_ser}"  class="form-control">
				 </div>
				 <input type="submit"  class="btn btn-info" onclick="validacionEditarServicios()"/>
			 </form>
			</div>
		</div>
	</div>
	
	
 </fieldset>
</body>
</html>