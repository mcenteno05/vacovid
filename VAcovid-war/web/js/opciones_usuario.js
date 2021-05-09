const opciones_usuario = document.querySelector(".container__usuario")
const boton_usuario = document.querySelector(".profile_boton")
console.log(boton_usuario)

boton_usuario.addEventListener("click", e => {
    if (opciones_usuario.style.display == "") {
        opciones_usuario.style.display = "block";
    } else {
        opciones_usuario.style.display = "";
    }
})