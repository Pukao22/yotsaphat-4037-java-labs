/**
 * This program creates a mobile device interface (MobileDeviceV2) that includes options for selecting the 
 * operating system and displaying its features. The user can choose between different operating systems 
 * (Android, iOS, Windows, Others) and enter relevant features in a text area. 
 * The features are displayed in a scrollable text area.
 * 
 * Author: Yotsaphat Prasartsri
 * ID : 673040403-7
 * Sec : 1
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.Lab8;

 import java.awt.*;
 import javax.swing.*;
 
 public class MobileDeviceV2 extends MobileDeviceV1 {
     protected JLabel opLabel, feature;  // Labels for operating system and feature
     protected JComboBox<String> opComboBox;  // Combo box for selecting the operating system
     protected JPanel extraPanel;  // Panel for extra components
     protected JTextArea featureJTextArea;  // Text area for entering device features
     protected JScrollPane scrollPane;  // Scroll pane for the text area
 
     // Constructor that calls the parent constructor and sets the title
     MobileDeviceV2(String title) {
         super(title);
     }
 
     // Method to add components to the window
     protected void addComponents() {
         super.addComponents();  // Call parent class method to add basic components
 
         // Initialize the components
         opLabel = new JLabel("Operating System:");  // Label for operating system
         feature = new JLabel("Feature:");  // Label for features
 
         extraPanel = new JPanel();  // Create a new panel for additional components
         extraPanel.setLayout(new GridLayout(2, 2));  // Set the layout to a grid with 2 rows and 2 columns
 
         featureJTextArea = new JTextArea(3, 25);  // Create a text area with 3 rows and 25 columns
         featureJTextArea.setText("");  // Initialize text area with empty text
         featureJTextArea.setLineWrap(true);  // Enable line wrapping
         featureJTextArea.setWrapStyleWord(true);  // Enable word wrapping
 
         opComboBox = new JComboBox<>();  // Create a combo box for selecting operating systems
         opComboBox.addItem("Android");  // Add Android option
         opComboBox.addItem("iOS");  // Add iOS option
         opComboBox.addItem("Windows");  // Add Windows option
         opComboBox.addItem("Others");  // Add Other option
 
         // Add components to the panel
         extraPanel.add(opLabel);
         extraPanel.add(opComboBox);
         extraPanel.add(feature);
         scrollPane = new JScrollPane(featureJTextArea);  // Add the text area to a scroll pane
         extraPanel.add(scrollPane);
 
         // Add the extra panel to the main panel in the center region
         mainPanel.add(extraPanel, BorderLayout.CENTER);
     }
 
     // Method to create and show the GUI window
     public static void createAndShowGUI() {
         MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");  // Create the window
         mdv2.addComponents();  // Add components to the window
         mdv2.setFrameFeatures();  // Set up window features such as size and location
     }
 
     // Main method to launch the program
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI();  // Create and show the GUI window
             }
         });
     }
 }
 