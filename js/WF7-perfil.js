function modificarPerfil() {
  window.location = "../html/WF4-modificar_perfil.html";
}

function hoverOnPublication(id) {  
  document.getElementById("titPublicacion" + id).style.opacity = "0.5";
  document.getElementById("hrPublicacion" + id).style.opacity = "0.5";
  document.getElementById("bodyPublicacion" + id).style.opacity = "0.5";
  document.getElementById("goToPubli" + id).style.display = "unset";
}

function outHoverOnPublication(id) {
  document.getElementById("titPublicacion" + id).style.opacity = "1";
  document.getElementById("hrPublicacion" + id).style.opacity = "1";
  document.getElementById("bodyPublicacion" + id).style.opacity = "1";
  document.getElementById("goToPubli" + id).style.display = "none"; 
}

function goToPubli(id) {
  window.location = "../html/WF6-publicacion.html";
}
