
package com.controler;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class IndexControler implements Serializable{
    
    private static final long serialVersionUID = 2L;
  
    
    public String goConnexion(){
        return "connexion";
    }
    
     public String goDemandeDevis(){
        return "clientDevis";
    }


    
    
    
}
