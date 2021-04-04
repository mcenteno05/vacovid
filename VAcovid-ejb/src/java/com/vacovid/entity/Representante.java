/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "REPRESENTANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findByIdentificacion", query = "SELECT r FROM Representante r WHERE r.identificacion = :identificacion"),
    @NamedQuery(name = "Representante.findByNombre", query = "SELECT r FROM Representante r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Representante.findByApellido", query = "SELECT r FROM Representante r WHERE r.apellido = :apellido"),
    @NamedQuery(name = "Representante.findByFechaDeNacimiento", query = "SELECT r FROM Representante r WHERE r.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Representante.findByTelefono", query = "SELECT r FROM Representante r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "Representante.findByCorreo", query = "SELECT r FROM Representante r WHERE r.correo = :correo"),
    @NamedQuery(name = "Representante.findByPassword", query = "SELECT r FROM Representante r WHERE r.password = :password")})
public class Representante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFICACION")
    private Integer identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DE_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ID_SITIO", referencedColumnName = "SITIOID")
    @ManyToOne(optional = false)
    private SitioVacunacion idSitio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacionRepresentante")
    private Collection<SitioVacunacion> sitioVacunacionCollection;

    public Representante() {
    }

    public Representante(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Representante(Integer identificacion, String nombre, String apellido, Date fechaDeNacimiento, String telefono, String correo, String password) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
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

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
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

    public SitioVacunacion getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(SitioVacunacion idSitio) {
        this.idSitio = idSitio;
    }

    @XmlTransient
    public Collection<SitioVacunacion> getSitioVacunacionCollection() {
        return sitioVacunacionCollection;
    }

    public void setSitioVacunacionCollection(Collection<SitioVacunacion> sitioVacunacionCollection) {
        this.sitioVacunacionCollection = sitioVacunacionCollection;
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
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.Representante[ identificacion=" + identificacion + " ]";
    }
    
}
