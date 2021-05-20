/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Duarte
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdentificacion", query = "SELECT u FROM Usuario u WHERE u.identificacion = :identificacion"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByFechaDeNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Usuario.findByPresentaEnfermedad", query = "SELECT u FROM Usuario u WHERE u.presentaEnfermedad = :presentaEnfermedad"),
    @NamedQuery(name = "Usuario.findByPersonalSalud", query = "SELECT u FROM Usuario u WHERE u.personalSalud = :personalSalud"),
    @NamedQuery(name = "Usuario.findByFase", query = "SELECT u FROM Usuario u WHERE u.fase = :fase"),
    @NamedQuery(name = "Usuario.findByClaveConfirmacion", query = "SELECT u FROM Usuario u WHERE u.claveConfirmacion = :claveConfirmacion"),
    @NamedQuery(name = "Usuario.findByEnfermedad", query = "SELECT u FROM Usuario u WHERE u.enfermedad = :enfermedad"),
    @NamedQuery(name = "Usuario.findByCategoriaProfesion", query = "SELECT u FROM Usuario u WHERE u.categoriaProfesion = :categoriaProfesion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFICACION")
    private Integer identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DE_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRESENTA_ENFERMEDAD")
    private Boolean presentaEnfermedad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONAL_SALUD")
    private Boolean personalSalud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FASE")
    private int fase;
    @Column(name = "CLAVE_CONFIRMACION")
    private Integer claveConfirmacion;
    @Size(max = 50)
    @Column(name = "ENFERMEDAD")
    private String enfermedad;
    @Size(max = 50)
    @Column(name = "CATEGORIA_PROFESION")
    private String categoriaProfesion;
    @JoinColumn(name = "CODIGO_DANE_MUNICIPIO", referencedColumnName = "CODIGO_DANE_MUNICIPIO")
    @ManyToOne(optional = false)
    private Municipio codigoDaneMunicipio;

    public Usuario() {
    }

    public Usuario(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Usuario(int identificacion, String nombres, String apellidos, Date date, String telefono, String email, String contraseña, 
            String tipo, String direccion, Municipio find, boolean presentaEnfermedad, boolean personalSalud, int fase, String enfermedad, String categoria) {
        this.identificacion = identificacion;
        this.nombre = nombres;
        this.apellido = apellidos;
        this.telefono = telefono;
        this.correo = email;
        this.password = contraseña;
        this.tipoDocumento = tipo;
        this.direccion = direccion;
        this.fechaDeNacimiento = date;
        this.presentaEnfermedad = presentaEnfermedad;
        this.personalSalud = personalSalud;
        this.fase = fase;
        this.enfermedad = enfermedad;
        this.categoriaProfesion = categoria;
    }

    

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Boolean getPresentaEnfermedad() {
        return presentaEnfermedad;
    }

    public void setPresentaEnfermedad(Boolean presentaEnfermedad) {
        this.presentaEnfermedad = presentaEnfermedad;
    }

    public Boolean getPersonalSalud() {
        return personalSalud;
    }

    public void setPersonalSalud(Boolean personalSalud) {
        this.personalSalud = personalSalud;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public Integer getClaveConfirmacion() {
        return claveConfirmacion;
    }

    public void setClaveConfirmacion(Integer claveConfirmacion) {
        this.claveConfirmacion = claveConfirmacion;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getCategoriaProfesion() {
        return categoriaProfesion;
    }

    public void setCategoriaProfesion(String categoriaProfesion) {
        this.categoriaProfesion = categoriaProfesion;
    }

    public Municipio getCodigoDaneMunicipio() {
        return codigoDaneMunicipio;
    }

    public void setCodigoDaneMunicipio(Municipio codigoDaneMunicipio) {
        this.codigoDaneMunicipio = codigoDaneMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.Usuario[ identificacion=" + identificacion + " ]";
    }
    
}
