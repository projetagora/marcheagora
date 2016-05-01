/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metier;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author israe
 */
@Entity
@Table(name = "devis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devis.findAll", query = "SELECT d FROM Devis d"),
    @NamedQuery(name = "Devis.findByIdPrestation", query = "SELECT d FROM Devis d WHERE d.idPrestation = :idPrestation"),
    @NamedQuery(name = "Devis.findByIdClient", query = "SELECT d FROM Devis d WHERE d.idClient = :idClient"),
    @NamedQuery(name = "Devis.findByIdUtilisateur", query = "SELECT d FROM Devis d WHERE d.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Devis.findByDate", query = "SELECT d FROM Devis d WHERE d.date = :date"),
    @NamedQuery(name = "Devis.findByIdDevis", query = "SELECT d FROM Devis d WHERE d.idDevis = :idDevis")})
public class Devis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prestation")
    private int idPrestation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private int idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utilisateur")
    private int idUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_devis")
    private Integer idDevis;

    public Devis() {
    }

    public Devis(Integer idDevis) {
        this.idDevis = idDevis;
    }

    public Devis(Integer idDevis, int idPrestation, int idClient, int idUtilisateur, Date date) {
        this.idDevis = idDevis;
        this.idPrestation = idPrestation;
        this.idClient = idClient;
        this.idUtilisateur = idUtilisateur;
        this.date = date;
    }

    public int getIdPrestation() {
        return idPrestation;
    }

    public void setIdPrestation(int idPrestation) {
        this.idPrestation = idPrestation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdDevis() {
        return idDevis;
    }

    public void setIdDevis(Integer idDevis) {
        this.idDevis = idDevis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevis != null ? idDevis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devis)) {
            return false;
        }
        Devis other = (Devis) object;
        if ((this.idDevis == null && other.idDevis != null) || (this.idDevis != null && !this.idDevis.equals(other.idDevis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.metier.Devis[ idDevis=" + idDevis + " ]";
    }
    
}
