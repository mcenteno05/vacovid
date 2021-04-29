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
@Table(name = "DISTRIBUIDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidor.findAll", query = "SELECT d FROM Distribuidor d"),
    @NamedQuery(name = "Distribuidor.findByIdentificacion", query = "SELECT d FROM Distribuidor d WHERE d.identificacion = :identificacion"),
    @NamedQuery(name = "Distribuidor.findByNombre", query = "SELECT d FROM Distribuidor d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Distribuidor.findByApellido", query = "SELECT d FROM Distribuidor d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Distribuidor.findByFechaDeNacimiento", query = "SELECT d FROM Distribuidor d WHERE d.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Distribuidor.findByTelefono", query = "SELECT d FROM Distribuidor d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Distribuidor.findByCorreo", query = "SELECT d FROM Distribuidor d WHERE d.correo = :correo"),
    @NamedQuery(name = "Distribuidor.findByPassword", query = "SELECT d FROM Distribuidor d WHERE d.password = :password")})
public class Distribuidor implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificacionDistribuidor")
    private Collection<InventarioDeVacunacion> inventarioDeVacunacionCollection;

    public Distribuidor() {
    }

    public Distribuidor(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Distribuidor(Integer identificacion, String nombre, String apellido, Date fechaDeNacimiento, String telefono, String correo, String password) {
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

    @XmlTransient
    public Collection<InventarioDeVacunacion> getInventarioDeVacunacionCollection() {
        return inventarioDeVacunacionCollection;
    }

    public void setInventarioDeVacunacionCollection(Collection<InventarioDeVacunacion> inventarioDeVacunacionCollection) {
        this.inventarioDeVacunacionCollection = inventarioDeVacunacionCollection;
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
        if (!(object instanceof Distribuidor)) {
            return false;
        }
        Distribuidor other = (Distribuidor) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.Distribuidor[ identificacion=" + identificacion + " ]";
    }
    
}
