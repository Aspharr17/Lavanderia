<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Lavamas</title>
	<link rel="stylesheet" type="text/css" href="styles/styles.css"/>
	<!-- Bootstrap-->
	<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
 	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
 	crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
	crossorigin="anonymous"></script>
 
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-success text-white">
  <a class="navbar-brand text-white" href="Menu.jsp">Lavamas</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" 
  	data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
  	aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse " id="navbarSupportedContent" >
    <ul class="navbar-nav mr-auto ">
      <li class="nav-item active">
        <a style ="margin-right: 5px; border: none;" class="btn btn-outline-light" href="Menu.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a style ="margin-right: 5px; border: none;" class="btn btn-outline-light" href="#">Servicios</a>
      </li>
       <li class="nav-item">
        <a style ="margin-right: 5px; border: none;" class="btn btn-outline-light" href="#">Pedido</a>
      </li>
      <li class="nav-item">
        <a style ="margin-right: 5px; border: none;" class="btn btn-outline-light" href="#">Clientes</a>
      </li>
      <li class="nav-item">
        <a style ="margin-right: 5px;" class="btn btn-danger" href="#">Nuevo Pedido</a>
      </li>
    </ul>
    <ul class="navbar-nav mr-auto">
    	<li> 
    	<form class="form-inline my-2 my-lg-0">
      		<input class="form-control mr-sm-2" type="search" placeholder="# Pedido" aria-label="# Pedido">
      		<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Busca un pedido</button>
		</form>
    	</li>
    	
    </ul>
   <ul class ="navbar-nav mr-auto">
   	 <li class="dropdown ">
  		<button class="btn btn-outline-light" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    	Mi perfil
  		</button>
  		<div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
    		<a class="dropdown-item" >mi nombre</a>
    		<a class="dropdown-item" href="#">Editar</a>
    		<a class="dropdown-item" href="index.jsp">Cerrar Sesión</a>
  		</div>
	</li>
   </ul>
  </div>

</nav>

</body>
</html>