function irPerfil() {
    window.location = "/niusFIK/perfil";
}

function onSubmit() {
    if (document.getElementById("lastPass").value === "") {
        document.getElementById("lastPass").disabled = true;
    } else {
        document.getElementById("lastPass").disabled = false;
    }
}

function activateImg() {
    var checkbox = document.getElementById("imgselecting");
    var imagen = document.getElementById("imagen");
    if (checkbox.checked) {
        imagen.disabled = false;
    } else {
        imagen.disabled = true;
    }
}

function isEmpty() {
    if (document.getElementById("lastPass").value !== "") {
        document.getElementById("password").disabled = false;
        document.getElementById("valPass").disabled = false;
        document.getElementById("submitButton").disabled = true;
    } else {
        document.getElementById("password").disabled = true;
        document.getElementById("valPass").disabled = true;
        document.getElementById("submitButton").disabled = false;
    }
}

function samePass() {
    if (document.getElementById("password").value
            === document.getElementById("valPass").value) {
        document.getElementById("submitButton").disabled = false;
    } else {
        document.getElementById("submitButton").disabled = true;
    }
}

function changeCVType(focus) {
    var hrCV = document.getElementById("hrCV");
    var privCV = document.getElementById("privCV");
    var pubCV = document.getElementById("pubCV");
    var privCVBut = document.getElementById("privCVBut");
    var pubCVBut = document.getElementById("pubCVBut");

    if (focus === "priv") {
        pubCV.style.display = "none";
        privCV.style.display = "unset";
        privCVBut.style.backgroundColor = "unset";
        privCVBut.style.borderBottom = "0px";
        privCVBut.style.borderLeft = "0px";
        pubCVBut.style.border = "solid 1px gray";
        pubCVBut.style.borderTop = "0px";
        pubCVBut.style.backgroundColor = "rgba(224, 222, 219, 1)";
    } else {
        privCV.style.display = "none";
        pubCV.style.display = "unset";
        pubCVBut.style.border = "0px";
        pubCVBut.style.backgroundColor = "unset";
        privCVBut.style.backgroundColor = "rgba(224, 222, 219, 1)";
        privCVBut.style.borderBottom = "solid 1px gray";
        privCVBut.style.borderLeft = "solid 1px gray";

    }
}