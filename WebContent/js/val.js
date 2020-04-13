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

