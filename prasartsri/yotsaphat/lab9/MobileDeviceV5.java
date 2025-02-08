/*
 * This class extends MobileDeviceV4 and adds additional features such as a list of available carriers
 * and a rating slider for the device.
 * It includes a JList for displaying available carriers and a JSlider to rate the device.
 * 
 * Output:
 * The program creates a user interface with a list of mobile carriers, a slider to rate the device (0-10),
 * and a layout with these components arranged in a structured manner.
 * 
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.lab9;

 import javax.swing.*;
 import java.awt.*;
 
 public class MobileDeviceV5 extends MobileDeviceV4 {
     
     // Declare components for the new features
     protected JList<String> inteCampList;
     protected String[] inteCamp = {"AIS", "True", "DTAC", "Shopee"};
     protected JPanel inteCampPanel, reateDevicPanel, latestPanel;
     protected JLabel inteCampLabel, rateDevicLabel;
     protected JSlider rateDevice;
     protected JScrollPane inteJScrollPane;
 
     // Constructor that calls the superclass constructor
     MobileDeviceV5(String title) {
         super(title);
     }
 
     // Method to add components to the window
     protected void addComponents() {
         super.addComponents(); // Add components from the superclass
 
         // Create and configure the label and list for available carriers
         inteCampLabel = new JLabel("The device is available at: ");
         inteCampList = new JList<>(inteCamp); // Create the list with carrier options
         inteCampList.setVisibleRowCount(4); // Set visible row count
         inteCampList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selections
         inteCampList.setSelectedIndex(0); // Set the default selection
 
         // Add the list to a scroll pane
         inteJScrollPane = new JScrollPane(inteCampList);
 
         // Create and configure the slider for device rating
         rateDevice = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
         rateDevice.setMajorTickSpacing(1);
         rateDevice.setPaintTicks(true); // Show ticks
         rateDevice.setPaintLabels(true); // Show labels for each tick
 
         rateDevicLabel = new JLabel("Rate the device (0-10): ");
 
         // Panel to hold the carrier options
         inteCampPanel = new JPanel();
         inteCampPanel.setLayout(new GridLayout(1, 2)); // Two-column layout
         inteCampPanel.add(inteCampLabel);
         inteCampPanel.add(inteJScrollPane);
 
         // Panel to hold the rating slider
         reateDevicPanel = new JPanel();
         reateDevicPanel.setLayout(new BorderLayout()); // Border layout
         reateDevicPanel.add(rateDevicLabel, BorderLayout.CENTER);
         reateDevicPanel.add(rateDevice, BorderLayout.SOUTH);
 
         // Panel to organize all components
         latestPanel = new JPanel();
         latestPanel.setLayout(new GridLayout(4, 1)); // Four-row layout
         latestPanel.add(extraPanel); // Assuming `extraPanel` is already defined
         latestPanel.add(inteCampPanel);
         latestPanel.add(reateDevicPanel);
 
         // Add the latestPanel to the mainPanel
         mainPanel.add(latestPanel, BorderLayout.CENTER);
     }
 
     // Method to create and show the GUI
     public static void createAndShowGUI() {
         MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
         mdv5.addComponents(); // Add components to the window
         mdv5.setFrameFeatures(); // Set window features (like size, location)
     }
 
     // Main method to launch the program
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI(); // Create and show the GUI window
             }
         });
     }
 }
 