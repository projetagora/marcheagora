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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByIdentifiant", query = "SELECT u FROM Utilisateur u WHERE u.identifiant = :identifiant"),
    @NamedQuery(name = "Utilisateur.findByMotDePasse", query = "SELECT u FROM Utilisateur u WHERE u.motDePasse = :motDePasse"),
    @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateur.findByRole", query = "SELECT u FROM Utilisateur u WHERE u.role = :role"),
    @NamedQuery(name = "Utilisateur.findByRue", query = "SELECT u FROM Utilisateur u WHERE u.rue = :rue"),
    @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville"),
    @NamedQuery(name = "Utilisateur.findByCodePostal", query = "SELECT u FROM Utilisateur u WHERE u.codePostal = :codePostal"),
    @NamedQuery(name = "Utilisateur.findByPays", query = "SELECT u FROM Utilisateur u WHERE u.pays = :pays"),
    @NamedQuery(name = "Utilisateur.findByIdentifiantMotdepasse", query = "SELECT u FROM Utilisateur u WHERE u.identifiant = :identifiant AND u.motDePasse = :motDePasse")
})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "identifiant")
    private String identifiant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private int role;
    @Column(name = "rue")
    private Integer rue;
    @Size(max = 20)
    @Column(name = "ville")
    private String ville;
    @Column(name = "code_postal")
    private Integer codePostal;
    @Size(max = 10)
    @Column(name = "pays")
    private String pays;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(Integer idUtilisateur, String identifiant, String motDePasse, String nom, String prenom, int role) {
        this.idUtilisateur = idUtilisateur;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Integer getRue() {
        return rue;
    }

    public void setRue(Integer rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
