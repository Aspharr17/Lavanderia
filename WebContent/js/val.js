function validation()
{
	var formularioLogin = document.getElementById("formularioLogin");
	var user = document.getElementById("txtUser").value;
	var pass = document.getElementById("txtPass").value;
	var formularioLogin = document.getElementById("formularioLogin");
	if(user!="" && pass!="")
	{
	
		formularioLogin.action="Login.do";
		formularioLogin.submit();
		
	}
	else
	{
		alert("Faltan datos");
	}
	

}
function validacionBuscarCliente()
{
	var info_cl = document.getElementById("info_cl").value;
    var formularioBuscarCliente = document.getElementById("formularioBuscarCliente");
    if(info_cl !="")
    {
    	formularioBuscarCliente.submit();
    }
    else
    {
    	alert("Faltan datos");
    	return false;

    }
    
}
function validacionBuscarClientePedido()
{
	var info_cl = document.getElementById("info_cl").value;
    var formularioBuscarCliente = document.getElementById("formularioBuscarCliente");
    if(info_cl !="")
    {
    	formularioBuscarCliente.action="nuevoPedido.do"
    	formularioBuscarCliente.submit();
    }
    else
    {
    	alert("Faltan datos");

    }
    
}
function validacionIngresarCliente()
{       

    var nom_cl = document.getElementById("nom_cl").value;
    var ape_cl = document.getElementById("ape_cl").value;
    var tel_cl = document.getElementById("tel_cl").value;
    var formularioInsertarCliente = document.getElementById("formularioInsertarCliente");
   	if(nom_cl != "" && ape_cl !="" && tel_cl !="")
    {
   		alert("Agregado");

    		formularioInsertarCliente.action = "insertarCliente.do";
    		formularioInsertarCliente.submit();
    
    }
    else
    {
    	alert("Faltan datos");
    	return false;
    }
    
}
function validacionEditarCliente()
{       
	var id_cl = document.getElementById("id_cl").value;
    var nom_cl = document.getElementById("nom_cl").value;
    var ape_cl = document.getElementById("ape_cl").value;
    var tel_cl = document.getElementById("tel_cl").value;
    var formularioEditarCliente = document.getElementById("formularioEditarCliente");
   	if(nom_cl != "" && ape_cl !="" && tel_cl !="")
    {

    		formularioEditarCliente.action = "editarCliente.do";
    		formularioEditarCliente.submit();
    
    }
    else
    {
    	alert("Faltan datos");
    	return false;
    }
    
}
function validacionEditarServicios()
{       
    var nom_ser = document.getElementById("nom_ser").value;
    var cost_ser = document.getElementById("cost_ser").value;
    var med_ser = document.getElementById("med_ser").value;
    var formularioEditarServicio = document.getElementById("formularioEditarServicio");
   	if(nom_ser !="" && cost_ser !="" && med_ser !="")
    {
   		alert("Guardado");
   		formularioEditarServicio.action = "editarServicio.do";
   		formularioEditarServicio.submit();
    
    }
    else
    {
    	alert("Faltan datos");
    	return false;
    }
}
function validacionInsertarServicios()
   	{       
   	    var nom_ser = document.getElementById("nom_ser").value;
   	    var cost_ser = document.getElementById("cost_ser").value;
   	    var med_ser = document.getElementById("med_ser").value;
   	    var formularioInsertarServicio = document.getElementById("formularioInsertarServicio");
   	   	if(nom_ser !="" && cost_ser !="" && med_ser !="")
   	    {
   	   		alert("Agregado");
   	   		formularioInsertarServicio.action = "insertarServicio.do";
   	   		formularioInsertarServicio.submit();
   	    
   	    }
   	    else
   	    {
   	    	alert("Faltan datos");
   	    	return false;
   	    }
    
}
function validarDetalle()
{
	var sel_servicio = document.getElementById("sel_servicio").value;
	var cant_dped = document.getElementById("cant_dped").value;
	var formularioAgregarDetalle = document.getElementById("formularioAgregarDetalle");
	if(sel_servicio != "seleccionar" && cant_dped != "")
	{
		formularioAgregarDetalle.action = "agregarDetallePed.do";
		formularioAgregarDetalle.submit();
	}
	else
	{
		alert("Seleccione Datos");
		return false;
	}
}
function valBuscarPedido()
{
	
	var id_ped = document.getElementById("id_ped").value;
	var buscadorPedido = document.getElementById("buscadorPedido");
	if(id_ped != "")
	{
		if(Number.isInteger(parseInt(id_ped)))
		{
		buscadorPedido.action = "buscarPedido.do";
		buscadorPedido.submit();
		}
		else
		{
			alert("Formato no valido");
			return false;
		}
	}
	else
	{
		alert("Ingrese numero de pedido");
		return false;
		
	}
}
function valBuscarPedidoPub()
{
	var id_ped = document.getElementById("id_ped").value;
	var ape_cl = document.getElementById("ape_cl").value;
	var buscadorPedidoPub = document.getElementById("buscadorPedidoPub");
	if(id_ped != "" &&ape_cl != "")
	{
		if(Number.isInteger(parseInt(id_ped)))
		{
			buscadorPedidoPub.action = "buscarPedidoPub.do";
			buscadorPedidoPub.submit();
		}
		else
		{
			alert("Formato no valido");
			return false;
		}
	}
	else
	{
		alert("Faltan datos");
		return false;
	}
		
}

function valFiltroEst()
{
	var sel_estado = document.getElementById("sel_estado").value;
	var formFiltroEstado= document.getElementById("formFiltroEstado");

	if(sel_estado !="seleccionar")
	{
		formFiltroEstado.submit();
	}
	else
	{
		alert("Seleccione estado");
		return false();
	}

}
