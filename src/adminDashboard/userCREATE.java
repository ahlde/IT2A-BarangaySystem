
package adminDashboard;

import Config.User;
import Config.connectDb;
import authentication.LogIn;
import authentication.Register;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class userCREATE extends javax.swing.JInternalFrame {

    
    public userCREATE() {
        initComponents();
        
        // Remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }
    
    private boolean isUsernameTaken(String username) {
        connectDb connect = new connectDb();
        
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?"; 
        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) { 
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
        return false;
    }
     
     private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
    
    private boolean isEmailTaken(String email) {
         connectDb connect = new connectDb();
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, email);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    private boolean validatePassword(javax.swing.JPasswordField passwordField) {
        String password = new String(passwordField.getPassword());
        StringBuilder errorMessage = new StringBuilder();
        boolean isValid = true;

        if (password.isEmpty()) {
            errorMessage.append("Password cannot be empty.\n");
            isValid = false;
        }
        if (password.length() < 8) {
            errorMessage.append("Password must be at least 8 characters long.\n");
            isValid = false;
        }
        if (!password.matches(".*[A-Z].*")) {
            errorMessage.append("Password must contain at least one uppercase letter.\n");
            isValid = false;
        }
        if (!password.matches(".*[a-z].*")) {
            errorMessage.append("Password must contain at least one lowercase letter.\n");
            isValid = false;
        }
        if (!password.matches(".*\\d.*")) {
            errorMessage.append("Password must contain at least one digit.\n");
            isValid = false;
        }
        if (!password.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            errorMessage.append("Password must contain at least one special character.\n");
            isValid = false;
        }
        return isValid;
    }
    
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
    
    private boolean isAllFieldsEmpty() {
    return firstname.getText().trim().isEmpty() &&
           middlename.getText().trim().isEmpty() &&
           lastname.getText().trim().isEmpty() &&
           username.getText().trim().isEmpty() &&
           role.getSelectedIndex() == 0 &&
           email.getText().trim().isEmpty() &&
           password.getPassword().length == 0;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        welcome2 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        middlename = new javax.swing.JTextField();
        welcome6 = new javax.swing.JLabel();
        welcome7 = new javax.swing.JLabel();
        welcome8 = new javax.swing.JLabel();
        welcome9 = new javax.swing.JLabel();
        welcome10 = new javax.swing.JLabel();
        welcome11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        welcome12 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        personal = new javax.swing.JLabel();
        welcome14 = new javax.swing.JLabel();
        welcome15 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        welcome16 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        password = new javax.swing.JPasswordField();
        back_button = new javax.swing.JLabel();
        register_button = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcome2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome2.setForeground(new java.awt.Color(255, 255, 255));
        welcome2.setText("Last Name");
        jPanel2.add(welcome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 180, 30));

        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 200, 40));

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 200, 40));

        middlename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middlenameActionPerformed(evt);
            }
        });
        jPanel2.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 200, 40));

        welcome6.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        welcome6.setForeground(new java.awt.Color(255, 255, 255));
        welcome6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome6.setText("REGISTER");
        jPanel2.add(welcome6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 250, 60));

        welcome7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        welcome7.setForeground(new java.awt.Color(255, 255, 255));
        welcome7.setText("Contact Details");
        jPanel2.add(welcome7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 180, 30));

        welcome8.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome8.setForeground(new java.awt.Color(255, 255, 255));
        welcome8.setText("First Name");
        jPanel2.add(welcome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 180, 30));

        welcome9.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome9.setForeground(new java.awt.Color(255, 255, 255));
        welcome9.setText("Middle Name");
        jPanel2.add(welcome9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, 30));

        welcome10.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        welcome10.setForeground(new java.awt.Color(255, 255, 255));
        welcome10.setText("Log In Credentials");
        jPanel2.add(welcome10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 180, 30));

        welcome11.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome11.setForeground(new java.awt.Color(255, 255, 255));
        welcome11.setText("Email");
        jPanel2.add(welcome11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 180, 30));

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 200, 40));

        welcome12.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome12.setForeground(new java.awt.Color(255, 255, 255));
        welcome12.setText("Contact Number");
        jPanel2.add(welcome12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 180, 30));

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 200, 40));

        personal.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        personal.setForeground(new java.awt.Color(255, 255, 255));
        personal.setText("Personal Information");
        jPanel2.add(personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 30));

        welcome14.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome14.setForeground(new java.awt.Color(255, 255, 255));
        welcome14.setText("Role");
        jPanel2.add(welcome14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 180, 30));

        welcome15.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome15.setForeground(new java.awt.Color(255, 255, 255));
        welcome15.setText("Username");
        jPanel2.add(welcome15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 180, 30));

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 200, 40));

        welcome16.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome16.setForeground(new java.awt.Color(255, 255, 255));
        welcome16.setText("Password");
        jPanel2.add(welcome16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 180, 30));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select a role -", "Admin", "Barangay Captain", "Purok Leader" }));
        jPanel2.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 200, 40));
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 200, 40));

        back_button.setBackground(new java.awt.Color(255, 255, 255));
        back_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_button.setForeground(new java.awt.Color(255, 102, 51));
        back_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back_button.setText("BACK");
        back_button.setOpaque(true);
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_buttonMouseClicked(evt);
            }
        });
        jPanel2.add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 160, 40));

        register_button.setBackground(new java.awt.Color(255, 255, 255));
        register_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        register_button.setForeground(new java.awt.Color(255, 102, 51));
        register_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register_button.setText("REGISTER");
        register_button.setOpaque(true);
        register_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                register_buttonMouseClicked(evt);
            }
        });
        jPanel2.add(register_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 160, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 740, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void middlenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middlenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middlenameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        this.dispose(); 

        usersInternal dash = new usersInternal();
        User.getInstance().getDesktopPane().add(dash);
        dash.setVisible(true);
    }//GEN-LAST:event_back_buttonMouseClicked

    private void register_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_register_buttonMouseClicked
        connectDb connect = new connectDb();

        String firstNameText = firstname.getText().trim();
        String middleNameText = middlename.getText().trim();
        String lastNameText = lastname.getText().trim();
        String contactNumberText = contact.getText().trim();
        String usernameText = username.getText().trim();
        String emailText = email.getText().trim();
        String selectedRole = role.getSelectedItem().toString().trim();
        char[] passwordChars = password.getPassword();
        StringBuilder errorMessage = new StringBuilder();

        // Validation checks
        if (isAllFieldsEmpty()) {
            errorMessage.append("Please fill out the form.\n");
        } else {
            if (firstNameText.isEmpty()) {
                errorMessage.append("First Name cannot be empty.\n");
            }
            if (lastNameText.isEmpty()) {
                errorMessage.append("Last Name cannot be empty.\n");
            }
            if (role.getSelectedIndex() == 0) {
                errorMessage.append("Please select a role.\n");
            }
            if (contactNumberText.isEmpty()) {
                errorMessage.append("Contact number cannot be empty.\n");
            } else if (!contactNumberText.matches("\\d{11}")) { // Checks for 11-digit phone number
                errorMessage.append("Invalid contact number format. Must be 11 digits.\n");
            }
            if (emailText.isEmpty()) {
                errorMessage.append("Email cannot be empty.\n");
            } else if (!isValidEmail(emailText)) {
                errorMessage.append("Invalid email format.\n");
            } else if (isEmailTaken(emailText)) {
                errorMessage.append("Email is already taken.\n");
            }
            if (usernameText.isEmpty()) {
                errorMessage.append("Username cannot be empty.\n");
            } else if (isUsernameTaken(usernameText)) {
                errorMessage.append("Username is already taken.\n");
            }
            if (!validatePassword(password)) {
                return;
            }
        }

        // Show error message if any
        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hash password
        String passwordText = new String(passwordChars);
        String hashedPassword = hashPassword(passwordText);

        // SQL insert query with updated attributes
        String sql = "INSERT INTO barlog.users (first_name, middle_name, last_name, contact_number, role, email, username, password, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, firstNameText);
            pst.setString(2, middleNameText);
            pst.setString(3, lastNameText);
            pst.setString(4, contactNumberText);
            pst.setString(5, selectedRole);
            pst.setString(6, emailText);
            pst.setString(7, usernameText);
            pst.setString(8, hashedPassword);
            pst.setString(9, "Inactive");

            pst.executeUpdate();

            // Success message
            JOptionPane.showMessageDialog(this, "Added Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear fields after registration
            firstname.setText("");
            middlename.setText("");
            lastname.setText("");
            contact.setText("");
            username.setText("");
            email.setText("");
            password.setText("");


        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
                                          
    }//GEN-LAST:event_register_buttonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_button;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel personal;
    private javax.swing.JLabel register_button;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JTextField username;
    private javax.swing.JLabel welcome10;
    private javax.swing.JLabel welcome11;
    private javax.swing.JLabel welcome12;
    private javax.swing.JLabel welcome14;
    private javax.swing.JLabel welcome15;
    private javax.swing.JLabel welcome16;
    private javax.swing.JLabel welcome2;
    private javax.swing.JLabel welcome6;
    private javax.swing.JLabel welcome7;
    private javax.swing.JLabel welcome8;
    private javax.swing.JLabel welcome9;
    // End of variables declaration//GEN-END:variables
}
