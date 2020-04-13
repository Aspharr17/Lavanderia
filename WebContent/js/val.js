window.onload=generarEvento;

function validation()
{
	var formularioLogin = document.getElementById("formularioLogin");
	var user = document.getElementById("txtUser").value;
	var pass = document.getElementById("txtPass").value;
	if(user!="" && pass!="")
	{

      formularioLogin.submit();
		
	}
	else
	{
		alert("Faltan datos");
		return false;
	}
	

}

function generarEvento()
{
	var formularioLogin = document.getElementById("formularioLogin");
	formularioLogin.onsubmit = function(){
		
		validation();
		return false;
	}
}

function validacionIngresarCliente()
{   
    var id = document.getElementById("id_cl").value;
    var nombre = document.getElementById("nom_cl").value;
    var apellido = document.getElementById("ape_cl").value;
    var telefono = document.getElementById("tel_cl").value;


    if(id_cl != "" && nom_cl != "" && ape_cl !="" && tel_cl !="")
    {
    	if(Number.isInteger(parseInt(id_cl)))
    	{            
            document.forms[0].action = "InsertarCliente.jsp?id="+id_cl+"&nombre="+nom_cl+"&apellido="+ape_cl+"&telefono="+tel_cl;
            document.forms[0].method = "post";
            document.forms[0].submit();
    	}
    	else
    		alert("Formato de id incorrecto");
    	{}
    }
    else
    {
        alert("Faltan datos");
    }
}


