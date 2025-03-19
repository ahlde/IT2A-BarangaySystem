
package adminDashboard;

import Config.User;
import authentication.LogIn;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class adminDash extends javax.swing.JFrame {

    public adminDash() {
        initComponents();
        
        showUser();
        User.getInstance().setDesktopPane(mydesktop);
    }
    
    private void showUser() {
        usersInternal dash = new usersInternal();
        mydesktop.add(dash);
        dash.setVisible(true);
    }
    
    Color hoverColor = new Color (255,102,0);
    Color navColor = new Color (255,102,51);
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logo1 = new javax.swing.JLabel();
        welcome4 = new javax.swing.JLabel();
        dashPanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        residentsPanel = new javax.swing.JPanel();
        residents = new javax.swing.JLabel();
        requestPanel = new javax.swing.JPanel();
        request = new javax.swing.JLabel();
        issuancePanel = new javax.swing.JPanel();
        issuance = new javax.swing.JLabel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        mydesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jPanel4.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 80));

        welcome4.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        welcome4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome4.setText("BARANGAY CERTIFY");
        jPanel4.add(welcome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, -1));

        dashPanel.setBackground(new java.awt.Color(255, 102, 51));
        dashPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashPanelMouseExited(evt);
            }
        });
        dashPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard.setText("Dashboard");
        dashPanel.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(dashPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 170, -1));

        userPanel.setBackground(new java.awt.Color(255, 102, 51));
        userPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userPanelMouseExited(evt);
            }
        });
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        users.setForeground(new java.awt.Color(255, 255, 255));
        users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users.setText("Manage Users");
        userPanel.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 170, -1));

        residentsPanel.setBackground(new java.awt.Color(255, 102, 51));
        residentsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                residentsPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                residentsPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                residentsPanelMouseExited(evt);
            }
        });
        residentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        residents.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        residents.setForeground(new java.awt.Color(255, 255, 255));
        residents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        residents.setText("Manage Residents");
        residentsPanel.add(residents, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jPanel2.add(residentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 170, -1));

        requestPanel.setBackground(new java.awt.Color(255, 102, 51));
        requestPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requestPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                requestPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                requestPanelMouseExited(evt);
            }
        });
        requestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        request.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        request.setForeground(new java.awt.Color(255, 255, 255));
        request.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        request.setText("Request");
        requestPanel.add(request, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(requestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 170, -1));

        issuancePanel.setBackground(new java.awt.Color(255, 102, 51));
        issuancePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuancePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issuancePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issuancePanelMouseExited(evt);
            }
        });
        issuancePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        issuance.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        issuance.setForeground(new java.awt.Color(255, 255, 255));
        issuance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        issuance.setText("Issuance");
        issuancePanel.add(issuance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(issuancePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 170, -1));

        logoutPanel.setBackground(new java.awt.Color(153, 51, 0));
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanelMouseExited(evt);
            }
        });
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("LOG OUT");
        logoutPanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        jPanel2.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 610));

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 730, 80));

        mydesktop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mydesktopLayout = new javax.swing.GroupLayout(mydesktop);
        mydesktop.setLayout(mydesktopLayout);
        mydesktopLayout.setHorizontalGroup(
            mydesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        mydesktopLayout.setVerticalGroup(
            mydesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel1.add(mydesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 730, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked
        int choice = JOptionPane.showConfirmDialog(
        this, 
        "Are you sure you want to log out?", 
        "Confirm Logout", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            LogIn lg = new LogIn();
            lg.setLocationRelativeTo(null);
            lg.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        
    }//GEN-LAST:event_logoutPanelMouseExited

    private void residentsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentsPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_residentsPanelMouseClicked

    private void residentsPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentsPanelMouseEntered
        residentsPanel.setBackground(hoverColor);
    }//GEN-LAST:event_residentsPanelMouseEntered

    private void residentsPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentsPanelMouseExited
        residentsPanel.setBackground(navColor);
    }//GEN-LAST:event_residentsPanelMouseExited

    private void userPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseClicked
        showUser();
    }//GEN-LAST:event_userPanelMouseClicked

    private void userPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseEntered
        userPanel.setBackground(hoverColor);
    }//GEN-LAST:event_userPanelMouseEntered

    private void userPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseExited
        userPanel.setBackground(navColor);
    }//GEN-LAST:event_userPanelMouseExited

    private void dashPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashPanelMouseClicked

    private void dashPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseEntered
        dashPanel.setBackground(hoverColor);
    }//GEN-LAST:event_dashPanelMouseEntered

    private void dashPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseExited
        dashPanel.setBackground(navColor);
    }//GEN-LAST:event_dashPanelMouseExited

    private void requestPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_requestPanelMouseClicked

    private void requestPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestPanelMouseEntered
        requestPanel.setBackground(hoverColor);
    }//GEN-LAST:event_requestPanelMouseEntered

    private void requestPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestPanelMouseExited
        requestPanel.setBackground(navColor);
    }//GEN-LAST:event_requestPanelMouseExited

    private void issuancePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuancePanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_issuancePanelMouseClicked

    private void issuancePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuancePanelMouseEntered
        issuancePanel.setBackground(hoverColor);
    }//GEN-LAST:event_issuancePanelMouseEntered

    private void issuancePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuancePanelMouseExited
        issuancePanel.setBackground(navColor);
    }//GEN-LAST:event_issuancePanelMouseExited

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
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dashPanel;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel issuance;
    private javax.swing.JPanel issuancePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JDesktopPane mydesktop;
    private javax.swing.JLabel request;
    private javax.swing.JPanel requestPanel;
    private javax.swing.JLabel residents;
    private javax.swing.JPanel residentsPanel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JLabel users;
    private javax.swing.JLabel welcome4;
    // End of variables declaration//GEN-END:variables
}
