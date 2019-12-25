function accederListaPubli() {
	window.location = "../lista_publicaciones/lista_publicaciones.jsp";
}

function validarPass() {
	var password = document.getElementById("pass");
	var msjError = document.getElementById("msjErrorValidar");

	if (password.value.length >= 7)
		msjError.style.display = "none";
	else
		msjError.style.display = "unset";
}

function verificarPass() {
	var firstPass = document.getElementById("pass");
	var secondPass = document.getElementById("pass2")
	var boton = document.getElementById("botonRegistro")
	var msj = document.getElementById("msjErrorVerificar")

	if (firstPass.value === secondPass.value)
	{
		msj.style.display = "none";
		boton.disabled = false;
		
	}
	else
	{
		msj.style.display = "unset";
		boton.disabled = true;
	}
	
}
