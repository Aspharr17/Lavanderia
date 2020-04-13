<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Lavamas</title>
<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
 
 
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-success text-white">
  <a class="navbar-brand text-white" href="#">Lavamas</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" 
  	data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
  	aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a style ="margin-right: 5px;" class="btn btn-outline-light" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a style ="margin-right: 5px;" class="btn btn-outline-light" href="#">Servicios</a>
      </li>
      <li class="nav-item dropdown">

      </li>
      <li class="nav-item">
        <a style ="margin-right: 5px;" class="btn btn-outline-light" href="#">Disabled</a>
      </li>
    </ul>
    <ul class="navbar-nav mr-auto">
    	<li> 
    		<form class="form-inline my-2 my-lg-0" action ="buscarPedidoCliente.do">
      			<input class="form-control mr-sm-2" type="search" placeholder="# Pedido" aria-label="# Pedido">
      			<input class="form-control mr-sm-2" type="search" placeholder="Apellido" aria-label="Apellido">
      		<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Busca tu pedido</button>
		    </form>
    </li>
    </ul>
    <ul class="navbar-nav mr-auto">
    	<li class="nav-item">
    		<form name = "btnPaginaLogIn" action="paginaLogIn.do">
      			<button class="btn btn-outline-light my-2 my-sm-0" type="submit">Inicia Sesión</button>
      		</form>
      	</li>
     </ul>
  </div>
</nav>
<div style ="height: 590px;">
<iframe id = "Frame" name = "Frame" style="height: 100%; width:100%;">

</iframe>
</div>
</body>
</html>