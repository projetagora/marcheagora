/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

/**
 *
 * @author israe
 */
public class DTOPrestation {
    
    private int ID;
    private String type;
    private int tarif;

    public DTOPrestation(int ID, String type, int tarif) {
        this.ID = ID;
        this.type = type;
        this.tarif = tarif;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
    
    
}
