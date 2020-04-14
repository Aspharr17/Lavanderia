
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
    	formularioBuscarCliente.action="buscarCliente.do"
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
	var id_ser = document.getElementById("id_ser").value;
    var nom_ser = document.getElementById("nom_ser").value;
    var cost_ser = document.getElementById("cost_ser").value;
    var editarServicios = document.getElementById("editarServicios");
   	if(id_ser != "" && nom_ser !="" && cost_ser !="")
    {

    		editarServicios.action = "EditarServicios.do";
    		editarServicios.submit();
    
    }
    else
    {
    	alert("Faltan datos");
    	return false;
    }
    
}


