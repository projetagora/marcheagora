/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dto.DTOClient;
import com.metier.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author israe
 */
public class DAOClient {
    private static SessionFactory factory; 
    
        public DAOClient(){
        try{
         factory = new AnnotationConfiguration().
                   configure().
                   addAnnotatedClass(Client.class).
                   buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
    }
        
      public int insertClient(DTOClient dtoClient){
        
      Session session = factory.openSession();
      Transaction tx = null;
      
      Client client = new Client(dtoClient.getPrenom(), dtoClient.getNom(), dtoClient.geteMail(), dtoClient.getTelephone(), dtoClient.getNumero(), dtoClient.getRue(), dtoClient.getCodePostal(), dtoClient.getVille(), dtoClient.getPays());
      

      
      try{
         tx = session.beginTransaction();
         
         session.save(client);
         
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace();  
      }
      finally {
         session.close(); 
      }
    
  
    return client.getIdClient();
      
    }
}
