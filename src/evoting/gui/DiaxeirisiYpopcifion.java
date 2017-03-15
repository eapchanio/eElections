/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.gui;

import javax.persistence.EntityManager;

/**
 *
 * @author Administrator
 */
public class DiaxeirisiYpopcifion extends javax.swing.JFrame {
    private MainMenu mainMenu;  
    private String EklogikiPerifereia;
   
    /**
     * Creates new form DiaxeirisiYpopcifion
     */
    public DiaxeirisiYpopcifion(MainMenu mainMenu) {
        initComponents();
        this.mainMenu = mainMenu;
        this.entityManager1.getTransaction().begin();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("EVotingPU").createEntityManager();
        tblCandidateQuery = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("SELECT t FROM TblCandidate t");
        tblCandidateList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(tblCandidateQuery.getResultList());
        tblCandidate1 = new evoting.model.TblCandidate();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Διαχείριση υποψηφίων");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Εκλογική περιφέρεια");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Κόμμα");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/go-back_32.png"))); // NOI18N
        jButton1.setText("ΕΠΙΣΤΡΟΦΗ ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTable1.setName(""); // NOI18N
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCandidateList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fldSurname}"));
        columnBinding.setColumnName("ΕΠΙΘΕΤΟ");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fldName}"));
        columnBinding.setColumnName("ΟΝΟΜΑ");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Υποψήφιοι Κόμματος Επιλεγμένης Εκλογικής Περιφέρειας");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Α_ΑΘΗΝΩΝ", "Β_ΑΘΗΝΩΝ", "ΝΟΜΟΥ_ΑΤΤΙΚΗΣ", "Α_ΠΕΙΡΑΙΩΣ", "Β_ΠΕΙΡΑΙΩΣ", "ΝΟΜΟΥ ΑΙΤΩΛΟΑΚΑΡΝΑΝΙΑΣ", "ΝΟΜΟΥ ΑΡΓΟΛΙΔΟΣ", "ΝΟΜΟΥ ΑΡΚΑΔΙΑΣ", "ΝΟΜΟΥ ΑΡΤΗΣ", "ΝΟΜΟΥ ΑΧΑΪΑΣ", "ΝΟΜΟΥ ΒΟΙΩΤΙΑΣ", "ΝΟΜΟΥ_ΓΡΕΒΕΝΩΝ", "ΝΟΜΟΥ_ΔΡΑΜΑΣ", "ΝΟΜΟΥ_ΔΩΔΕΚΑΝΗΣΟΥ", "ΝΟΜΟΥ_ΕΒΡΟΥ", "ΝΟΜΟΥ_ΕΥΒΟΙΑΣ", "ΝΟΜΟΥ_ΕΥΡΥΤΑΝΙΑΣ", "ΝΟΜΟΥ_ΖΑΚΥΝΘΟΥ", "ΝΟΜΟΥ_ΗΛΕΙΑΣ", "ΝΟΜΟΥ_ΗΜΑΘΙΑΣ", "ΝΟΜΟΥ_ΗΡΑΚΛΕΙΟΥ", "ΝΟΜΟΥ_ΘΕΣΠΡΩΤΙΑΣ", "Α_ΘΕΣΣΑΛΟΝΙΚΗΣ", "Β_ΘΕΣΣΑΛΟΝΙΚΗΣ", "ΝΟΜΟΥ_ΙΩΑΝΝΙΝΩΝ", "ΝΟΜΟΥ_ΚΑΒΑΛΑΣ", "ΝΟΜΟΥ_ΚΑΡΔΙΤΣΗΣ", "ΝΟΜΟΥ_ΚΑΣΤΟΡΙΑΣ", "ΝΟΜΟΥ_ΚΕΡΚΥΡΑΣ", "ΝΟΜΟΥ_ΚΕΦΑΛΛΗΝΙΑΣ", "ΝΟΜΟΥ_ΚΙΛΚΙΣ", "ΝΟΜΟΥ_ΚΟΖΑΝΗΣ ", "ΝΟΜΟΥ_ΚΟΡΙΝΘΙΑΣ ", "ΝΟΜΟΥ_ΚΥΚΛΑΔΩΝ ", "ΝΟΜΟΥ_ΛΑΚΩΝΙΑΣ", "ΝΟΜΟΥ_ΛΑΡΙΣΗΣ ", "ΝΟΜΟΥ_ΛΑΣΙΘΙΟΥ ", "ΝΟΜΟΥ_ΛΕΣΒΟΥ", "ΝΟΜΟΥ_ΛΕΥΚΑΔΟΣ ", "ΝΟΜΟΥ_ΜΑΓΝΗΣΙΑΣ ", "ΝΟΜΟΥ_ΜΕΣΣΗΝΙΑΣ", "ΝΟΜΟΥ_ΞΑΝΘΗΣ ", "ΝΟΜΟΥ_ΠΕΛΛΗΣ", "ΝΟΜΟΥ_ΠΙΕΡΙΑΣ", "ΝΟΜΟΥ_ΠΡΕΒΕΖΗΣ ", "ΝΟΜΟΥ_ΡΕΘΥΜΝΗΣ ", "ΝΟΜΟΥ_ΡΟΔΟΠΗΣ", "ΝΟΜΟΥ_ΣΑΜΟΥ", "ΝΟΜΟΥ_ΣΕΡΡΩΝ ", "ΝΟΜΟΥ_ΤΡΙΚΑΛΩΝ", "ΝΟΜΟΥ_ΦΘΙΩΤΙΔΟΣ ", "ΝΟΜΟΥ_ΦΛΩΡΙΝΗΣ ", "ΝΟΜΟΥ_ΦΩΚΙΔΟΣ", "ΝΟΜΟΥ_ ΧΑΛΚΙΔΙΚΗΣ ", "ΝΟΜΟΥ_ΧΑΝΙΩΝ", "ΝΟΜΟΥ_ΧΙΟΥ", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ΕΝΩΣΗ_ΕΛΛΗΝΩΝ", "ΔΙΚΑΙΟΣΥΝΗ", "ΕΛΕΥΘΕΡΙΑ_ΠΟΛΙΤΩΝ", "ΔΗΜΟΚΡΑΤΙΚΟΣ_ΑΝΕΜΟΣ", "ΔΙΕΞΟΔΟΣ", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.mainMenu.setEnabled(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
  EklogikiPerifereia = (String) jComboBox1.getSelectedItem(); 
  System.out.println(EklogikiPerifereia);
    }//GEN-LAST:event_jComboBox1ActionPerformed

  public EntityManager getEntityManager1() {
        return entityManager1;
    }   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private evoting.model.TblCandidate tblCandidate1;
    private java.util.List<evoting.model.TblCandidate> tblCandidateList;
    private javax.persistence.Query tblCandidateQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
