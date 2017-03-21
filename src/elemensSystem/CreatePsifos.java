/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemensSystem;

import evoting.gui.DiadikasiaEklogis;
import evoting.model.TblCandidate;
import evoting.model.TblElectoralPeriphery;
import evoting.model.TblVote;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.SwingWorker;


public class CreatePsifos extends SwingWorker<Void, TblElectoralPeriphery> {

private volatile TblElectoralPeriphery ep;
private volatile DiadikasiaEklogis ed;
private volatile boolean stop = false;   // για το προσωρινό σταμάτημα
private volatile boolean terminated = false;    // Ένδειξη ότι έχει ολοκληρωθεί η doInBackground
private double NoApoxi = 0;
private double Leuko = 0;
private double Akyro = 0;
private final EntityManager entityManager1;  
    
    // Δημιουργούμε ένα αντικείμενο απλά για πρόσβαση στο intrinsic lock
    // Δεν επιτρέπουμε:
    // 1. Να υποβάλλονται αιτήματα όσο κάποιος προϊστάμενος αξιολογεί
    // 2. Να υποβάλλουν αιτήματα δύο υπάλληλοι συγχρόνως
    //public static volatile Object LOCK = new Object();
    
    // Contructor - takes an Employee object
    public CreatePsifos(TblElectoralPeriphery ep, DiadikasiaEklogis ed, EntityManager entityManager1) {
        
        this.entityManager1 = entityManager1;
        this.ep = ep;
        this.ed = ed;
     //   this.setNoApoxi(ed.getNoApoxi());
     //   this.setLeuko(ed.getLeuko());
     //   this.setAkyro(ed.getAkyro());
      
    }
    
       
    public void  setNoApoxi(double Noapoxi)
    {
         this.NoApoxi = Noapoxi;
    }
    
    public void setLeuko(double leuko)
    {
        this.Leuko = leuko;
    }
    
    
    public void setAkyro(double akyro)
    {
        this.Akyro = akyro;
    }
    
    public double getNoApoxi()
    {
        return NoApoxi;
    }
    
    public double getLeuko()
    {
        return Leuko;
    }
    
    
    public double getAkyro()
    {
        return Akyro;
    }
    
    public static  int getRandomInt(int min, int max) {

        Random rn = new Random();
        int range = max - min + 1;

        return rn.nextInt(range) + min;

    }
    
   
    @Override
    protected Void doInBackground() throws Exception {
        
        // flag ένδειξης τερματισμού του thread
        boolean terminate = false; 
        // infinite loop 
        while (true) {
            
            // block until this.stop = false
            while(this.stop) {}
            
            synchronized(ThreadControl.LOCK) {
                
                TypedQuery<TblVote> findTblVote = entityManager1.createNamedQuery("TblVote.findAll", TblVote.class);
                List<TblVote> TblVoteResults = findTblVote.getResultList(); 

                   //remove votes
                for (int i = 0; i < TblVoteResults.size(); i++) 
                {

                   try {
                       entityManager1.getTransaction().begin();
                       entityManager1.remove(TblVoteResults.get(i));
                       entityManager1.getTransaction().commit();
                   } catch (Exception e) {
                       entityManager1.getTransaction().rollback();
                   }
                }
        
               
                 entityManager1.getTransaction().begin();
                 TypedQuery<TblCandidate> findTblCandidate = entityManager1.createNamedQuery("TblCandidate.findAllByPeriphery", TblCandidate.class);
                 findTblCandidate.setParameter("fkElectoralPeripheryId", ep);
                 List<TblCandidate> TblCandidateResults = findTblCandidate.getResultList(); 
                
                            for (int i = 0; i < TblCandidateResults.size(); i++) 
                            {
                                if (this.getNoApoxi() > 0.20)
                                {    
                                    Long myLong = new Long(i+1);
                                    TblVote vote = new TblVote(myLong);
                                    int invalid = getRandomInt(0,1);
                                    if (invalid == 0)
                                        vote.setFldIsInvalid(false);
                                    else
                                        vote.setFldIsInvalid(true);
                                    if (invalid == 0)
                                    {    
                                        int blank = getRandomInt(0,1);
                                        if (blank == 0)
                                            vote.setFldIsBlank(false);
                                         else
                                            vote.setFldIsBlank(true);
                                    }
                                    else
                                    {
                                         vote.setFldIsBlank(false);
                                    }
                                    int k = getRandomInt(0,TblCandidateResults.size()-1);
                                    vote.setFkPoliticalPartyId(TblCandidateResults.get(k).getFkPoliticalPartyId());
                                    vote.setFkCandidateId(TblCandidateResults.get(k));
                                    vote.setFkElectoralPeripheryId(ep);
                                    TblCandidateResults.get(i).getTblVoteCollection().add(vote);
                                    entityManager1.persist(vote);                                  
                                }
                            }
                     if (terminate) return null;
                    entityManager1.getTransaction().commit();
                     //em.close( );
                }   
            // Β. Αναμονή 10-30 sec (sleep)
            int sleepDuration = getRandomInt(10, 30);
            try {
                Thread.sleep(sleepDuration * 1000);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(ThreadPsifos.class.getName()).log(Level.SEVERE, null, ex);
            }          
       }
    }

    //@Override
    protected void done() {
        this.terminated = true;
        this.stop = true;    
    }
    
    // stop doInBackground excecution
    public void stop() {
        if (!this.stop) {
            this.stop = true;
        }
        
    }

    public void setTblElectoralPeriphery(TblElectoralPeriphery ep) {
        this.ep = ep;
    }

 
    public void resume() {
        if (this.stop) {
            this.stop = false;
        }
        
    }

    public TblElectoralPeriphery getTblElectoralPeriphery() {
        return this.ep;
    }
    public boolean isTerminated() {
        return this.terminated;
    }
    
}
