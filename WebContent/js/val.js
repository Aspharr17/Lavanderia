function validation()
{
	var user = document.getElementById("txtUser").value;
	var pass = document.getElementById("txtPass").value;
	if(user!="" && pass!="")
	{
		document.forms[0].action = "Controlador?user="+user+"&pass="+pass;
        document.forms[0].method = "post";
        document.forms[0].submit();
		
	}
	else
	{
		alert("Faltan datos");
	}

}