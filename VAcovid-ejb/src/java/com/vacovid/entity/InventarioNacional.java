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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "INVENTARIO_NACIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioNacional.findAll", query = "SELECT i FROM InventarioNacional i"),
    @NamedQuery(name = "InventarioNacional.findByInventarioid", query = "SELECT i FROM InventarioNacional i WHERE i.inventarioid = :inventarioid")})
public class InventarioNacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INVENTARIOID")
    private Integer inventarioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventarioNacional")
    private Collection<Vacuna> vacunaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInventarioNacional")
    private Collection<InventarioDeVacunacion> inventarioDeVacunacionCollection;
    @JoinColumn(name = "IDENTIFICACION_DISTRIBUIDOR", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false)
    private Distribuidor identificacionDistribuidor;

    public InventarioNacional() {
    }

    public InventarioNacional(Integer inventarioid, Distribuidor identificacionDistribuidor) {
        this.inventarioid = inventarioid;
        this.identificacionDistribuidor = identificacionDistribuidor;
    }

    

    public Integer getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(Integer inventarioid) {
        this.inventarioid = inventarioid;
    }

    @XmlTransient
    public Collection<Vacuna> getVacunaCollection() {
        return vacunaCollection;
    }

    public void setVacunaCollection(Collection<Vacuna> vacunaCollection) {
        this.vacunaCollection = vacunaCollection;
    }

    @XmlTransient
    public Collection<InventarioDeVacunacion> getInventarioDeVacunacionCollection() {
        return inventarioDeVacunacionCollection;
    }

    public void setInventarioDeVacunacionCollection(Collection<InventarioDeVacunacion> inventarioDeVacunacionCollection) {
        this.inventarioDeVacunacionCollection = inventarioDeVacunacionCollection;
    }

    public Distribuidor getIdentificacionDistribuidor() {
        return identificacionDistribuidor;
    }

    public void setIdentificacionDistribuidor(Distribuidor identificacionDistribuidor) {
        this.identificacionDistribuidor = identificacionDistribuidor;
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
        if (!(object instanceof InventarioNacional)) {
            return false;
        }
        InventarioNacional other = (InventarioNacional) object;
        if ((this.inventarioid == null && other.inventarioid != null) || (this.inventarioid != null && !this.inventarioid.equals(other.inventarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.InventarioNacional[ inventarioid=" + inventarioid + " ]";
    }
    
}
