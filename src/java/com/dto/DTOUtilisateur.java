
package com.dto;

public class DTOUtilisateur {
    
    private int ID;
    private String nom;
    private String prenom;
    private int rue;
    private int codePostale;
    private String ville;
    private String pays;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getRue() {
        return rue;
    }

    public void setRue(int rue) {
        this.rue = rue;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
    
}
