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
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 *
 */
public class EVoting {
    private static EntityManager em;   
    
    public static void main(String[] args) {
        //στο αρχείο persistence.xml υπάρχει η εγγραφή <persistence-unit name="EVotingPU" transaction-type="RESOURCE_LOCAL">
        //περνάμε την τιμή της ιδιότητας name σαν παράμετρο στη
        //μέθοδο createEntityManagerFactory 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EVotingPU");
        // Δημιουργία του Entity Manager
        em = emf.createEntityManager();                 
        
        VotingReporting votingReporting = new VotingReporting(em);
        //Καθαρισμός Βάσης Δεδομένων
        votingReporting.clearDB();
        
        em.getTransaction().begin();
        
    }
    
}
