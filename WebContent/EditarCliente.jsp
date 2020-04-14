<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 <script src ="js/val.js" type ="text/javascript"></script>
 	
</head>
<body>
<%
String id_cl = (String)request.getAttribute("id_cl");
pageContext.setAttribute("id_cl",id_cl);
String nom_cl = (String)request.getAttribute("nom_cl");
pageContext.setAttribute("nom_cl",nom_cl);
String ape_cl = (String)request.getAttribute("ape_cl");
pageContext.setAttribute("ape_cl",ape_cl);
String tel_cl = (String)request.getAttribute("tel_cl");
pageContext.setAttribute("tel_cl",tel_cl);
%>
<fieldset>
	<div class="d-flex" >	
		<div class="card col-sm-4" >
			<div class="card-body"name = "Insertar">
			<!-- action="insertarCliente.do" -->
			<h5 class = "card-body text-center" >Editar Cliente</h5>
			 <form id = "formularioEditarCliente" >
			 	<div classs="form-group">
				 <label> Id </label>
				 <input type="text" id = "id_cl" name="id_cl" class="form-control"  value= "${id_cl}" >
				 </div>
				 <div classs="form-group">
				 <label> Nombre </label>
				 <input type="text" id = "nom_cl" name="nom_cl" value = "${nom_cl}"  class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Apellido </label>
				 <input type="text" id = "ape_cl" name="ape_cl" value = "${ape_cl}"  class="form-control">
				 </div>
				 <div classs="form-group">
				 <label> Telefono </label>
				 <input type="text" name="tel_cl" id = "tel_cl" value = "${tel_cl}"  class="form-control">
				 </div>
				 <input type="submit"  class="btn btn-info" onclick="validacionEditarCliente()"/>
			 </form>
			</div>
		</div>
	</div>
	
	
 </fieldset>
</body>
</html>