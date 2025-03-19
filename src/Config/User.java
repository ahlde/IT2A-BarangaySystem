package Config;

import javax.swing.JDesktopPane;

public class User {
    private static User instance;
    private int userId;
    private String username;
    private String role;
    private JDesktopPane mydesktop; // Declare mydesktop properly

    // Private constructor for Singleton pattern
    private User() {
        this.mydesktop = new JDesktopPane(); // Initialize mydesktop
    }

    // Get the single instance of User
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    // Set user details
    public void setUser(int userId, String username, String role) {
        this.userId = userId;
        this.username = username;
        this.role = role;
    }

    // Get user details
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    // Clear user session
    public void clearSession() {
        this.userId = 0;
        this.username = null;
        this.role = null;
    }

    // Set and Get DesktopPane
    public void setDesktopPane(JDesktopPane mydesktop) {
        this.mydesktop = mydesktop;
    }
    
    public JDesktopPane getDesktopPane() {
        return mydesktop;
    }
}
