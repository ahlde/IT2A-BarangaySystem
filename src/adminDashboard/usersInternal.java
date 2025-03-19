
package adminDashboard;

import Config.User;
import Config.connectDb;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class usersInternal extends javax.swing.JInternalFrame {

    private JDesktopPane mydesktop;
    
    public usersInternal() {
        initComponents();
        loadUsers();
        setBackground(new Color(255, 255, 255));

        // Remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        // Customize table header
        users.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        users.getTableHeader().setOpaque(false);
        users.getTableHeader().setBorder(null);
        users.getTableHeader().setBackground(new Color(51, 51, 255));
        users.getTableHeader().setForeground(new Color(0, 0, 0));
        users.setRowHeight(25);

        // Adjust table column sizes (now 6 columns)
        users.getColumnModel().getColumn(0).setPreferredWidth(25);   // ID
        users.getColumnModel().getColumn(1).setPreferredWidth(55);   // First Name
        users.getColumnModel().getColumn(2).setPreferredWidth(55);  // Last Name
        users.getColumnModel().getColumn(3).setPreferredWidth(20);  // Role
        users.getColumnModel().getColumn(4).setPreferredWidth(80);   // Username
        users.getColumnModel().getColumn(5).setPreferredWidth(80);   // Status

    }
    
    Color hoverColor = new Color (255,102,0);
    Color navColor = new Color (255,102,51);

   private void showUser() {
        usersInternal dash = new usersInternal();
        mydesktop.add(dash);
        dash.setVisible(true);
    }
   
   public int getSelectedUserId() {
        int selectedRow = users.getSelectedRow(); // Get the selected row index

            if (selectedRow != -1) { // Check if a row is selected
                return Integer.parseInt(users.getValueAt(selectedRow, 0).toString()); // Get user_id from the first column
            }
        return -1; 
    }
   
   private void loadUsers() {
        connectDb connect = new connectDb();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("User ID");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Role");
        model.addColumn("Username");
        model.addColumn("Status");

        try {
            Connection conn = connect.getConnection();
            if (conn == null) {
                System.out.println("Database connection failed!");
                return;
            }

            String query = "SELECT user_id, first_name, last_name, role, username, status FROM users"; // Corrected query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("role"),
                    rs.getString("username"),
                    rs.getString("status")
                });
            }

            users.setModel(model);
            model.fireTableDataChanged();

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Error loading users: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        paneHolder = new javax.swing.JScrollPane();
        users = new javax.swing.JTable();
        activatePanel = new javax.swing.JPanel();
        activate = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        editPanel = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        deletePanel = new javax.swing.JPanel();
        delete = new javax.swing.JLabel();
        refreshPanel = new javax.swing.JPanel();
        refresh = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneHolder.setAutoscrolls(true);

        users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        paneHolder.setViewportView(users);

        jPanel1.add(paneHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 780, 310));

        activatePanel.setBackground(new java.awt.Color(255, 102, 51));
        activatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activatePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activatePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                activatePanelMouseExited(evt);
            }
        });
        activatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activate.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        activate.setForeground(new java.awt.Color(255, 255, 255));
        activate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activate.setText("Activate");
        activatePanel.add(activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jPanel1.add(activatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 110, 40));

        addPanel.setBackground(new java.awt.Color(255, 102, 51));
        addPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPanelMouseExited(evt);
            }
        });
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("ADD");
        addPanel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jPanel1.add(addPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 110, 40));

        editPanel.setBackground(new java.awt.Color(255, 102, 51));
        editPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editPanelMouseExited(evt);
            }
        });
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit.setText("EDIT");
        editPanel.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jPanel1.add(editPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 110, 40));

        deletePanel.setBackground(new java.awt.Color(255, 102, 51));
        deletePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletePanelMouseExited(evt);
            }
        });
        deletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delete.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("DELETE");
        deletePanel.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jPanel1.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 110, 40));

        refreshPanel.setBackground(new java.awt.Color(255, 102, 51));
        refreshPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshPanelMouseExited(evt);
            }
        });
        refreshPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refresh.setBackground(new java.awt.Color(255, 102, 51));
        refresh.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refresh.setText("REFRESH");
        refreshPanel.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 40));

        jPanel1.add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activatePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activatePanelMouseClicked
        int selectedUserId = getSelectedUserId(); // Get the selected user's ID

        if (selectedUserId != -1) {
            try {
                connectDb db = new connectDb(); // Create an instance of dbConnector
                Connection conn = db.getConnection(); // Get database connection

                String query = "UPDATE users SET status = 'Active' WHERE user_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, selectedUserId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "User Account Activated Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Activate User Account.");
                }
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a User to Activate.");
        }
    }//GEN-LAST:event_activatePanelMouseClicked

    private void activatePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activatePanelMouseEntered
        activatePanel.setBackground(hoverColor);
    }//GEN-LAST:event_activatePanelMouseEntered

    private void activatePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activatePanelMouseExited
        activatePanel.setBackground(navColor);
    }//GEN-LAST:event_activatePanelMouseExited

    private void addPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseClicked

       userCREATE ad = new userCREATE(); // Create the new internal frame

        JDesktopPane desktopPane = this.getDesktopPane(); // Get the parent DesktopPane

        if (desktopPane != null) { // Check if it's not null before using it
            desktopPane.add(ad); // Add the internal frame to the desktop pane

            // Set the size to fit the parent pane
            ad.setSize(desktopPane.getWidth(), desktopPane.getHeight());
            ad.setPreferredSize(new Dimension(desktopPane.getWidth(), desktopPane.getHeight()));

            // Center the internal frame
            int x = (desktopPane.getWidth() - ad.getWidth()) / 2;
            int y = (desktopPane.getHeight() - ad.getHeight()) / 2;
            ad.setLocation(x, y);

            ad.setVisible(true); // Show the frame

            try {
                ad.setSelected(true); // Bring it to front
            } catch (java.beans.PropertyVetoException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: JDesktopPane is null!"); // Debugging output
        }

        this.dispose();
    }//GEN-LAST:event_addPanelMouseClicked

    private void addPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseEntered
        addPanel.setBackground(hoverColor);
    }//GEN-LAST:event_addPanelMouseEntered

    private void addPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseExited
        addPanel.setBackground(navColor);
    }//GEN-LAST:event_addPanelMouseExited

    private void editPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseClicked

        int selectedRow = users.getSelectedRow(); // Get the selected row

        if (selectedRow != -1) {
            String selectedUsername = users.getValueAt(selectedRow, 4).toString(); // Get username from column index 4

            connectDb connect = new connectDb();
            Connection conn = connect.getConnection();

            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

           try {
            // Retrieve user details using username
            String query = "SELECT first_name, middle_name, last_name, email, contact_number, role, password FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, selectedUsername);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String firstname = rs.getString("first_name");
                String middlename = rs.getString("middle_name");
                String lastname = rs.getString("last_name");
                String email = rs.getString("email");
                String contact = rs.getString("contact_number");
                String role = rs.getString("role");
                String password = rs.getString("password");

                // Open update form with all user details
                userEDIT updateForm = new userEDIT(selectedUsername, firstname, middlename, lastname, email, contact, role, password);
                JDesktopPane desktopPane = this.getDesktopPane();

                if (desktopPane != null) {
                    desktopPane.add(updateForm);
                    updateForm.setSize(desktopPane.getWidth(), desktopPane.getHeight());
                    updateForm.setLocation((desktopPane.getWidth() - updateForm.getWidth()) / 2,
                            (desktopPane.getHeight() - updateForm.getHeight()) / 2);
                    updateForm.setVisible(true);
                    updateForm.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException | java.beans.PropertyVetoException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a User to Edit.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editPanelMouseClicked

    private void editPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseEntered
        editPanel.setBackground(hoverColor);
    }//GEN-LAST:event_editPanelMouseEntered

    private void editPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseExited
        editPanel.setBackground(navColor);
    }//GEN-LAST:event_editPanelMouseExited

    private void deletePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseClicked
        int selectedUserId = getSelectedUserId(); // Get the selected user's ID

        if (selectedUserId != -1) {
            int confirmation = JOptionPane.showConfirmDialog(
                this,
                "Do you want to delete the user information?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    connectDb db = new connectDb(); // Create an instance of dbConnector
                    Connection conn = db.getConnection(); // Get database connection

                    String query = "DELETE FROM users WHERE user_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, selectedUserId);

                    int rowsDeleted = pstmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "User Deleted Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to Delete User.");
                    }
                    pstmt.close();
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a User to Delete.");
        }
    }//GEN-LAST:event_deletePanelMouseClicked

    private void deletePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseEntered
        deletePanel.setBackground(hoverColor);
    }//GEN-LAST:event_deletePanelMouseEntered

    private void deletePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseExited
        deletePanel.setBackground(navColor);
    }//GEN-LAST:event_deletePanelMouseExited

    private void refreshPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseClicked
        loadUsers();
    }//GEN-LAST:event_refreshPanelMouseClicked

    private void refreshPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseEntered
        refreshPanel.setBackground(hoverColor);
    }//GEN-LAST:event_refreshPanelMouseEntered

    private void refreshPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseExited
        refreshPanel.setBackground(navColor);
    }//GEN-LAST:event_refreshPanelMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activate;
    private javax.swing.JPanel activatePanel;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addPanel;
    private javax.swing.JLabel delete;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JLabel edit;
    private javax.swing.JPanel editPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane paneHolder;
    private javax.swing.JLabel refresh;
    private javax.swing.JPanel refreshPanel;
    private javax.swing.JTable users;
    // End of variables declaration//GEN-END:variables
}
