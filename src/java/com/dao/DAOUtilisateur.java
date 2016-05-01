/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dto.DTOUtilisateur;
import com.metier.Utilisateur;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author israe
 */
public class DAOUtilisateur implements java.io.Serializable {
    
    private static SessionFactory factory; 
    
    public DAOUtilisateur(){
        try{
         factory = new AnnotationConfiguration().
                   configure().
                   addAnnotatedClass(Utilisateur.class).
                   buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
    }
    
    public void getListUtilisateurs()
    {
        Session session = factory.openSession();
      Transaction tx = null;
      
      try{
         tx = session.beginTransaction();
         
         List utilisateurs = session.getNamedQuery("Utilisateur.findAll").list(); 

         for (Iterator iterator = 
                           utilisateurs.iterator(); iterator.hasNext();){
            Utilisateur utilisateur = (Utilisateur) iterator.next(); 
            
            System.out.print("Nom: " + utilisateur.getNom()); 
            System.out.print("Prenom: " + utilisateur.getPrenom()); 
            System.out.println("Ville: " + utilisateur.getVille()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
    }
    
    
    public int verifIdentifiantMdp(String identifiant, String motdepasse)
    {
        Session session = factory.openSession();
      Transaction tx = null;
      
      Utilisateur utilisateur = null;
      
      try{
         tx = session.beginTransaction();
        
         Object result = session.getNamedQuery("Utilisateur.findByIdentifiantMotdepasse")
                 .setParameter("identifiant", identifiant)
                 .setParameter("motDePasse", motdepasse).uniqueResult();
         
         utilisateur = (Utilisateur) result;
         
         tx.commit();
         
         if (utilisateur != null)
             return utilisateur.getIdUtilisateur();
         else
             return -1;
         
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();  
      }
      finally {
         session.close(); 
      }
      return -1;
    }
    
    public int getRole(int IDUtilisateur)
    {
        Session session = factory.openSession();
      Transaction tx = null;
      
      Utilisateur utilisateur = null;
      
      try{
         tx = session.beginTransaction();
        
         Object result = session.getNamedQuery("Utilisateur.findByIdUtilisateur")
                 .setParameter("idUtilisateur", IDUtilisateur).uniqueResult();
         
         utilisateur = (Utilisateur) result;
         
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();  
      }
      finally {
         session.close(); 
      }
       return utilisateur.getRole();
    }
    
    public DTOUtilisateur getDTOUtilisateur(int IDUtilisateur){
        Session session = factory.openSession();
      Transaction tx = null;
      
      Utilisateur utilisateur = null;
      DTOUtilisateur dtoUtilisateur = null;
      try{
         tx = session.beginTransaction();
        
         Object result = session.getNamedQuery("Utilisateur.findByIdUtilisateur")
                 .setParameter("idUtilisateur", IDUtilisateur).uniqueResult();
         
         utilisateur = (Utilisateur) result;
         
         dtoUtilisateur = new DTOUtilisateur();
         dtoUtilisateur.setID(utilisateur.getIdUtilisateur());
         dtoUtilisateur.setNom(utilisateur.getNom());
         dtoUtilisateur.setPrenom(utilisateur.getPrenom());
         dtoUtilisateur.setRue(utilisateur.getRue());
         dtoUtilisateur.setCodePostale(utilisateur.getCodePostal());
         dtoUtilisateur.setVille(utilisateur.getVille());
         dtoUtilisateur.setPays(utilisateur.getPays());
         
         
         
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();  
      }
      finally {
         session.close(); 
      }
       return dtoUtilisateur;
    }
    
    
    public void updateOuvrier(DTOUtilisateur dtoutilisateur){
        Session session = factory.openSession();
      Transaction tx = null;
            Utilisateur utilisateur = null;
      try{
         tx = session.beginTransaction();
         Object result = session.getNamedQuery("Utilisateur.findByIdUtilisateur")
                 .setParameter("idUtilisateur", dtoutilisateur.getID()).uniqueResult();
         
         utilisateur = (Utilisateur) result;
         
         utilisateur.setNom(dtoutilisateur.getNom());
         utilisateur.setPrenom(dtoutilisateur.getPrenom());
         utilisateur.setRue(dtoutilisateur.getRue());
         utilisateur.setCodePostal(dtoutilisateur.getCodePostale());
         utilisateur.setVille(dtoutilisateur.getVille());
         utilisateur.setPays(dtoutilisateur.getPays());
         
         //Mise à jour des données utilisateur dans la base de données
         session.update(utilisateur);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();  
      }
      finally {
         session.close(); 
      }
    }
    
    
}
