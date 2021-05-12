const faseUsuario = document.getElementById("faseUsuario")
const faseActual = document.getElementById("faseActual")
const formulario = document.getElementById("formularioSolicitar")
const aviso = document.getElementById("aviso")

if(faseActual.textContent === faseUsuario.textContent){
   formulario.style.display = "flex";
   aviso.style.display = "none"
}else{
   const span = document.getElementById("span_etapa")
   span.textContent = faseUsuario.textContent
   formulario.style.display = "none";
   aviso.style.display = "flex"
}











