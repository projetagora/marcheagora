
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
public class OuvrierControler implements Serializable{
    
    private static final long serialVersionUID = 2L;
    
    private DTOUtilisateur dtoUtilisateur;
    
    public String goAccueil(){
        return "accueilOuvrier";
    }
    
    public String goInfosPerso (){
    
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        int IDUtilisateur = (int) session.getAttribute("IDUtilisateur");
        
        DAOUtilisateur daoUtilisateur = new DAOUtilisateur();
        this.dtoUtilisateur = daoUtilisateur.getDTOUtilisateur(IDUtilisateur);
        
        return "infosPersoOuvrier";
    }
    
    public String modifierInfosPerso(){
        
        DAOUtilisateur daoUtilisateur = new DAOUtilisateur();
        
        daoUtilisateur.updateOuvrier(this.dtoUtilisateur);
        
        FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Modification réussie",
                            null));
        
        return "infosPersoOuvrier";
    }

    public DTOUtilisateur getDtoUtilisateur() {
        return dtoUtilisateur;
    }

    public void setDtoUtilisateur(DTOUtilisateur dtoUtilisateur) {
        this.dtoUtilisateur = dtoUtilisateur;
    }
    
    
    
}
