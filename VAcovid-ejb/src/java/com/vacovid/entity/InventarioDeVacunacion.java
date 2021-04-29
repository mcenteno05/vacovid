/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "INVENTARIO_DE_VACUNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioDeVacunacion.findAll", query = "SELECT i FROM InventarioDeVacunacion i"),
    @NamedQuery(name = "InventarioDeVacunacion.findByInventarioid", query = "SELECT i FROM InventarioDeVacunacion i WHERE i.inventarioid = :inventarioid"),
    @NamedQuery(name = "InventarioDeVacunacion.findByCantidad", query = "SELECT i FROM InventarioDeVacunacion i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "InventarioDeVacunacion.findByLote", query = "SELECT i FROM InventarioDeVacunacion i WHERE i.lote = :lote")})
public class InventarioDeVacunacion implements Serializable {

    @JoinColumn(name = "IDENTIFICACION_DISTRIBUIDOR", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false)
    private Distribuidor identificacionDistribuidor;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INVENTARIOID")
    private Integer inventarioid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTE")
    private int lote;
    @OneToMany(mappedBy = "idInventario")
    private Collection<Vacuna> vacunaCollection;
    @JoinColumn(name = "ID_SITIO", referencedColumnName = "SITIOID")
    @ManyToOne(optional = false)
    private SitioVacunacion idSitio;

    public InventarioDeVacunacion() {
    }

    public InventarioDeVacunacion(Integer inventarioid) {
        this.inventarioid = inventarioid;
    }

    public InventarioDeVacunacion(Distribuidor identificacionDistribuidor, Integer inventarioid, int cantidad, int lote, SitioVacunacion idSitio) {
        this.identificacionDistribuidor = identificacionDistribuidor;
        this.inventarioid = inventarioid;
        this.cantidad = cantidad;
        this.lote = lote;
        this.idSitio = idSitio;
    }


    public Integer getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(Integer inventarioid) {
        this.inventarioid = inventarioid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    @XmlTransient
    public Collection<Vacuna> getVacunaCollection() {
        return vacunaCollection;
    }

    public void setVacunaCollection(Collection<Vacuna> vacunaCollection) {
        this.vacunaCollection = vacunaCollection;
    }

    public SitioVacunacion getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(SitioVacunacion idSitio) {
        this.idSitio = idSitio;
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

    public Distribuidor getIdentificacionDistribuidor() {
        return identificacionDistribuidor;
    }

    public void setIdentificacionDistribuidor(Distribuidor identificacionDistribuidor) {
        this.identificacionDistribuidor = identificacionDistribuidor;
    }
    
}
