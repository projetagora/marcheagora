/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metier;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author israe
 */
@Entity
@Table(name = "prestation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p"),
    @NamedQuery(name = "Prestation.findByType", query = "SELECT p FROM Prestation p WHERE p.type = :type"),
    @NamedQuery(name = "Prestation.findByTarif", query = "SELECT p FROM Prestation p WHERE p.tarif = :tarif"),
    @NamedQuery(name = "Prestation.findByIdPrestation", query = "SELECT p FROM Prestation p WHERE p.idPrestation = :idPrestation")})
public class Prestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarif")
    private int tarif;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestation")
    private Integer idPrestation;

    public Prestation() {
    }

    public Prestation(Integer idPrestation) {
        this.idPrestation = idPrestation;
    }

    public Prestation(Integer idPrestation, String type, int tarif) {
        this.idPrestation = idPrestation;
        this.type = type;
        this.tarif = tarif;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public Integer getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(Integer idPrestation) {
        this.idPrestation = idPrestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestation != null ? idPrestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestation)) {
            return false;
        }
        Prestation other = (Prestation) object;
        if ((this.idPrestation == null && other.idPrestation != null) || (this.idPrestation != null && !this.idPrestation.equals(other.idPrestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metier.Prestation[ idPrestation=" + idPrestation + " ]";
    }
    
}
