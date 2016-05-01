/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;
import com.metier.Prestation;
import com.dto.DTOPrestation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 *
 * @author israe
 */
public class DAOPrestation {
    
    private List<DTOPrestation> listPrestation = new ArrayList<DTOPrestation>();
    
    private static SessionFactory factory; 
    
     public DAOPrestation(){
        try{
         factory = new AnnotationConfiguration().
                   configure().
                   addAnnotatedClass(Prestation.class).
                   buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
    }
    
 
    public List<DTOPrestation> getlistePrestations (){
        
      Session session = factory.openSession();
      Transaction tx = null;
      
      try{
         tx = session.beginTransaction();
         
         List prestations = session.getNamedQuery("Prestation.findAll").list();

         for (Iterator iterator = 
                           prestations.iterator(); iterator.hasNext();){
            Prestation prestation = (Prestation) iterator.next(); 
            
            DTOPrestation dtoPrestation = new DTOPrestation(prestation.getIdPrestation(), prestation.getType(), prestation.getTarif());
            
            listPrestation.add(dtoPrestation);
            
            System.out.print("Type : " + prestation.getType()); 
            System.out.print("Tarif : " + prestation.getTarif()); 
 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return listPrestation;
    } 
}


