/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting;

import evoting.model.TblCandidate;
import evoting.model.TblElectoralPeriphery;
import evoting.model.TblPoliticalParty;
import evoting.model.TblVote;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * 
 */
public class VotingReporting {
    private final EntityManager em;
    
    public VotingReporting(EntityManager em){
        this.em = em;
    }
       
    /**
     * Άδειασμα των πινάκων της ΒΔ
     */
    public void clearDB(){        
        em.getTransaction().begin();
        try {
             //διαγράφουμε τα δεδομένα των πινάκων
            Query q=em.createQuery("DELETE FROM TblVote");
            q.executeUpdate();                        
            q=em.createQuery("DELETE FROM TblCandidate");
            q.executeUpdate();            
            q=em.createQuery("DELETE FROM TblPoliticalParty");
            q.executeUpdate();                                    
            q=em.createQuery("DELETE FROM TblElectoralPeriphery");
            q.executeUpdate();         
             //επαναλαμβάνουμε όσες εντολές χρειάζονται για τη διαγραφή των πινάκων
            //η διαγραφή πρέπει να γίνει με κατάλληλη σειρά για να μην παραβιάζονται
            //τα foreign key constraints                               
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception while clearing the DB - rolling back transaction");
            em.getTransaction().rollback();            
        } 
    }
    
   
}
