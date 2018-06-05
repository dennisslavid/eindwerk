package internshipmanagerUI;

import internshipManagerBO.Services.InternshipServices;
import internshipManagerBO.Services.OrganisationServices;
import internshipManagerDAL.Entities.Internship;
import internshipManagerDAL.Entities.Organisation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 *
 * @author denni
 */
public class AddInternshipScreen extends javax.swing.JFrame {

    List<Organisation> allOrganisations = new ArrayList();
    OrganisationServices orgServices = new OrganisationServices();
    InternshipServices internServices = new InternshipServices();
    Internship currentInternship = new Internship();
    
    /**
     * Creates new form AddInternshipScreen
     */
    public AddInternshipScreen() {
        initComponents();
        this.setTitle("Add new internship");
        allOrganisations = orgServices.getAllOrganisations();
        lstOrganisations.setListData(allOrganisations.toArray());
    }
    
    public AddInternshipScreen(Internship current) {
        initComponents();
        this.setTitle("Edit internship");
        allOrganisations = orgServices.getAllOrganisations();
        Organisation currentOrganisation = current.getOrganisation();
        int indexToSelect = 0;
        for(Organisation o : allOrganisations) {
            if(o.getId() == currentOrganisation.getId()){
                indexToSelect = allOrganisations.indexOf(o);
            }
        }
        lstOrganisations.setListData(allOrganisations.toArray());
        currentInternship = current;
        txtTitle.setText(current.getTitle());
        ftfDate.setText(internServices.transformDateToString(current.getStartDate()));
        txtDescription.setText(current.getDescription());
        lstOrganisations.setSelectedIndex(indexToSelect);
    }
    
    public void refreshList() {
        allOrganisations = orgServices.getAllOrganisations();
        lstOrganisations.setListData(allOrganisations.toArray());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        ftfDate = new javax.swing.JFormattedTextField();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextPane();
        lblOrganisation = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOrganisations = new javax.swing.JList();
        btnAddOrganisation = new javax.swing.JButton();
        btnEditOrganisation = new javax.swing.JButton();
        btnDeleteOrganisation = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        barInfo = new javax.swing.JToolBar();
        lblOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lblTitle.setText("Title:");

        lblStartDate.setText("Start date:");

        ftfDate.setColumns(3);
        ftfDate.setText("dd/mm/yyyy");
        ftfDate.setToolTipText("dd/mm/yyyy");

        lblDescription.setText("Description:");

        jScrollPane1.setViewportView(txtDescription);

        lblOrganisation.setText("Organisation:");

        jScrollPane2.setViewportView(lstOrganisations);

        btnAddOrganisation.setText("Add New Organisation");
        btnAddOrganisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrganisationActionPerformed(evt);
            }
        });

        btnEditOrganisation.setText("Edit Organisation");
        btnEditOrganisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditOrganisationActionPerformed(evt);
            }
        });

        btnDeleteOrganisation.setText("Delete Organisation");
        btnDeleteOrganisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrganisationActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        barInfo.setRollover(true);
        barInfo.add(lblOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescription)
                                    .addComponent(lblStartDate)
                                    .addComponent(lblTitle))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(ftfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOrganisation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddOrganisation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditOrganisation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeleteOrganisation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrganisation)
                            .addComponent(btnAddOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String title = txtTitle.getText();
        String startDate = ftfDate.getText();
        String description = txtDescription.getText();
        Organisation org = null;
        Calendar formattedStartDate = null;
        boolean noOrgSelected = lstOrganisations.isSelectionEmpty();
        if(noOrgSelected != true) {
            org = (Organisation) lstOrganisations.getSelectedValue();
        }
        if(!internServices.inputIsValid(title, startDate, description, noOrgSelected)) {
            lblOutput.setText("Please fill all fields correctly.");
        } else {
           formattedStartDate = internServices.transformToDate(startDate);
           currentInternship.setTitle(title);
           currentInternship.setStartDate(new java.sql.Date(formattedStartDate.getTimeInMillis()));
           currentInternship.setDescription(description);
           currentInternship.setOrganisation(org);
           if(currentInternship.getId() == null) {
               internServices.saveInternship(currentInternship);
           } else {
               internServices.updateInternship(currentInternship);
           }
           this.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddOrganisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrganisationActionPerformed
        AddOrganisationScreen addOrgScreen = new AddOrganisationScreen();
        addOrgScreen.setVisible(true);
    }//GEN-LAST:event_btnAddOrganisationActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        boolean nothingSelected = lstOrganisations.isSelectionEmpty();
        if(nothingSelected) {
            this.refreshList();
        } else {
            int indexToSelect = lstOrganisations.getSelectedIndex();
            this.refreshList();
            lstOrganisations.setSelectedIndex(indexToSelect);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnEditOrganisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditOrganisationActionPerformed
        boolean noOrgSelected = lstOrganisations.isSelectionEmpty();
        if(noOrgSelected == false) {
            Organisation current = (Organisation) lstOrganisations.getSelectedValue();
            AddOrganisationScreen addOrgScreen = new AddOrganisationScreen(current);
            addOrgScreen.setVisible(true);
        } else {
            lblOutput.setText("Please select an Organisation to edit.");
        }
    }//GEN-LAST:event_btnEditOrganisationActionPerformed

    private void btnDeleteOrganisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrganisationActionPerformed
        lblOutput.setText("");
        boolean noOrgSelected = lstOrganisations.isSelectionEmpty();
        if(noOrgSelected == false) {
            Organisation current = (Organisation) lstOrganisations.getSelectedValue();
            if(!orgServices.hasInternship(current)) {
                orgServices.deleteOrganisation(current);
                this.refreshList();
            } else {
                lblOutput.setText("This organisation still has one or more internships attached. Unable to delete.");
            }
            
        } else {
            lblOutput.setText("Please select an Organisation to delete.");
        }
    }//GEN-LAST:event_btnDeleteOrganisationActionPerformed

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
            java.util.logging.Logger.getLogger(AddInternshipScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddInternshipScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddInternshipScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddInternshipScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddInternshipScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barInfo;
    private javax.swing.JButton btnAddOrganisation;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteOrganisation;
    private javax.swing.JButton btnEditOrganisation;
    private javax.swing.JButton btnSave;
    private javax.swing.JFormattedTextField ftfDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblOrganisation;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList lstOrganisations;
    private javax.swing.JTextPane txtDescription;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
