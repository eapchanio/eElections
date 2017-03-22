package evoting.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import evoting.gui.DiadikasiaEklogis;
import evoting.model.TblCandidate;
import evoting.model.TblElectoralPeriphery;
import evoting.model.TblVote;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class DiaxeirisiApotelesmaton extends javax.swing.JFrame {

    
    private String EklPerifereia;
    public DefaultTableModel tmodel;
    public String name;
    public String surname;
    private DiadikasiaEklogis DiadikasiaEklogis;
    
      
  
    public DiaxeirisiApotelesmaton(DiadikasiaEklogis diadikasiaEklogis) {
        initComponents();
        this.DiadikasiaEklogis = diadikasiaEklogis;
        tmodel = new DefaultTableModel();
    }    
      
    

    public void DrowTableRow()
    {
        Object[] row = new Object[2];
        row[0] = name;
        row[1] = surname;
        tmodel.addRow((Object[])row);
        jTable1.setModel(tmodel);
    
    }
    
    private void DrowTableData(String a)
    {
        int countPsifoi = 0;
        int countPsifoiOK = 0;
        int countLeuka = 0;
        int countAkyra = 0;
        int komma1 = 0, komma2 = 0, komma3 = 0, komma4 = 0, komma5 = 0;
        List<TblVote> listVotes = new ArrayList<TblVote>();
        listVotes.clear();
        Object[] columns = {"KOMMA 1","KOMMA 2","KOMMA 3","KOMMA 4","KOMMA 5","LEYKA", "AKYRA"};

        tmodel.setColumnIdentifiers(columns);
        for (int i = 0; i <  tmodel.getRowCount(); i++) 
        {
            tmodel.removeRow(i);
        }

        TypedQuery<TblElectoralPeriphery> findTblElectoralPeriphery = entityManager1.createNamedQuery("TblElectoralPeriphery.findByFldName", TblElectoralPeriphery.class); 
        findTblElectoralPeriphery.setParameter("fldName", EklPerifereia);
        List<TblElectoralPeriphery> TblElectoralPeripheryResults = findTblElectoralPeriphery.getResultList(); 
        
        TypedQuery<TblCandidate> findTblCandidateQuery = entityManager1.createNamedQuery("TblCandidate.findByPeriphery", TblCandidate.class); 
        findTblCandidateQuery.setParameter("fkElectoralPeripheryId", TblElectoralPeripheryResults.get(0));
        List<TblCandidate> TblCandidateResults = findTblCandidateQuery.getResultList(); 
        
        
        for (int i = 0; i < TblCandidateResults.size(); i++) 
        {
            listVotes = (List<TblVote>)TblCandidateResults.get(i).getTblVoteCollection();
            countPsifoi = countPsifoi + TblCandidateResults.get(i).getTblVoteCollection().size();
            for (int j = 0; j < listVotes.size(); j++) 
            {
                    if(listVotes.get(j).getFldIsBlank() == false && listVotes.get(j).getFldIsInvalid() == false)
                    {
                        countPsifoiOK++;
                    }
                    
                    if (listVotes.get(j).getFkPoliticalPartyId().getPkPartyId() == 1)
                    {
                        komma1++;
                    }
                    else  if (listVotes.get(j).getFkPoliticalPartyId().getPkPartyId() == 2)
                    {
                        komma2++;
                    }
                    
                     else  if (listVotes.get(j).getFkPoliticalPartyId().getPkPartyId() == 3)
                    {
                        komma3++;
                    }
                    
                    else  if (listVotes.get(j).getFkPoliticalPartyId().getPkPartyId() == 4)
                    {
                        komma4++;
                    }
                    
                    else  if (listVotes.get(j).getFkPoliticalPartyId().getPkPartyId() == 5)
                    {
                        komma5++;
                    }
                    
                    
                    if(listVotes.get(j).getFldIsBlank() == true )
                    {
                        countLeuka++;
                    }
                    
                    if(listVotes.get(j).getFldIsInvalid() == true )
                    {
                        countAkyra++;
                    }
            }
            
        }
        
        
        Object[] row = new Object[7];
        
       
            row[0] = countPsifoiOK > 0 ? (komma1/countPsifoiOK)*100 : 0;
            row[1] = countPsifoiOK > 0 ? (komma2/countPsifoiOK)*100 : 0;
            row[2] = countPsifoiOK > 0 ?(komma3/countPsifoiOK)*100 : 0;
            row[3] = countPsifoiOK > 0 ?(komma4/countPsifoiOK)*100 : 0;
            row[4] = countPsifoiOK > 0 ?(komma5/countPsifoiOK)*100 :0;       
            row[5] = countPsifoi > 0 ? (countLeuka/countPsifoi)*100 :0 ;
            row[6] = countPsifoi > 0 ? (countAkyra/countPsifoi)*100 :0;
            tmodel.addRow((Object[])row);
        
        
         jTable1.setModel(tmodel);
         
         
         
         DefaultPieDataset data = new DefaultPieDataset();
data.setValue("komma1 1", (int)row[0]);
data.setValue("komma 2", (int)row[1]);
data.setValue("komma 3", (int)row[2]);
data.setValue("komma 4", (int)row[3]);
data.setValue("komma 5", (int)row[4]);
data.setValue("Leuka", (int)row[5]);
data.setValue("Akyra", (int)row[6]);
 //create a chart
JFreeChart chart = ChartFactory.createPieChart(
TblElectoralPeripheryResults.get(0).getFldName(),
data,
true, // legend?
true, // tooltips?
false // URLs?
);
 //create and display a frame
ChartFrame frame = new ChartFrame(TblElectoralPeripheryResults.get(0).getFldName(), chart);
frame.pack();
frame.setVisible(true);
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("EVotingPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Διαχείριση Αποτελεσμάτων");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ΠΡΟΣΟΜΟΙΩΣΗ ΑΠΟΤΕΛΕΣΜΑΤΩΝ ΑΝΑ ΕΚΛΟΓΙΚΗ ΠΕΡΙΦΕΡΕΙΑ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Εκλογική περιφέρεια");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Α_ΑΘΗΝΩΝ", "Β_ΑΘΗΝΩΝ", "ΝΟΜΟΥ_ΑΤΤΙΚΗΣ", "Α_ΠΕΙΡΑΙΩΣ", "Β_ΠΕΙΡΑΙΩΣ", "ΝΟΜΟΥ_ΑΙΤΩΛΟΑΚΑΡΝΑΝΙΑΣ", "ΝΟΜΟΥ_ΑΡΓΟΛΙΔΟΣ", "ΝΟΜΟΥ_ΑΡΚΑΔΙΑΣ", "ΝΟΜΟΥ_ΑΡΤΗΣ", "ΝΟΜΟΥ_ΑΧΑΪΑΣ", "ΝΟΜΟΥ_ΒΟΙΩΤΙΑΣ", "ΝΟΜΟΥ_ΓΡΕΒΕΝΩΝ", "ΝΟΜΟΥ_ΔΡΑΜΑΣ", "ΝΟΜΟΥ_ΔΩΔΕΚΑΝΗΣΟΥ", "ΝΟΜΟΥ_ΕΒΡΟΥ", "ΝΟΜΟΥ_ΕΥΒΟΙΑΣ", "ΝΟΜΟΥ_ΕΥΡΥΤΑΝΙΑΣ", "ΝΟΜΟΥ_ΖΑΚΥΝΘΟΥ", "ΝΟΜΟΥ_ΗΛΕΙΑΣ", "ΝΟΜΟΥ_ΗΜΑΘΙΑΣ", "ΝΟΜΟΥ_ΗΡΑΚΛΕΙΟΥ", "ΝΟΜΟΥ_ΘΕΣΠΡΩΤΙΑΣ", "Α_ΘΕΣΣΑΛΟΝΙΚΗΣ", "Β_ΘΕΣΣΑΛΟΝΙΚΗΣ", "ΝΟΜΟΥ_ΙΩΑΝΝΙΝΩΝ", "ΝΟΜΟΥ_ΚΑΒΑΛΑΣ", "ΝΟΜΟΥ_ΚΑΡΔΙΤΣΗΣ", "ΝΟΜΟΥ_ΚΑΣΤΟΡΙΑΣ", "ΝΟΜΟΥ_ΚΕΡΚΥΡΑΣ", "ΝΟΜΟΥ_ΚΕΦΑΛΛΗΝΙΑΣ", "ΝΟΜΟΥ_ΚΙΛΚΙΣ", "ΝΟΜΟΥ_ΚΟΖΑΝΗΣ ", "ΝΟΜΟΥ_ΚΟΡΙΝΘΙΑΣ ", "ΝΟΜΟΥ_ΚΥΚΛΑΔΩΝ ", "ΝΟΜΟΥ_ΛΑΚΩΝΙΑΣ", "ΝΟΜΟΥ_ΛΑΡΙΣΗΣ ", "ΝΟΜΟΥ_ΛΑΣΙΘΙΟΥ ", "ΝΟΜΟΥ_ΛΕΣΒΟΥ", "ΝΟΜΟΥ_ΛΕΥΚΑΔΟΣ ", "ΝΟΜΟΥ_ΜΑΓΝΗΣΙΑΣ ", "ΝΟΜΟΥ_ΜΕΣΣΗΝΙΑΣ", "ΝΟΜΟΥ_ΞΑΝΘΗΣ ", "ΝΟΜΟΥ_ΠΕΛΛΗΣ", "ΝΟΜΟΥ_ΠΙΕΡΙΑΣ", "ΝΟΜΟΥ_ΠΡΕΒΕΖΗΣ ", "ΝΟΜΟΥ_ΡΕΘΥΜΝΗΣ ", "ΝΟΜΟΥ_ΡΟΔΟΠΗΣ", "ΝΟΜΟΥ_ΣΑΜΟΥ", "ΝΟΜΟΥ_ΣΕΡΡΩΝ ", "ΝΟΜΟΥ_ΤΡΙΚΑΛΩΝ", "ΝΟΜΟΥ_ΦΘΙΩΤΙΔΟΣ ", "ΝΟΜΟΥ_ΦΛΩΡΙΝΗΣ ", "ΝΟΜΟΥ_ΦΩΚΙΔΟΣ", "ΝΟΜΟΥ_ΧΑΛΚΙΔΙΚΗΣ ", "ΝΟΜΟΥ_ΧΑΝΙΩΝ", "ΝΟΜΟΥ_ΧΙΟΥ" }));
        jComboBox1.setAutoscrolls(true);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/28.png"))); // NOI18N
        jButton1.setText("ΕΠΙΣΤΡΟΦΗ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
               
       EklPerifereia = (String) jComboBox1.getSelectedItem();
        DrowTableData(EklPerifereia);
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.DiadikasiaEklogis.setEnabled(true);
    dispose();       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
