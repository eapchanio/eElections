package xml;

import elemensSystem.ElectionResults;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import evoting.model.TblCandidate;
import evoting.model.TblElectoralPeriphery;
import evoting.model.TblVote;
import evoting.model.TblPoliticalParty;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.persistence.TypedQuery;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


 public class ApotelesmataXMLManager extends ElectionResults implements XMLExport {
    private File fileName;
    private final EntityManager EntityManager1;   
    
    public ApotelesmataXMLManager(File s,EntityManager EntityManager1)
    {
        fileName= s;
        this.EntityManager1 = EntityManager1;
    }        
    
@Override
 public String toXML()
 {
         
    List<TblVote> listVotes = new ArrayList<TblVote>();
    listVotes.clear();
    String key = null;
    String keyfinal = null;
    ElectionResults resultsOfParties = new ElectionResults();
    ElectionResults candidatesOfParty1 = new ElectionResults();
    ElectionResults candidatesOfParty2 = new ElectionResults();
    ElectionResults candidatesOfParty3 = new ElectionResults();
    ElectionResults candidatesOfParty4 = new ElectionResults();
    ElectionResults candidatesOfParty5 = new ElectionResults();
    ElectionResults district = new ElectionResults();
            
            
    TypedQuery<TblElectoralPeriphery> findTblElectoralPeriphery = EntityManager1.createNamedQuery("TblElectoralPeriphery.findAll", TblElectoralPeriphery.class); 
    List<TblElectoralPeriphery> TblElectoralPeripheryResults = findTblElectoralPeriphery.getResultList(); 
    
    
    key = "<apotelesmata>";
    for (int i = 0; i < TblElectoralPeripheryResults.size(); i++) 
    {      
        TypedQuery<TblCandidate> findTblCandidateQuery = EntityManager1.createNamedQuery("TblCandidate.findAllByPeriphery", TblCandidate.class); 
        findTblCandidateQuery.setParameter("fkElectoralPeripheryId", TblElectoralPeripheryResults.get(i));
        List<TblCandidate> TblCandidateResults = findTblCandidateQuery.getResultList(); 
        key = key + "\n<" + TblElectoralPeripheryResults.get(i).getFldName() + ">\n";
        int k1 = 0, k2 = 0, k3 = 0, k4 = 0, k5 = 0;
        int kk1 = 0, kk2 = 0, kk3 = 0, kk4 = 0, kk5 = 0;
        
        for (int j = 0; j < TblCandidateResults.size(); j++) 
        {            
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 1) k1++;
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 2) k2++;
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 3) k3++;
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 4) k4++;
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 5) k5++;
        }
        
        for (int j = 0; j < TblCandidateResults.size(); j++) 
        {   
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 1)
            {
               if (k1 > 0 && kk1 == 0){key = key + "<" + "KOMMA_1" + ">\n";} kk1++;         
                candidatesOfParty1.put(TblCandidateResults.get(j).getFldSurname(), TblCandidateResults.get(j).getTblVoteCollection().size());
                 key = key + "<" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                    key = key + TblCandidateResults.get(j).getTblVoteCollection().size()+ " , ";
                     key = key + Double.toString(  ((double) TblCandidateResults.get(j).getTblVoteCollection().size()/(double)k1)*100) + "%" + "\n";
                     key = key + "</" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                     if (kk1 == k1){key = key + "</" + "KOMMA_1" + ">\n";}          
            }
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 2)
            {
                if (k2 > 0 && kk2 == 0){key = key + "<" + "KOMMA_2" + ">\n";} kk2++; 
                candidatesOfParty2.put(TblCandidateResults.get(j).getFldSurname(), TblCandidateResults.get(j).getTblVoteCollection().size());
                key = key + "<" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                    key = key + TblCandidateResults.get(j).getTblVoteCollection().size()+ " , ";
                     key = key + Double.toString((double)(TblCandidateResults.get(j).getTblVoteCollection().size()/k2)*100) + "%" + "\n";
                     key = key + "</" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                     if (kk2 == k2){key = key + "</" + "KOMMA_2" + ">\n";}
            }
              if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 3)
            {
                 if (k3 > 0 && kk3 == 0){key = key + "<" + "KOMMA_3" + ">\n";} kk3++; 
                candidatesOfParty3.put(TblCandidateResults.get(j).getFldSurname(), TblCandidateResults.get(j).getTblVoteCollection().size());
                key = key + "<" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                    key = key + TblCandidateResults.get(j).getTblVoteCollection().size()+ " , ";
                     key = key + Double.toString((double)(TblCandidateResults.get(j).getTblVoteCollection().size()/k3)*100) + "%" + "\n";
                     key = key + "</" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                     if (kk3 == k3){key = key + "</" + "KOMMA_3" + ">\n";}
            }
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 4)
            {
                 if (k4 > 0 && kk4 == 0){key = key + "<" + "KOMMA_4" + ">\n";} kk4++; 
                candidatesOfParty4.put(TblCandidateResults.get(j).getFldSurname(), TblCandidateResults.get(j).getTblVoteCollection().size());
                key = key + "<" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                    key = key + TblCandidateResults.get(j).getTblVoteCollection().size()+ " , ";
                     key = key + Double.toString((double)(TblCandidateResults.get(j).getTblVoteCollection().size()/k4)*100) + "%" + "\n";
                     key = key + "</" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                     if (kk4 == k4){key = key + "</" + "KOMMA_4" + ">\n";}
            }
            if (TblCandidateResults.get(j).getFkPoliticalPartyId().getPkPartyId() == 5)
            {
                 if (k5 > 0 && kk5 == 0){key = key + "<" + "KOMMA_5" + ">\n";} kk5++; 
                candidatesOfParty5.put(TblCandidateResults.get(j).getFldSurname(), TblCandidateResults.get(j).getTblVoteCollection().size());
                key = key + "<" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                    key = key + TblCandidateResults.get(j).getTblVoteCollection().size()+ " , ";
                     key = key + Double.toString((double)(TblCandidateResults.get(j).getTblVoteCollection().size()/k5)*100) + "%" + "\n";
                     key = key + "</" + TblCandidateResults.get(j).getFldSurname() + ">\n";
                     if (kk5 == k5){key = key + "</" + "KOMMA_5" + ">\n";}
            } 
        }
        
        resultsOfParties.put("KOMMA_5", candidatesOfParty5 );
        resultsOfParties.put("KOMMA_4", candidatesOfParty4 );
        resultsOfParties.put("KOMMA_3", candidatesOfParty3 );
        resultsOfParties.put("KOMMA_2", candidatesOfParty2 );
        resultsOfParties.put("KOMMA_1", candidatesOfParty1 );
        
        district.put(TblElectoralPeripheryResults.get(i).getFldName(), resultsOfParties); 
        
        key = key + "</" + TblElectoralPeripheryResults.get(i).getFldName() + ">\n";
    }  
    
    key = key + "</apotelesmata>";        
         try { 
             writeFile(key, fileName);
         } catch (IOException ex) {
             Logger.getLogger(ApotelesmataXMLManager.class.getName()).log(Level.SEVERE, null, ex);
         }
        return key;
     }
     
        
     
    public void writeFile(String yourXML, File fileName) throws IOException{
    BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
    try { 
        out.write(yourXML);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        out.close();
    }
}
}

