
package captainDashboard;

import Config.User;
import Config.connectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class capProfileInternal extends javax.swing.JInternalFrame {


    public capProfileInternal() {
        initComponents();
        loadUserFullName();
        
         // Remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        welcome4 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        confirmpassword = new javax.swing.JPasswordField();
        confirm = new javax.swing.JLabel();
        back_button1 = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        pass1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 51, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 300));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_bg.png"))); // NOI18N
        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 90, 130));

        welcome4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        welcome4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome4.setText("Welcome ");
        jPanel3.add(welcome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 280, 60));

        firstname.setFont(new java.awt.Font("Book Antiqua", 1, 20)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 280, 50));

        save_button.setBackground(new java.awt.Color(255, 102, 51));
        save_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        save_button.setForeground(new java.awt.Color(255, 255, 255));
        save_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_button.setText("SAVE");
        save_button.setOpaque(true);
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });
        jPanel3.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 160, 40));

        password.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 260, 40));

        confirmpassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        confirmpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmpasswordFocusLost(evt);
            }
        });
        jPanel3.add(confirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 260, 40));

        confirm.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        confirm.setText("Confirm Password");
        jPanel3.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 260, 20));

        back_button1.setBackground(new java.awt.Color(255, 102, 51));
        back_button1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_button1.setForeground(new java.awt.Color(255, 255, 255));
        back_button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button1.setText("BACK");
        back_button1.setOpaque(true);
        back_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_button1MouseClicked(evt);
            }
        });
        jPanel3.add(back_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 160, 40));

        pass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pass.setText("CHANGE PASSWORD");
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 330, 20));

        pass1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        pass1.setText("Password");
        jPanel3.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 260, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 580, 370));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadUserFullName() {
        int userId = User.getInstance().getUserId(); // Get logged-in user's ID

        try {
            connectDb db = new connectDb();
            Connection conn = db.getConnection();

            // Debugging: Print userId
            System.out.println("User ID: " + userId);

            // Query to get first_name and last_name separately
            String query = "SELECT first_name, last_name FROM users WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // Debugging: Print retrieved values
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);

                if (firstName == null || lastName == null) {
                    firstname.setText("Unknown User");
                } else {
                    firstname.setText(firstName + " " + lastName);
                }
            } else {
                firstname.setText("User not found");
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            firstname.setText("Error loading name");
        }
    }
    
    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked
         char[] passChars = password.getPassword(); 
        char[] confirmPassChars = confirmpassword.getPassword();

        String newPassword = new String(passChars);
        String confirmPassword = new String(confirmPassChars);

        // Check if passwords match
        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop execution if passwords don't match
        }

        // Proceed to save the password
        int userId = User.getInstance().getUserId(); // Get logged-in user's ID

        try {
            connectDb db = new connectDb();
            Connection conn = db.getConnection();

            // Update password query
            String query = "UPDATE users SET password = ? WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to change password!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating password!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear password fields for security
        Arrays.fill(passChars, '0');
        Arrays.fill(confirmPassChars, '0');
        password.setText("");
        confirmpassword.setText("");

    }//GEN-LAST:event_save_buttonMouseClicked

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost

    }//GEN-LAST:event_passwordFocusLost

    private void confirmpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpasswordFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpasswordFocusLost

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_back_button1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_button1;
    private javax.swing.JLabel confirm;
    private javax.swing.JPasswordField confirmpassword;
    private javax.swing.JLabel firstname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel pass1;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel save_button;
    private javax.swing.JLabel welcome4;
    // End of variables declaration//GEN-END:variables
}
