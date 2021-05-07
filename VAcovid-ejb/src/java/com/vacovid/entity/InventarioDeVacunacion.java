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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Duarte
 */
@Entity
@Table(name = "INVENTARIO_DE_VACUNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioDeVacunacion.findAll", query = "SELECT i FROM InventarioDeVacunacion i"),
    @NamedQuery(name = "InventarioDeVacunacion.findByInventarioid", query = "SELECT i FROM InventarioDeVacunacion i WHERE i.inventarioid = :inventarioid")})
public class InventarioDeVacunacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INVENTARIOID")
    private Integer inventarioid;
    @JoinColumn(name = "ID_INVENTARIO_NACIONAL", referencedColumnName = "INVENTARIOID")
    @ManyToOne(optional = false)
    private InventarioNacional idInventarioNacional;
    @JoinColumn(name = "ID_SITIO", referencedColumnName = "SITIOID")
    @ManyToOne(optional = false)
    private SitioVacunacion idSitio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventarioVacunacion")
    private Collection<VacunaRecibida> vacunaRecibidaCollection;

   

    public InventarioDeVacunacion(InventarioNacional idInventarioNacional, SitioVacunacion idSitio) {
        this.idInventarioNacional = idInventarioNacional;
        this.idSitio = idSitio;
    }

    
    
    public InventarioDeVacunacion() {
    }

    public InventarioDeVacunacion(Integer inventarioid) {
        this.inventarioid = inventarioid;
    }

    public Integer getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(Integer inventarioid) {
        this.inventarioid = inventarioid;
    }

    public InventarioNacional getIdInventarioNacional() {
        return idInventarioNacional;
    }

    public void setIdInventarioNacional(InventarioNacional idInventarioNacional) {
        this.idInventarioNacional = idInventarioNacional;
    }

    public SitioVacunacion getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(SitioVacunacion idSitio) {
        this.idSitio = idSitio;
    }
    
     public Collection<VacunaRecibida> getVacunaRecibidaCollection() {
        return vacunaRecibidaCollection;
    }

    public void setVacunaRecibidaCollection(Collection<VacunaRecibida> vacunaRecibidaCollection) {
        this.vacunaRecibidaCollection = vacunaRecibidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioid != null ? inventarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioDeVacunacion)) {
            return false;
        }
        InventarioDeVacunacion other = (InventarioDeVacunacion) object;
        if ((this.inventarioid == null && other.inventarioid != null) || (this.inventarioid != null && !this.inventarioid.equals(other.inventarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.InventarioDeVacunacion[ inventarioid=" + inventarioid + " ]";
    }
    
}
