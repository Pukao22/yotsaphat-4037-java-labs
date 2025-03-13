/*
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 2, 2025  
 * 
 * Description: 
 * This code extends the MobileDeviceV14 class and adds functionality for saving and opening files
 * in either text or binary format. It allows users to choose the format (text or binary) 
 * through the "Format" menu and save/load data accordingly.
 */

 package prasartsri.yotsaphat.lab12;

 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.ObjectInputStream;
 import java.io.ObjectOutputStream;
 import java.io.PrintWriter;
 import java.util.ArrayList;
 
 import javax.swing.ButtonGroup;
 import javax.swing.JFileChooser;
 import javax.swing.JMenu;
 import javax.swing.JOptionPane;
 import javax.swing.JRadioButtonMenuItem;
 import javax.swing.SwingUtilities;
 
 import prasartsri.yotsaphat.Lab7.MobileDevice;
 
 // MobileDeviceV15 class extends MobileDeviceV14 and adds functionality for saving and loading data in different formats
 public class MobileDeviceV15 extends MobileDeviceV14 {
 
     // Constructor for MobileDeviceV15
     public MobileDeviceV15(String title) {
         super(title);
     }
 
     // Declare menu items for format selection (Text or Binary)
     private JRadioButtonMenuItem textFormat, binaryFormat;
     private boolean isBinary = false; // Default format is text
 
     // Override method to add "Format" menu
     @Override
     protected void addMenus() {
         super.addMenus(); // Call the superclass method to add existing menus
 
         // Create a new "Format" menu
         JMenu formatMenu = new JMenu("Format");
 
         // Create radio buttons for text and binary formats
         textFormat = new JRadioButtonMenuItem("Text", true);
         binaryFormat = new JRadioButtonMenuItem("Binary", false);
 
         // Group the radio buttons so that only one can be selected at a time
         ButtonGroup formatGroup = new ButtonGroup();
         formatGroup.add(textFormat);
         formatGroup.add(binaryFormat);
 
         // Set action listeners for the radio buttons
         textFormat.addActionListener(e -> isBinary = false);
         binaryFormat.addActionListener(e -> isBinary = true);
 
         // Add the radio buttons to the format menu
         formatMenu.add(textFormat);
         formatMenu.add(binaryFormat);
 
         // Add the format menu to the main menu
         conFigJMenu.add(formatMenu);
     }
 
     // Override the handleMenuSave method to save data in the selected format
     @Override
     protected void handleMenuSave() {
         JFileChooser fileChooser = new JFileChooser(); // Create a file chooser dialog
         int returnValue = fileChooser.showSaveDialog(this); // Show save dialog
 
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile(); // Get the selected file
             
             // If binary format is selected, save data in binary format
             if (isBinary) {
                 if (!selectedFile.getName().endsWith(".dat")) {
                     selectedFile = new File(selectedFile.getAbsolutePath() + ".dat");
                 }
                 saveBinary(selectedFile);
             } else { // Otherwise, save data in text format
                 if (!selectedFile.getName().endsWith(".txt")) {
                     selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
                 }
                 saveText(selectedFile);
             }
         }
     }
 
     // Method to save data in text format
     private void saveText(File file) {
         try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
             for (MobileDevice device : mobileDevice) {
                 writer.println(device); // Write each device to the file
             }
         } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
 
     // Method to save data in binary format
     private void saveBinary(File file) {
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
             out.writeObject(new ArrayList<>(mobileDevice)); // Write the list of devices to the file in binary format
             JOptionPane.showMessageDialog(this, "Data is saved to " + file.getAbsolutePath());
         } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, "Error saving binary file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
 
     // Override the handleMenuOpen method to load data in the selected format
     @Override
     protected void handleMenuOpen() {
         JFileChooser fileChooser = new JFileChooser(); // Create a file chooser dialog
         int returnValue = fileChooser.showOpenDialog(this); // Show open dialog
 
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile(); // Get the selected file
             mobileDevice.clear(); // Clear old data
 
             // If the file is in binary format, load it as binary
             if (selectedFile.getName().endsWith(".dat")) {
                 loadBinary(selectedFile);
             } else { // Otherwise, load it as text
                 loadText(selectedFile);
             }
         }
     }
 
     // Method to load data in text format
     private void loadText(File file) {
         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 String[] data = line.split(":");
                 if (data.length < 2) continue;
 
                 // Parse name, brand, and price
                 int brandStart = data[1].indexOf('(');
                 int brandEnd = data[1].indexOf(')');
                 if (brandStart == -1 || brandEnd == -1) continue;
 
                 String name = data[1].substring(0, brandStart).trim();
                 String brand = data[1].substring(brandStart + 1, brandEnd).trim();
                 double price = Double.parseDouble(data[1].substring(brandEnd + 1).replace("Baht", "").trim());
 
                 // Create corresponding mobile device objects based on the type
                 if (data[0].equalsIgnoreCase("SmartPhone")) {
                     mobileDevice.add(new SmartPhone(name, brand, price));
                 } else {
                     mobileDevice.add(new Tablet(name, brand, price));
                 }
             }
 
             // Display the loaded devices in a message dialog
             StringBuilder message = new StringBuilder();
             message.append("Read devices from the file ").append(file.getAbsolutePath()).append(" are as follows:\n");
 
             for (MobileDevice device : mobileDevice) {
                 message.append(device.toString()).append("\n");
             }
 
             JOptionPane.showMessageDialog(this, message.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
         } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
 
     // Method to load data in binary format
     private void loadBinary(File file) {
         try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
             mobileDevice = (ArrayList<MobileDevice>) in.readObject(); // Read the list of devices from the binary file
             showDevices(file); // Display the loaded devices
         } catch (IOException | ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(this, "Error reading binary file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         }
     }
 
     // Display the loaded devices in a message dialog
     private void showDevices(File file) {
         StringBuilder message = new StringBuilder();
         message.append("Read devices from the file ").append(file.getAbsolutePath()).append(" are as follows:\n");
 
         for (MobileDevice device : mobileDevice) {
             message.append(device.toString()).append("\n");
         }
 
         JOptionPane.showMessageDialog(this, message.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
     }
 
     // Method to create and display the GUI
     public static void createAndShowGUI() {
         MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
         mdv15.addComponents(); // Add the components to the frame
         mdv15.addListeners(); // Add listeners for events
         mdv15.setFrameFeatures(); // Set window features
     }
 
     // Main method to start the application
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI(); // Call the method to initialize the GUI
             }
         });
     }
 }
 