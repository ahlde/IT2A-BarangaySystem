
package adminDashboard;

import Config.User;
import Config.connectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class profilesInternal extends javax.swing.JInternalFrame {

 
    public profilesInternal() {
        initComponents();
        loadUserFullName();
        
         // Remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }
    
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


  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        welcome4 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        back_button1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(welcome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 280, 60));

        firstname.setFont(new java.awt.Font("Book Antiqua", 1, 20)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 280, 50));

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

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 580, 370));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_button1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_back_button1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_button1;
    private javax.swing.JLabel firstname;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel welcome4;
    // End of variables declaration//GEN-END:variables
}
