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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByCitaid", query = "SELECT c FROM Cita c WHERE c.citaid = :citaid"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByFase", query = "SELECT c FROM Cita c WHERE c.fase = :fase"),
    @NamedQuery(name = "Cita.findByEntidadSalud", query = "SELECT c FROM Cita c WHERE c.entidadSalud = :entidadSalud")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @Size(min = 1, max = 75)
    @Column(name = "ENTIDAD_SALUD")
    private String entidadSalud;
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

    public Cita(Date fecha, int fase, String entidadSalud, SitioVacunacion idSitio, Usuario identificacionUsuario) {
        this.fecha = fecha;
        this.fase = fase;
        this.entidadSalud = entidadSalud;
        this.idSitio = idSitio;
        this.identificacionUsuario = identificacionUsuario;
    }


    public Integer getCitaid() {
        return citaid;
    }

    public void setCitaid(Integer citaid) {
        this.citaid = citaid;
    }

    public String getFecha() {
        int año=fecha.getYear()+1900;
        String fechaStr=fecha.getDate()+"/"+fecha.getMonth()+"/"+año+" "+fecha.getHours()+":"+fecha.getMinutes();
        return fechaStr;
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

    public String getEntidadSalud() {
        return entidadSalud;
    }

    public void setEntidadSalud(String entidadSalud) {
        this.entidadSalud = entidadSalud;
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
