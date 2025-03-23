
package authentication;

import Config.User;
import Config.connectDb;
import adminDashboard.adminDash;
import captainDashboard.captainDash;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JFrame {

        connectDb db = new connectDb();

        public LogIn() {
            
            initComponents();
            
        }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        errorlabelUser = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        errorlabelPass = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        user = new javax.swing.JLabel();
        pwl1 = new javax.swing.JLabel();
        login_button = new javax.swing.JPanel();
        llogin = new javax.swing.JLabel();
        usl2 = new javax.swing.JLabel();
        register = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        loginPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 600));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_bg.png"))); // NOI18N
        loginPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 90, 130));

        login.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("LOG IN");
        loginPanel.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 180, 70));

        errorlabelUser.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        loginPanel.add(errorlabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 280, 20));

        username.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        loginPanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 300, 40));

        errorlabelPass.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        loginPanel.add(errorlabelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 280, 20));

        password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        loginPanel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 300, 40));

        user.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        user.setText("Username");
        loginPanel.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 300, 20));

        pwl1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        pwl1.setText("Password");
        loginPanel.add(pwl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 300, 20));

        login_button.setBackground(new java.awt.Color(39, 76, 119));
        login_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_buttonMouseClicked(evt);
            }
        });
        login_button.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        llogin.setBackground(new java.awt.Color(58, 53, 80));
        llogin.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        llogin.setForeground(new java.awt.Color(255, 255, 255));
        llogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        llogin.setText("LOGIN");
        llogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        llogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lloginMouseClicked(evt);
            }
        });
        login_button.add(llogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 60, 40));

        loginPanel.add(login_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 480, 300, 40));

        usl2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usl2.setText("Don't have an account?");
        loginPanel.add(usl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 140, 20));

        register.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        register.setForeground(new java.awt.Color(39, 76, 119));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("REGISTER HERE");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        loginPanel.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 530, 120, 20));

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void lloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lloginMouseClicked
        
    }//GEN-LAST:event_lloginMouseClicked

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        Register reg = new Register();

        this.dispose();
        reg.setVisible(true);
    }//GEN-LAST:event_registerMouseClicked

    private void login_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseClicked
        
        String user = username.getText().trim();
        String pass = new String(password.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            connectDb db = new connectDb();
            Connection con = db.getConnection();
            String sql = "SELECT user_id, password, status, role FROM users WHERE username = ?";

            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, user);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    String status = rs.getString("status");
                    String roleFromDB = rs.getString("role");
                    int userId = rs.getInt("user_id");

                    if (storedPassword.equals(hashPassword(pass))) {  
                        if ("Inactive".equalsIgnoreCase(status)) {
                            JOptionPane.showMessageDialog(this, "Your account is pending approval.", "Login Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Store user session details
                            User.getInstance().setUser(userId, user, roleFromDB);

                            JOptionPane.showMessageDialog(this, "Login successful! You are logged in as " + roleFromDB + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose(); // Close login window

                            // Redirect based on role
                            if ("Admin".equalsIgnoreCase(roleFromDB)) {
                                new adminDash().setVisible(true);
                            } else if ("Barangay Captain".equalsIgnoreCase(roleFromDB)) {
                                new captainDash().setVisible(true);  // Redirect to Captain Dashboard
                            } else {
                                //new UserDash(userId).setVisible(true);  // Default user dashboard
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }

                // Close resources
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_login_buttonMouseClicked

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        
        String user = username.getText();

        if (user.isEmpty()) {
            errorlabelUser.setForeground(Color.RED);
            errorlabelUser.setText("Username is required");
            errorlabelUser.setForeground(Color.RED);
        } else {
            errorlabelUser.setForeground(Color.BLACK);
            errorlabelUser.setText("");
        }

        username.repaint();
    }//GEN-LAST:event_usernameFocusLost

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        
        String pass = password.getText();

        if (pass.isEmpty()) {
            errorlabelPass.setForeground(Color.RED);
            errorlabelPass.setText("Password is required");
            errorlabelPass.setForeground(Color.RED);
        } else {
            errorlabelPass.setForeground(Color.BLACK);
            errorlabelPass.setText("");
        }

        password.repaint();
    }//GEN-LAST:event_passwordFocusLost

     private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(this, "Hashing error", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorlabelPass;
    private javax.swing.JLabel errorlabelUser;
    private javax.swing.JLabel llogin;
    private javax.swing.JLabel login;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel login_button;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pwl1;
    private javax.swing.JLabel register;
    private javax.swing.JLabel user;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usl2;
    // End of variables declaration//GEN-END:variables
}
