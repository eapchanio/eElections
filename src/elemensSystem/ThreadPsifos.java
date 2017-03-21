/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elemensSystem;

import evoting.model.TblElectoralPeriphery;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import evoting.gui.DiadikasiaEklogis;


public class ThreadPsifos extends Thread {
    
private volatile TblElectoralPeriphery ep;
private volatile DiadikasiaEklogis ed;
private final EntityManager entityManager1;  
private volatile boolean stop = false;   // για τον τερματισμό του thread
    
    
    public static final Object LOCK = new Object();
      
    public ThreadPsifos(TblElectoralPeriphery ep, DiadikasiaEklogis ed, EntityManager entityManager1) {
        
        this.entityManager1 = entityManager1;
        this.ep = ep;
        this.ed = ed;      
    }
    
    
    public static  int getRandomInt(int min, int max) {

        Random rn = new Random();
        int range = max - min + 1;

        return rn.nextInt(range) + min;

    }
     

    // Override thread's run method
    @Override
    public void run() {
        
        
        // flag ένδειξης τερματισμού του thread (για προϊσταμένους)
        boolean terminate = false;
        
        // infinite loop (εκτός και αν το stop γίνει true
        while (!stop) { }   // end synchronization - Επιτρέπεται η υποβολή αιτήματων
                // Αν έχει τεθεί το flag terminate (παρακάτω)
                // σε προηγούμενο κύκλο, τερματίζουμε το thread
        if (terminate) return;
            // Β. Αναμονή 10-30 sec (sleep)
        int sleepDuration = getRandomInt(10, 30);
        try 
        {
                Thread.sleep(sleepDuration * 1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(ThreadPsifos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Τερματισμός του thread - θέτουμε το stop = true
    public void terminate() {
        this.stop = true;
    }
}




 
