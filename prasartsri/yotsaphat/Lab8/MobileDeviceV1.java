/**
 * This program creates a simple interface for entering mobile device information. 
 * It includes fields for device name, brand, price, and type (Smartphone or Tablet). 
 * The user can input information into text fields, and select a device type using radio buttons.
 * 
 * Author: Yotsaphat Prasartsri
 * ID : 673040403-7
 * Sec : 1
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.Lab8;

 import java.awt.BorderLayout;
 import java.awt.GridLayout;
 import javax.swing.*;
 
 public class MobileDeviceV1 extends MySimpleWindow {
     protected JLabel deviceName, brand, price, type;  // Labels for the device attributes
     protected JTextField fieldName, fieldBrand, fieldPrice;  // Text fields for inputting device details
     protected JRadioButton deviceType1, deviceType2;  // Radio buttons for selecting device type (Smartphone or Tablet)
     protected ButtonGroup deviceTypeGroup;  // Button group to manage radio button selection
     protected JPanel fromPanel, typePanel;  // Panels for organizing the components
 
     // Constructor that calls the parent constructor and sets the title
     MobileDeviceV1(String title) {
         super(title);
     }
 
     // Method to add components to the window
     protected void addComponents() {
         super.addComponents();  // Call the parent class method to add basic components
 
         // Initialize the panels and components
         fromPanel = new JPanel();
         fromPanel.setLayout(new GridLayout(4, 2));  // Layout with 4 rows and 2 columns
 
         // Initialize labels for device details
         deviceName = new JLabel("Device Name:");
         brand = new JLabel("Brand:");
         price = new JLabel("Price:");
         type = new JLabel("Type:");
 
         // Initialize radio buttons for device type
         deviceType1 = new JRadioButton("SmartPhone");
         deviceType2 = new JRadioButton("Tablet");
         deviceTypeGroup = new ButtonGroup();  // Create a button group for the radio buttons
         deviceTypeGroup.add(deviceType1);  // Add the first radio button to the group
         deviceTypeGroup.add(deviceType2);  // Add the second radio button to the group
         deviceType1.setSelected(true);  // Set the default selection to "SmartPhone"
 
         // Initialize text fields for device name, brand, and price
         fieldName = new JTextField(15);
         fieldBrand = new JTextField(15);
         fieldPrice = new JTextField(15);
 
         // Panel for organizing the radio buttons
         typePanel = new JPanel();
         typePanel.add(deviceType1);  // Add the "SmartPhone" radio button to the panel
         typePanel.add(deviceType2);  // Add the "Tablet" radio button to the panel
 
         // Add labels and input fields to the form panel
         fromPanel.add(deviceName);
         fromPanel.add(fieldName);
         fromPanel.add(brand);
         fromPanel.add(fieldBrand);
         fromPanel.add(price);
         fromPanel.add(fieldPrice);
         fromPanel.add(type);
         fromPanel.add(typePanel);
 
         // Set the layout of the main panel and add the form and button panels
         mainPanel.setLayout(new BorderLayout());
         mainPanel.add(buttonPanel, BorderLayout.SOUTH);  // Add the button panel to the south
         mainPanel.add(fromPanel, BorderLayout.NORTH);  // Add the form panel to the north
         this.add(mainPanel);  // Add the main panel to the window
     }
 
     // Method to create and show the GUI window
     public static void createAndShowGUI() {
         MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");  // Create the window
         mdv1.addComponents();  // Add components to the window
         mdv1.setFrameFeatures();  // Set up window features such as size and location
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
 