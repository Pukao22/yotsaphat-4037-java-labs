/**
 * This program creates a simple window with two buttons: "OK" and "Cancel".
 * When the window is opened, the two buttons will be displayed.
 * The "OK" button and "Cancel" button are placed in a panel, 
 * and the window itself is centered and can be closed properly.
 * 
 * Author: Yotsaphat Prasartsri
 * ID : 673040403-7
 * Sec : 1
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.Lab8;

 import javax.swing.*;
 
 public class MySimpleWindow extends JFrame {
     protected JButton cancelButton;
     protected JButton okButton;
     protected JPanel mainPanel;
     protected JPanel buttonPanel;
 
     // Constructor that sets the window title
    public MySimpleWindow(String title) {
         super(title);
     }
 
     // Method to add components (buttons and panels) to the window
     protected void addComponents() {
         okButton = new JButton("OK");  // Create "OK" button
         cancelButton = new JButton("Cancel");  // Create "Cancel" button
         mainPanel = new JPanel();  // Main panel to hold everything
         buttonPanel = new JPanel();  // Panel to hold the buttons
 
         // Add buttons to the button panel
         buttonPanel.add(cancelButton);
         buttonPanel.add(okButton);
 
         // Add the button panel to the main panel
         mainPanel.add(buttonPanel);
 
         // Add the main panel to the frame
         this.add(mainPanel);
     }
 
     // Method to set up the frame features like closing behavior, visibility, etc.
     public void setFrameFeatures() {
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close on exit
         this.setVisible(true);  // Make the window visible
         this.pack();  // Adjust window size to fit its contents
         this.setLocationRelativeTo(null);  // Center the window on the screen
     }
 
     // Method to create and display the window
     public static void createAndShowGUI() {
         MySimpleWindow msw = new MySimpleWindow("My Simple Window");  // Create window
         msw.addComponents();  // Add components to the window
         msw.setFrameFeatures();  // Set up window features
     }
 
     // Main method to invoke the window creation in the event dispatch thread
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI();  // Create and show the window
             }
         });
     }
 }
 