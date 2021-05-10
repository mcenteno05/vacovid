/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacovid.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEFRY
 */
@Entity
@Table(name = "REPORTE_DE_VACUNACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteDeVacunacion.findAll", query = "SELECT r FROM ReporteDeVacunacion r"),
    @NamedQuery(name = "ReporteDeVacunacion.findByReporteid", query = "SELECT r FROM ReporteDeVacunacion r WHERE r.reporteid = :reporteid"),
    @NamedQuery(name = "ReporteDeVacunacion.findByBrazo", query = "SELECT r FROM ReporteDeVacunacion r WHERE r.brazo = :brazo")})
public class ReporteDeVacunacion implements Serializable {

    @Size(max = 50)
    @Column(name = "VACUNA")
    private String vacuna;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REPORTEID")
    private Integer reporteid;
    @Size(max = 20)
    @Column(name = "BRAZO")
    private String brazo;
    @JoinColumn(name = "ID_CITA", referencedColumnName = "CITAID")
    @ManyToOne(optional = false)
    private Cita idCita;
    @JoinColumn(name = "IDENTIFICACION_PERSONAL", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false)
    private Personal identificacionPersonal;

    public ReporteDeVacunacion() {
    }

    public ReporteDeVacunacion(String vacuna, String brazo, Cita idCita, Personal identificacionPersonal) {
        this.vacuna = vacuna;
        this.brazo = brazo;
        this.idCita = idCita;
        this.identificacionPersonal = identificacionPersonal;
    }

   

    public Integer getReporteid() {
        return reporteid;
    }

    public void setReporteid(Integer reporteid) {
        this.reporteid = reporteid;
    }

    public String getBrazo() {
        return brazo;
    }

    public void setBrazo(String brazo) {
        this.brazo = brazo;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public Personal getIdentificacionPersonal() {
        return identificacionPersonal;
    }

    public void setIdentificacionPersonal(Personal identificacionPersonal) {
        this.identificacionPersonal = identificacionPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporteid != null ? reporteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteDeVacunacion)) {
            return false;
        }
        ReporteDeVacunacion other = (ReporteDeVacunacion) object;
        if ((this.reporteid == null && other.reporteid != null) || (this.reporteid != null && !this.reporteid.equals(other.reporteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.ReporteDeVacunacion[ reporteid=" + reporteid + " ]";
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    
}
