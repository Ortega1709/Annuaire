/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import classes.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ortega
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    private int id; // id qui nous aidera pour la suppréssion d'une information ...
    private static LinkedList<Annuaire> annuaires = new LinkedList<>();  // notre liste chaînée qui va contenir les informations ...
    
    public MainFrame() {
        
        initComponents();
        setLocationRelativeTo(null);
        this.showAnnuaires();
    }

    private void setId(int id){
        this.id = id;
    }
    
    private int getId(){
        return this.id;
    }
    // fonction qui permet d'afficher les informations se trouvant dans la liste chainée ...
    private void showAnnuaires(){
        int ID;
        DefaultTableModel model = (DefaultTableModel) linkedListResult.getModel();
        String []annuaire = new String[7];
        model.setNumRows(0);
        
        for(int i = 0; i < annuaires.size(); i++){
            ID = i+1;
            annuaire[0] = String.valueOf(ID);
            annuaire[1] = annuaires.get(i).getNom();
            annuaire[2] = annuaires.get(i).getPrenom();
            annuaire[3] = annuaires.get(i).getNumero();
            annuaire[4] = String.valueOf(annuaires.get(i).getAdresse().getNumeroAvenue());
            annuaire[5] = annuaires.get(i).getAdresse().getNomAvenue();
            annuaire[6] = annuaires.get(i).getAdresse().getNomProvince();
            model.addRow(annuaire);
        }
    }
    
    // fonction qui permet d'ajouter un annuaire ...
    private void addAnnuaire(){
        // TODO ajouter des conditions pour des cas d'erreurs ... 
        if(this.verifNumero(inputNumero.getText()) == false){
            if(this.verifValidateNumero(inputNumero.getText()) == true){
                Adresse adresse = new Adresse(Integer.parseInt(inputNAv.getText()),inputAvenue.getText(), (String) inputProvince.getSelectedItem(),"");
                Annuaire annuaire = new Annuaire(inputNom.getText(),inputPrenom.getText(),inputNumero.getText(),adresse);
        
                // insertion dans la liste chainée ...
                annuaires.add(annuaires.size(), annuaire);
                this.clearField();
                this.showAnnuaires();
            }else{
                this.clearField();
                this.showAnnuaires();
                JOptionPane.showMessageDialog(null, "Numéro invalide");
            }
 
        }else{
            this.clearField();
            this.showAnnuaires();
            JOptionPane.showMessageDialog(null, "Erreur d'ajout");
        }
    }
    
    // fonction qui permet d'effacer les champs remplis ...
    private void clearField(){
        // effacer les champs remplis ...
        inputNAv.setText("");
        inputAvenue.setText("");
        inputProvince.setSelectedItem("Haut-Katanga");
        inputNom.setText("");
        inputPrenom.setText("");
        inputNumero.setText("");
    }
    
    // fonction qui permet de modifier les informations d'un utilisateur ...
    private void updateAnnuaire(){
        if(this.verifNumero(inputNumero.getText()) == false){
           if(this.verifValidateNumero(inputNumero.getText()) == true){
                Adresse adresse = new Adresse(Integer.parseInt(inputNAv.getText()),inputAvenue.getText(), (String) inputProvince.getSelectedItem(),"");
                Annuaire annuaire = new Annuaire(inputNom.getText(),inputPrenom.getText(),inputNumero.getText(),adresse);

                for(int i = 0; i < annuaires.size(); i++){
                    if(i == this.getId() - 1){
                        annuaires.remove(i);
                        annuaires.add(i,annuaire);
                        this.clearField();
                        this.showAnnuaires();
                    }
                }
           }else{
               this.clearField();
               this.showAnnuaires();
               JOptionPane.showMessageDialog(null, "Numéro invalide");
           } 
        }else{
            this.clearField();
            this.showAnnuaires();
            JOptionPane.showMessageDialog(null, "Erreur de modification");
        }
        
    }
    
    // fonction qui permet de supprimer les informations d'un utilisateur ... 
    private void deleteAnnuaire(){
        for(int i = 0; i < annuaires.size(); i++){
            if(i == this.getId() - 1){
                annuaires.remove(i);
                this.clearField();
                this.showAnnuaires();
            }
        }
    }
    
    // fonction qui verifie si le numéro inséré existe déjà ...
    private boolean verifNumero(String numero){
        for(int i = 0; i < annuaires.size(); i++){
            if(annuaires.get(i).getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }
    
    // fonction qui verifie si le numéro inséré est valide pour un pays
    private boolean verifValidateNumero(String numero){
        if(numero.length() == 10){
            int n = Integer.parseInt(numero);
            n = n / 10000000;
            if(n == 90 || n == 99 || n == 81 || n == 82 || n == 83 || n ==  89 || n == 97){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        quiBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputNom = new javax.swing.JTextField();
        inputPrenom = new javax.swing.JTextField();
        inputNumero = new javax.swing.JTextField();
        inputNAv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inputAvenue = new javax.swing.JTextField();
        inputProvince = new javax.swing.JComboBox<>();
        btnAjouter = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        linkedListResult = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        quiBtn.setBackground(new java.awt.Color(255, 255, 255));
        quiBtn.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        quiBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        quiBtn.setBorder(null);
        quiBtn.setBorderPainted(false);
        quiBtn.setContentAreaFilled(false);
        quiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quiBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel1.setText("Nom");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel2.setText("Prénom");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel3.setText("Numéro");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel4.setText("N° Av");

        inputNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNomActionPerformed(evt);
            }
        });

        inputPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPrenomActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel5.setText("Avenue");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel6.setText("Province");

        inputAvenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAvenueActionPerformed(evt);
            }
        });

        inputProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Haut-Katanga", "Kinshasa", "Mai-Ndombe", "Haut-Lomami", "Sankuru", "Maniema", "Nord-Kivu", "Sud-Kivu", "Nord-Ubangi", "Sud-Ubangi", "Ituri", "Kongo-Central", "Kasai-Central", "Kasai-Occidental", "Kasai-Oriental", "Lomami", "Haut-Uélé", "Bas-Uélé", "Kwango", "Kwilu", "Tanganyika", "Lualaba", "Mongala", "Tshuapa", "Tshopo", "Equateur", " ", " " }));

        btnAjouter.setBackground(new java.awt.Color(0, 51, 102));
        btnAjouter.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        btnAjouter.setForeground(new java.awt.Color(255, 255, 255));
        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnSupprimer.setBackground(new java.awt.Color(0, 51, 102));
        btnSupprimer.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        btnSupprimer.setForeground(new java.awt.Color(255, 255, 255));
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnModifier.setBackground(new java.awt.Color(0, 51, 102));
        btnModifier.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        btnModifier.setForeground(new java.awt.Color(255, 255, 255));
        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        linkedListResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Prénom", "Numéro", "N° Avenue", "Avenue", "Province"
            }
        ));
        linkedListResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linkedListResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(linkedListResult);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputNAv, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputAvenue, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSupprimer)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2)))
                        .addGap(49, 49, 49))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quiBtn))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(quiBtn)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(inputAvenue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNAv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quiBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quiBtnActionPerformed

    private void inputNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNomActionPerformed

    private void inputPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPrenomActionPerformed

    private void inputAvenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAvenueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAvenueActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
       this.addAnnuaire();
    }//GEN-LAST:event_btnAjouterActionPerformed

    // fonction qui affiche les informations de l'utilisateur dont la ligne a été séléctionné ...
    private void linkedListResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linkedListResultMouseClicked
        // TODO add your handling code here:
        
        String d = (String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(),0);
        this.setId(Integer.parseInt(d));
        inputNom.setText((String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(),1));
        inputPrenom.setText((String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(), 2));
        inputNumero.setText((String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(), 3));
        inputNAv.setText((String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(), 4));
        inputAvenue.setText((String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(), 5));
        inputProvince.setSelectedItem((String) linkedListResult.getValueAt(linkedListResult.getSelectedRow(),6));
    }//GEN-LAST:event_linkedListResultMouseClicked

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        // TODO add your handling code here:
        this.updateAnnuaire();
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        // TODO add your handling code here:
        this.deleteAnnuaire();
    }//GEN-LAST:event_btnSupprimerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JTextField inputAvenue;
    private javax.swing.JTextField inputNAv;
    private javax.swing.JTextField inputNom;
    private javax.swing.JTextField inputNumero;
    private javax.swing.JTextField inputPrenom;
    private javax.swing.JComboBox<String> inputProvince;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable linkedListResult;
    private javax.swing.JButton quiBtn;
    // End of variables declaration//GEN-END:variables
}
