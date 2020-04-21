<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lavanderia Lavamas</title>
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
 	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
 	crossorigin="anonymous">
 	<script src ="js/val.js" type ="text/javascript"></script>
</head>
<body>
<%
int recibidos =(Integer)request.getAttribute("recibidos");
pageContext.setAttribute("recibidos",recibidos);

int proceso =(Integer)request.getAttribute("proceso");
pageContext.setAttribute("proceso",proceso);

int listos =(Integer)request.getAttribute("listos");
pageContext.setAttribute("listos",listos);

%>
<div class="card-header text-white text-center bg-primary mb-2">
    <h4>Pedidos Actuales</h4>
</div>
<div class="d-flex">
  <div class="col-sm-4">
	<div class="card-body text-white bg-danger text-center">
        <h3 class="card-title">Pedidos Recibidos</h3>
        <h4><c:out value="${recibidos}"></c:out></h4>
    </div>
  </div>
    <div class="col-sm-4">
	<div class="card-body text-white bg-warning text-center">
        <h3 class="card-title">Pedidos en proceso</h3>
        <h4 ><c:out value="${proceso}"></c:out></h4>
    </div>
  </div>
    <div class="col-sm-4">
	<div class="card-body text-white bg-success text-center" >
        <h3 class="card-title">Pedidos Listos</h3>
        <h4><c:out value="${listos}"></c:out></h4>
    </div>
  </div>
</div>
</body>
</html>