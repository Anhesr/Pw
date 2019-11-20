function irPerfil() {
  document.getElementById("formCV").style.display = "none";
  document.getElementById("footer").style.display = "none";
  document.getElementById("CVMod").style.display = "unset";
  setTimeout(function() {
    window.location = "../html/WF7-perfil.html";
  }, 3000);
}

function changeCVType(focus) {
  var hrCV = document.getElementById("hrCV");
  var privCV = document.getElementById("privCV");
  var pubCV = document.getElementById("pubCV");
  var privCVBut = document.getElementById("privCVBut");
  var pubCVBut = document.getElementById("pubCVBut");
  
  if (focus == "priv") {
    pubCV.style.display = "none";
    privCV.style.display = "unset";
    privCVBut.style.backgroundColor = "unset";
    privCVBut.style.borderBottom = "0px";
    privCVBut.style.borderLeft = "0px";
    pubCVBut.style.border = "solid 1px gray";
    pubCVBut.style.borderTop = "0px";
    pubCVBut.style.backgroundColor = "rgba(224, 222, 219, 1)";
  }
  else {
    privCV.style.display = "none";
    pubCV.style.display = "unset";
    pubCVBut.style.border = "0px";
    pubCVBut.style.backgroundColor = "unset";
    privCVBut.style.backgroundColor = "rgba(224, 222, 219, 1)";
    privCVBut.style.borderBottom = "solid 1px gray";
    privCVBut.style.borderLeft = "solid 1px gray";

  }
}