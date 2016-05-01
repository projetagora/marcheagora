
package com.controler;

import com.dao.DAOUtilisateur;
import com.dto.DTOUtilisateur;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class AdminControler implements Serializable{
    
    private static final long serialVersionUID = 2L;
    
    private DTOUtilisateur dtoUtilisateur;
    
    public String goAccueil(){
        return "accueiladmin";
    }
    
     public String goAmin(){
        return "devisadmin";
    }
    
    public String goInfosPerso (){
    
      
        
        return "infosPersoOuvrier";
    }
    

    
    
    
}
