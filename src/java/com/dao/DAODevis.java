/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dto.DTODevisClient;
import com.metier.Devis;
import com.metier.Client;
import com.metier.Utilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author israe
 */
public class DAODevis {
    
    private static SessionFactory factory; 
    
        public DAODevis(){
        try{
         factory = new AnnotationConfiguration().
                   configure().
                   addAnnotatedClass(Devis.class).
                   buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
    }
    
  public void insertDevis(DTODevisClient dtoDevisclient, int IDClient){
        
      Session session = factory.openSession();
      Transaction tx = null;
      
       //Conversion texte en format Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
        date = formatter.parse(dtoDevisclient.getDate());
        }catch (ParseException e) {
		e.printStackTrace();
	}
        //Fin conversion
     
      Devis devis = new Devis();
      devis.setDate(date);
      devis.setIdClient(0);
      devis.setIdPrestation(Integer.valueOf(dtoDevisclient.getTypePrestation()));
      devis.setIdUtilisateur(0);
      
      try{
         tx = session.beginTransaction();
         
         session.save(devis);
         
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
