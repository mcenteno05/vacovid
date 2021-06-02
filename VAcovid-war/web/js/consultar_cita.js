const con_nombre = document.getElementById("con_nombre")

if(con_nombre){
    document.getElementById("in_cita").style.display = "flex" ;
    document.getElementById("sin_cita").style.display = "none" ;
    const con_apellido = document.getElementById("con_apellido")
    const con_tipo_d = document.getElementById("con_tipo_d")
    const con_id = document.getElementById("con_id")
    const con_dosis = document.getElementById("con_dosis")
    const con_fecha = document.getElementById("con_fecha")
    const con_hora = document.getElementById("con_hora")
    const con_dep = document.getElementById("con_dep")
    const con_mun = document.getElementById("con_mun")
    const con_entidad = document.getElementById("con_entidad")
    const con_cita = document.getElementById("con_idcita")

    document.getElementById("apellidos").textContent = con_apellido.textContent
    document.getElementById("nombres").textContent = con_nombre.textContent
    document.getElementById("tipo_d").textContent = con_tipo_d.textContent
    document.getElementById("n_doc").textContent = con_id.textContent
    document.getElementById("tipo_s").textContent = con_dosis.textContent
    document.getElementById("fecha").textContent = con_fecha.textContent
    document.getElementById("hora").textContent = con_hora.textContent
    document.getElementById("departamento").textContent = con_dep.textContent
    document.getElementById("ciudad").textContent = con_mun.textContent
    document.getElementById("entidad").textContent = con_entidad.textContent
    document.getElementById("citaname").textContent = con_cita.textContent
}else{
    document.getElementById("sin_cita").style.display = "flex" ;
    document.getElementById("in_cita").style.display = "none" ;
}