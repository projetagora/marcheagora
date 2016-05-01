package com.controler;



import com.dao.DAOUtilisateur;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class AuthentificationControler implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String identifiant;
    private String motDePasse;
    private int IDUtilisateur;

    
    public String connexion(){        
        //DAOUtilisateur daoUtilisateur = new DAOUtilisateur();
        //daoUtilisateur.getListUtilisateurs();
        return "connexion";
    }    
    
    public String demandeDevis(){        
        //DAOUtilisateur daoUtilisateur = new DAOUtilisateur();
        //daoUtilisateur.getListUtilisateurs();
        return "clientDevis";
    }
    
    
     public String verification() {     
         DAOUtilisateur daoUtilisateur = new DAOUtilisateur();
         int IDUtilisateur = daoUtilisateur.verifIdentifiantMdp(identifiant, motDePasse);
            if (IDUtilisateur == -1) {            
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Erreur d'authentification: Identifiant ou mot de passe incorrecte",
                            null));
                return "connexion";
            }       
         else
          {
              HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
              session.setAttribute("IDUtilisateur", IDUtilisateur);
          
              if (daoUtilisateur.getRole(IDUtilisateur) == 1)
              {                   
                   return "accueiladmin";
              }              
              else if (daoUtilisateur.getRole(IDUtilisateur) == 2){
                  return "accueilTechnique"; 
              }                            
              else{
                 return "accueilOuvrier";
          }
    }
}
    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
              
        
        session.invalidate();
        return "connexion";
    }
    
         /*
    public String verification(){
        
    DAOUtilisateur daoUtilisateur = new DAOUtilisateur();
    boolean verif = daoUtilisateur.verifIdentifiantMdp(identifiant, motDePasse);
    if (identifiant.equals("daoUtilisateur") && motDePasse.equals("daoUtilisateur")) {
        verif=true;
        return "index";
    } else {
        verif=false;
        return "connexion";
    }
}  */
    public String prestation(){
        
        return "prestation";
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

    public int getIDUtilisateur() {
        return IDUtilisateur;
    }

    public void setIDUtilisateur(int IDUtilisateur) {
        this.IDUtilisateur = IDUtilisateur;
    }
  
}
