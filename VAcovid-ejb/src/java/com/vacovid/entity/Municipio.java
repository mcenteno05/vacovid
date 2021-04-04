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
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByRegion", query = "SELECT m FROM Municipio m WHERE m.region = :region"),
    @NamedQuery(name = "Municipio.findByCodigoDaneDepartamento", query = "SELECT m FROM Municipio m WHERE m.codigoDaneDepartamento = :codigoDaneDepartamento"),
    @NamedQuery(name = "Municipio.findByDepartamento", query = "SELECT m FROM Municipio m WHERE m.departamento = :departamento"),
    @NamedQuery(name = "Municipio.findByCodigoDaneMunicipio", query = "SELECT m FROM Municipio m WHERE m.codigoDaneMunicipio = :codigoDaneMunicipio"),
    @NamedQuery(name = "Municipio.findByMunicipio", query = "SELECT m FROM Municipio m WHERE m.municipio = :municipio")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "REGION")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DANE_DEPARTAMENTO")
    private int codigoDaneDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_DANE_MUNICIPIO")
    private Integer codigoDaneMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MUNICIPIO")
    private String municipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDaneMunicipio")
    private Collection<Usuario> usuarioCollection;

    public Municipio() {
    }

    public Municipio(Integer codigoDaneMunicipio) {
        this.codigoDaneMunicipio = codigoDaneMunicipio;
    }

    public Municipio(Integer codigoDaneMunicipio, String region, int codigoDaneDepartamento, String departamento, String municipio) {
        this.codigoDaneMunicipio = codigoDaneMunicipio;
        this.region = region;
        this.codigoDaneDepartamento = codigoDaneDepartamento;
        this.departamento = departamento;
        this.municipio = municipio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCodigoDaneDepartamento() {
        return codigoDaneDepartamento;
    }

    public void setCodigoDaneDepartamento(int codigoDaneDepartamento) {
        this.codigoDaneDepartamento = codigoDaneDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getCodigoDaneMunicipio() {
        return codigoDaneMunicipio;
    }

    public void setCodigoDaneMunicipio(Integer codigoDaneMunicipio) {
        this.codigoDaneMunicipio = codigoDaneMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDaneMunicipio != null ? codigoDaneMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codigoDaneMunicipio == null && other.codigoDaneMunicipio != null) || (this.codigoDaneMunicipio != null && !this.codigoDaneMunicipio.equals(other.codigoDaneMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacovid.entity.Municipio[ codigoDaneMunicipio=" + codigoDaneMunicipio + " ]";
    }
    
}
