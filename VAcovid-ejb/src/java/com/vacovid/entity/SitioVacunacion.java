/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "SITIO_VACUNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitioVacunacion.findAll", query = "SELECT s FROM SitioVacunacion s"),
    @NamedQuery(name = "SitioVacunacion.findBySitioid", query = "SELECT s FROM SitioVacunacion s WHERE s.sitioid = :sitioid"),
    @NamedQuery(name = "SitioVacunacion.findByNombre", query = "SELECT s FROM SitioVacunacion s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SitioVacunacion.findByDireccion", query = "SELECT s FROM SitioVacunacion s WHERE s.direccion = :direccion")})
public class SitioVacunacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITIOID")
    private Integer sitioid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSitio")
    private Collection<InventarioDeVacunacion> inventarioDeVacunacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSitio")
    private Collection<Representante> representanteCollection;
    @JoinColumn(name = "IDENTIFICACION_REPRESENTANTE", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false)
    private Representante identificacionRepresentante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSitio")
    private Collection<Cita> citaCollection;

    public SitioVacunacion() {
    }

    public SitioVacunacion(Integer sitioid) {
        this.sitioid = sitioid;
    }

    public SitioVacunacion(Integer sitioid, String nombre, String direccion) {
        this.sitioid = sitioid;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getSitioid() {
        return sitioid;
    }

    public void setSitioid(Integer sitioid) {
        this.sitioid = sitioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<InventarioDeVacunacion> getInventarioDeVacunacionCollection() {
        return inventarioDeVacunacionCollection;
    }

    public void setInventarioDeVacunacionCollection(Collection<InventarioDeVacunacion> inventarioDeVacunacionCollection) {
        this.inventarioDeVacunacionCollection = inventarioDeVacunacionCollection;
    }

    @XmlTransient
    public Collection<Representante> getRepresentanteCollection() {
        return representanteCollection;
    }

    public void setRepresentanteCollection(Collection<Representante> representanteCollection) {
        this.representanteCollection = representanteCollection;
    }

    public Representante getIdentificacionRepresentante() {
        return identificacionRepresentante;
    }

    public void setIdentificacionRepresentante(Representante identificacionRepresentante) {
        this.identificacionRepresentante = identificacionRepresentante;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sitioid != null ? sitioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SitioVacunacion)) {
            return false;
        }
        SitioVacunacion other = (SitioVacunacion) object;
        if ((this.sitioid == null && other.sitioid != null) || (this.sitioid != null && !this.sitioid.equals(other.sitioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.SitioVacunacion[ sitioid=" + sitioid + " ]";
    }
    
}
