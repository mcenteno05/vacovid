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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByCitaid", query = "SELECT c FROM Cita c WHERE c.citaid = :citaid"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByFase", query = "SELECT c FROM Cita c WHERE c.fase = :fase"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CITAID")
    private Integer citaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FASE")
    private int fase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "ID_SITIO", referencedColumnName = "SITIOID")
    @ManyToOne(optional = false)
    private SitioVacunacion idSitio;
    @JoinColumn(name = "IDENTIFICACION_USUARIO", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false)
    private Usuario identificacionUsuario;

    public Cita() {
    }

    public Cita(Integer citaid) {
        this.citaid = citaid;
    }

    public Cita(Integer citaid, Date fecha, int fase, Date hora) {
        this.citaid = citaid;
        this.fecha = fecha;
        this.fase = fase;
        this.hora = hora;
    }

    public Integer getCitaid() {
        return citaid;
    }

    public void setCitaid(Integer citaid) {
        this.citaid = citaid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public SitioVacunacion getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(SitioVacunacion idSitio) {
        this.idSitio = idSitio;
    }

    public Usuario getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(Usuario identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaid != null ? citaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.citaid == null && other.citaid != null) || (this.citaid != null && !this.citaid.equals(other.citaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.Cita[ citaid=" + citaid + " ]";
    }
    
}
