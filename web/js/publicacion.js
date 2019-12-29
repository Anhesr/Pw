/* global request */
//import es.uco.pw.niusFIK.dao.comentariosDAO;

function comentar() {
    var cuerpo = document.getElementById("Coment").value ;
    var f = new Date();
    var fecha = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();
    var idPublicacion = document.getElementById("idP").value ;
    var nombre = request.getAttribute("usuarioActual").get("nombre");
    var apellidos = request.getAttribute("usuarioActual").get("apellido");
    publicarComentario(idPublicacion, 1, nombre, apellidos, cuerpo, fecha);
}