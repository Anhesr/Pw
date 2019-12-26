function modificarPerfil() {
  window.location = "/niusFIK/perfil/mod";
}

function hoverOnPublication(id) {  
  document.getElementById("titPublicacion" + id).style.opacity = "0.5";
  document.getElementById("hrPublicacion" + id).style.opacity = "0.5";
  document.getElementById("bodyPublicacion" + id).style.opacity = "0.5";
  document.getElementById("goToPubli" + id).style.display = "unset";
}

function noPublis() {
    document.getElementById("misPublis").style.display = "none";
    document.getElementById("gridForCVPubls").className = "";
    document.getElementById("noPublis").style.display = "unset";
}

function outHoverOnPublication(id) {
  document.getElementById("titPublicacion" + id).style.opacity = "1";
  document.getElementById("hrPublicacion" + id).style.opacity = "1";
  document.getElementById("bodyPublicacion" + id).style.opacity = "1";
  document.getElementById("goToPubli" + id).style.display = "none"; 
}

function goToPubli(id) {
  window.location = "../publicacion/publicacion.jsp";
}
