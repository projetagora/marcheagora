/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controler;

import com.dao.DAOClient;
import com.dao.DAODevis;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dao.DAOPrestation;
import com.dto.DTOClient;
import com.dto.DTOPrestation;
import com.dto.DTODevisClient;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author israe
 */

@ManagedBean
@SessionScoped

public class DevisControler {
    
    private DAOPrestation daoPrestation;
    private DTOPrestation dtoPrestation;
    private DTODevisClient dtoDevisClient = new DTODevisClient();
    private List<DTOPrestation> listPrestations = new ArrayList<DTOPrestation>();
    private String selectedPrestation;
    private List<SelectItem> options = new ArrayList<SelectItem>();
    
    public DevisControler(){
        //Récuperation de la liste des prestation depuis la base de données
        
        daoPrestation = new DAOPrestation();
        
        listPrestations = daoPrestation.getlistePrestations();
        
        //Initialisation de la liste déroulante
        for (Iterator<DTOPrestation> iterator = listPrestations.iterator(); iterator.hasNext();) {
            DTOPrestation next = iterator.next();
            
            this.options.add(new SelectItem(next.getID(),next.getType()));
        }
        
        
    }
     
     public String ajoutDevis(){         
        
        //Création du client
        
        DAOClient daoClient = new DAOClient();
        
        DTOClient dtoClient = new DTOClient();
        dtoClient.setNom(this.dtoDevisClient.getNom());
        dtoClient.setPrenom(this.dtoDevisClient.getPrenom());
        dtoClient.seteMail(this.dtoDevisClient.getMail());
        dtoClient.setNumero(this.dtoDevisClient.getNumero());
        dtoClient.setTelephone(this.dtoDevisClient.getTelephone());
        dtoClient.setRue(this.dtoDevisClient.getRue());
        dtoClient.setCodePostal(this.dtoDevisClient.getCodePostal());
        dtoClient.setVille(this.dtoDevisClient.getVille());
        dtoClient.setPays(this.dtoDevisClient.getPays());
        
        int IDClient = daoClient.insertClient(dtoClient);
        
        //Creation du devis
        DAODevis daoDevis = new DAODevis();
        this.dtoDevisClient.setTypePrestation(this.selectedPrestation);
        daoDevis.insertDevis(this.dtoDevisClient, IDClient);
        
                
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Ajout réussi",
                            null));
        return "index";
   
   
   }

    public List<DTOPrestation> getListPrestations() {
        return listPrestations;
    }

    public void setListPrestations(List<DTOPrestation> listPrestations) {
        this.listPrestations = listPrestations;
    }

    public String getSelectedPrestation() {
        return selectedPrestation;
    }

    public void setSelectedPrestation(String selectedPrestation) {
        this.selectedPrestation = selectedPrestation;
    }

    public DAOPrestation getDaoPrestation() {
        return daoPrestation;
    }

    public void setDaoPrestation(DAOPrestation daoPrestation) {
        this.daoPrestation = daoPrestation;
    }

    public DTOPrestation getDtoPrestation() {
        return dtoPrestation;
    }

    public void setDtoPrestation(DTOPrestation dtoPrestation) {
        this.dtoPrestation = dtoPrestation;
    }

    public DTODevisClient getDtoDevisClient() {
        return dtoDevisClient;
    }

    public void setDtoDevisClient(DTODevisClient dtoDevisClient) {
        this.dtoDevisClient = dtoDevisClient;
    }

    public List<SelectItem> getOptions() {
        return options;
    }

    public void setOptions(List<SelectItem> options) {
        this.options = options;
    }
    
    
   
    
}
