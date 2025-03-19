
package adminDashboard;

import Config.User;
import Config.connectDb;
import authentication.LogIn;
import authentication.Register;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class userEDIT extends javax.swing.JInternalFrame {

    private Connection conn;
    private String editingUsername; 
    
    public userEDIT() {
        initComponents();
    }

    userEDIT(int selectedUserId, String firstname, String middlename, String lastname, String em, String contact, String user, String role, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
           user.getText().trim().isEmpty() &&
           role.getSelectedIndex() == 0 &&
           em.getText().trim().isEmpty() &&
           pass.getPassword().length == 0;
    }
    
   public void setUserData(int userId, String firstName, String middleName, String lastName, 
                        String email, String contactNumber, String username, 
                        String roleValue, String password) {
            // Ensure fields exist before setting values
            if (firstname != null) {
                firstname.setText(firstName);
            }
            if (middlename != null) {
                middlename.setText(middleName);
            }
            if (lastname != null) {
                lastname.setText(lastName);
            }
            if (em != null) {
                em.setText(email);
            }
            if (contact != null) {
                contact.setText(contactNumber);
            }
            if (user != null) {
                user.setText(username);
            }
            if (role != null) {
                role.setSelectedItem(roleValue);
            }
            if (pass != null) {
                pass.setText(""); // Be careful with passwords!
            }
        }


    
    public userEDIT(String username) {  // Accept username to edit
        initComponents();
        conn = new connectDb().getConnection();
        this.editingUsername = username;
        loadUserDetails();  // Fetch and display user data
    }
    
    private void loadUserDetails() {
        String sql = "SELECT firstname, middlename, lastname, contact, email, username, role FROM users WHERE username = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, editingUsername);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    firstname.setText(rs.getString("firstname"));
                    middlename.setText(rs.getString("middlename"));
                    lastname.setText(rs.getString("lastname"));
                    contact.setText(rs.getString("contact"));
                    em.setText(rs.getString("email"));
                    user.setText(rs.getString("username"));
                    role.setSelectedItem(rs.getString("role"));
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    this.dispose(); // Close the form if the user doesn't exist
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saveChanges() {
        try {
            connectDb db = new connectDb();
            Connection conn = db.getConnection();

            // Get updated data from fields
            String newFirstName = firstname.getText().trim();
            String newMiddleName = middlename.getText().trim();
            String newLastName = lastname.getText().trim();
            String newEmail = em.getText().trim();
            String newContact = contact.getText().trim();
            String newUsername = user.getText().trim(); // Used for lookup
            String newRole = role.getSelectedItem().toString().trim();
            String newPassword = new String(pass.getPassword()).trim();

            // Validate required fields
            if (newFirstName.isEmpty() || newLastName.isEmpty() || newEmail.isEmpty() || 
                newUsername.isEmpty() || newRole.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if user exists before updating
            String checkUserQuery = "SELECT username FROM users WHERE username=?";
            PreparedStatement checkUserStmt = conn.prepareStatement(checkUserQuery);
            checkUserStmt.setString(1, newUsername);
            ResultSet rs = checkUserStmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Construct SQL query
            String query;
            PreparedStatement ps;

            if (newPassword.isEmpty()) {
                // Update without changing the password
                query = "UPDATE users SET first_name=?, middle_name=?, last_name=?, email=?, contact_number=?, role=? WHERE username=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, newFirstName);
                ps.setString(2, newMiddleName);
                ps.setString(3, newLastName);
                ps.setString(4, newEmail);
                ps.setString(5, newContact);
                ps.setString(6, newRole);
                ps.setString(7, newUsername);
            } else {
                // Update including password change
                query = "UPDATE users SET first_name=?, middle_name=?, last_name=?, email=?, contact_number=?, role=?, password=? WHERE username=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, newFirstName);
                ps.setString(2, newMiddleName);
                ps.setString(3, newLastName);
                ps.setString(4, newEmail);
                ps.setString(5, newContact);
                ps.setString(6, newRole);
                ps.setString(7, newPassword);
                ps.setString(8, newUsername);
            }

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "User information updated successfully!");
                this.dispose(); // Close the form after saving
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update user information.");
            }

            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        em = new javax.swing.JTextField();
        welcome12 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();
        personal = new javax.swing.JLabel();
        welcome14 = new javax.swing.JLabel();
        welcome15 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        welcome16 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        pass = new javax.swing.JPasswordField();
        back_button = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcome2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome2.setForeground(new java.awt.Color(255, 255, 255));
        welcome2.setText("Last Name");
        jPanel2.add(welcome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 180, 30));

        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 200, 40));

        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 40));

        middlename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middlenameActionPerformed(evt);
            }
        });
        jPanel2.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 200, 40));

        welcome6.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        welcome6.setForeground(new java.awt.Color(255, 255, 255));
        welcome6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome6.setText("UPDATE ");
        jPanel2.add(welcome6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 250, 60));

        welcome7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        welcome7.setForeground(new java.awt.Color(255, 255, 255));
        welcome7.setText("Contact Details");
        jPanel2.add(welcome7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 180, 30));

        welcome8.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome8.setForeground(new java.awt.Color(255, 255, 255));
        welcome8.setText("First Name");
        jPanel2.add(welcome8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 180, 30));

        welcome9.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome9.setForeground(new java.awt.Color(255, 255, 255));
        welcome9.setText("Middle Name");
        jPanel2.add(welcome9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 180, 30));

        welcome10.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        welcome10.setForeground(new java.awt.Color(255, 255, 255));
        welcome10.setText("Log In Credentials");
        jPanel2.add(welcome10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 180, 30));

        welcome11.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome11.setForeground(new java.awt.Color(255, 255, 255));
        welcome11.setText("Email");
        jPanel2.add(welcome11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 180, 30));

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel2.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 40));

        welcome12.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome12.setForeground(new java.awt.Color(255, 255, 255));
        welcome12.setText("Contact Number");
        jPanel2.add(welcome12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 180, 30));

        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 200, 40));

        personal.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        personal.setForeground(new java.awt.Color(255, 255, 255));
        personal.setText("Personal Information");
        jPanel2.add(personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 30));

        welcome14.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome14.setForeground(new java.awt.Color(255, 255, 255));
        welcome14.setText("Role");
        jPanel2.add(welcome14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 180, 30));

        welcome15.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome15.setForeground(new java.awt.Color(255, 255, 255));
        welcome15.setText("Username");
        jPanel2.add(welcome15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 180, 30));

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel2.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 200, 40));

        welcome16.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        welcome16.setForeground(new java.awt.Color(255, 255, 255));
        welcome16.setText("Password");
        jPanel2.add(welcome16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 180, 30));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select a role -", "Admin", "Barangay Captain", "Purok Leader" }));
        jPanel2.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 200, 40));
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 200, 40));

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
        jPanel2.add(back_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 160, 40));

        save_button.setBackground(new java.awt.Color(255, 255, 255));
        save_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        save_button.setForeground(new java.awt.Color(255, 102, 51));
        save_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_button.setText("SAVE");
        save_button.setOpaque(true);
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });
        jPanel2.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 160, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 450));

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

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void back_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseClicked
        this.dispose();

        usersInternal dash = new usersInternal();
        User.getInstance().getDesktopPane().add(dash);
        dash.setVisible(true);
    }//GEN-LAST:event_back_buttonMouseClicked

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked

            saveChanges();
    }//GEN-LAST:event_save_buttonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_button;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField em;
    private javax.swing.JTextField firstname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField middlename;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel personal;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JLabel save_button;
    private javax.swing.JTextField user;
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
