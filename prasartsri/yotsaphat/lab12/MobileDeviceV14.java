/*
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 2, 2025  
 * 
 * Description: 
 * This code creates the MobileDeviceV14 class which extends MobileDeviceV13
 * to add functionality for saving and opening files. It works by reading
 * and writing mobile device data from and to a .txt file.
 */

 package prasartsri.yotsaphat.lab12;

 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.PrintWriter;
 
 import javax.swing.JFileChooser;
 import javax.swing.JOptionPane;
 import java.awt.event.*;
 import javax.swing.SwingUtilities;
 
 import prasartsri.yotsaphat.Lab7.MobileDevice;
 
 // MobileDeviceV14 class extends from MobileDeviceV13
 public class MobileDeviceV14 extends MobileDeviceV13 {
 
     // Constructor for MobileDeviceV14
     public MobileDeviceV14(String title) {
         super(title);
     }
 
     // This method handles events from ActionListener
     @Override
     public void actionPerformed(ActionEvent e) {
         String src = e.getActionCommand(); // Get the action command from the event
         switch (src) {
             case "Save":
                 handleMenuSave(); // If "Save" is clicked, call handleMenuSave
                 break;
             case "Open":
                 handleMenuOpen(); // If "Open" is clicked, call handleMenuOpen
                 break;
             default:
                 super.actionPerformed(e); // If not recognized, use the method from the superclass
         }
     }
 
     // This method opens a file and reads its contents
     protected void handleMenuOpen() {
         JFileChooser fileChooser = new JFileChooser(); // Create a file chooser to select a file
         int returnValue = fileChooser.showOpenDialog(this); // Show open dialog
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile(); // Get the selected file
             JOptionPane.showMessageDialog(this, "Opening " + selectedFile.getAbsolutePath()); // Show message
 
             mobileDevice.clear(); // Clear all existing mobile devices in mobileDevice list
 
             try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                 String line;
                 while ((line = reader.readLine()) != null) { // Read the file line by line
                     String[] data = line.split(": ", 2); // Split the line into type and details
                     if (data.length < 2) continue; // Skip lines that don't have both parts
 
                     String type = data[0].trim(); // Get the type of the device
                     String details = data[1].trim(); // Get the details of the device
 
                     // Find the position of the brand name in the details string
                     int brandStartIndex = details.indexOf('(');
                     int brandEndIndex = details.indexOf(')');
                    
                     // If brand info is incomplete, skip this line
                     if (brandStartIndex == -1 || brandEndIndex == -1 || brandEndIndex < brandStartIndex) continue;
 
                     String name = details.substring(0, brandStartIndex).trim(); // Extract device name
                     String brand = details.substring(brandStartIndex + 1, brandEndIndex).trim(); // Extract brand
                     String priceStr = details.substring(brandEndIndex + 2, details.lastIndexOf(" Baht")).trim(); // Extract price
 
                     try {
                         double price = Double.parseDouble(priceStr); // Convert price from String to Double
                         if (type.equalsIgnoreCase("SmartPhone")) {
                             mobileDevice.add(new SmartPhone(name, brand, price)); // Add SmartPhone to list
                         } else if (type.equalsIgnoreCase("Tablet")) {
                             mobileDevice.add(new Tablet(name, brand, price)); // Add Tablet to list
                         }
                     } catch (NumberFormatException ex) {
                         System.out.println("Error parsing price: " + line); // Handle invalid price format
                     }
                 }
 
                 // Build a message string to display the read devices
                 StringBuilder message = new StringBuilder();
                 message.append("Read devices from the file ").append(selectedFile.getAbsolutePath())
                         .append(" are as follows:\n");
 
                 // Show the devices read from the file
                 for (MobileDevice device : mobileDevice) {
                     message.append(device.toString()).append("\n");
                 }
 
                 JOptionPane.showMessageDialog(this, message.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
 
             } catch (IOException ex) {
                 JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error",
                         JOptionPane.ERROR_MESSAGE); // Handle file reading errors
             }
         }
     }
 
     // This method saves device data to a file
     protected void handleMenuSave() {
         JFileChooser fileChooser = new JFileChooser(); // Create a file chooser to select a file
         int returnValue = fileChooser.showSaveDialog(this); // Show save dialog
 
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile(); // Get the selected file
 
             // If the file doesn't end with .txt, add .txt extension
             if (!selectedFile.getName().endsWith(".txt")) {
                 selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
             }
 
             try (PrintWriter writer = new PrintWriter(new FileWriter(selectedFile))) {
                 for (MobileDevice device : mobileDevice) {
                     writer.println(device); // Write each device's information to the file
                 }
             } catch (IOException ex) {
                 JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error",
                         JOptionPane.ERROR_MESSAGE); // Handle file saving errors
             }
         }
     }
 
     // This method creates and shows the GUI
     public static void createAndShowGUI() {
         MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14"); // Create an instance of MobileDeviceV14
         mdv14.addComponents(); // Add GUI components
         mdv14.addListeners(); // Add listeners for interactions
         mdv14.setFrameFeatures(); // Set up window features
     }
 
     // Main method to run the program
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI(); // Call createAndShowGUI to start the program
             }
         });
     }
 }
 