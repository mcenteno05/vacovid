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
 * @author JEFRY
 */
@Entity
@Table(name = "VACUNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByVacunaid", query = "SELECT v FROM Vacuna v WHERE v.vacunaid = :vacunaid"),
    @NamedQuery(name = "Vacuna.findByNombre", query = "SELECT v FROM Vacuna v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vacuna.findByFechaDeVencimiento", query = "SELECT v FROM Vacuna v WHERE v.fechaDeVencimiento = :fechaDeVencimiento"),
    @NamedQuery(name = "Vacuna.findByCantidad", query = "SELECT v FROM Vacuna v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "Vacuna.findByLote", query = "SELECT v FROM Vacuna v WHERE v.lote = :lote")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VACUNAID")
    private Integer vacunaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_DE_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaDeVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOTE")
    private int lote;
    @JoinColumn(name = "ID_INVENTARIO_NACIONAL", referencedColumnName = "INVENTARIOID")
    @ManyToOne(optional = false)
    private InventarioNacional idInventarioNacional;

    public Vacuna() {
    }

    public Vacuna(Integer vacunaid) {
        this.vacunaid = vacunaid;
    }

    public Vacuna(Integer vacunaid, String nombre, Date fechaDeVencimiento, int cantidad, int lote, InventarioNacional idInventarioNacional) {
        this.vacunaid = vacunaid;
        this.nombre = nombre;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.cantidad = cantidad;
        this.lote = lote;
        this.idInventarioNacional = idInventarioNacional;
    }

    public Integer getVacunaid() {
        return vacunaid;
    }

    public void setVacunaid(Integer vacunaid) {
        this.vacunaid = vacunaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
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

    public InventarioNacional getIdInventarioNacional() {
        return idInventarioNacional;
    }

    public void setIdInventarioNacional(InventarioNacional idInventarioNacional) {
        this.idInventarioNacional = idInventarioNacional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacunaid != null ? vacunaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.vacunaid == null && other.vacunaid != null) || (this.vacunaid != null && !this.vacunaid.equals(other.vacunaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.Vacuna[ vacunaid=" + vacunaid + " ]";
    }
    
}
