/*
 * This class extends MobileDeviceV5 and adds additional customization 
 * for the appearance of the GUI components such as changing fonts, colors, 
 * and background for labels, buttons, and text fields.
 * 
 * Output:
 * The program customizes the appearance of labels, text fields, and buttons 
 * with specific fonts, colors, and background settings for a more personalized look.
 * 
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.lab9;
 import javax.swing.*;
 import java.awt.*;
 
 public class MobileDeviceV6 extends MobileDeviceV5 {
 
     // Constructor that calls the superclass constructor
     MobileDeviceV6(String title) {
         super(title);
     }
 
     // Method to add components to the window
     protected void addComponents() {
         super.addComponents(); // Add components from the superclass
 
         // Change the font and color for various panels
         changeLabelFont(fromPanel);
         changeLabelFont(extraPanel);
         changeLabelFont(buttonPanel);
         changeLabelFont(reateDevicPanel);
         changeLabelFont(inteCampPanel);
 
         // Customize the JTextArea with a background and text color
         featureJTextArea.setBackground(new Color(255, 255, 224));  // Light yellow background
         featureJTextArea.setForeground(Color.DARK_GRAY);  // Dark gray text color
 
         // Customize the JList for available carriers (inteCampList)
         inteCampList.setForeground(new Color(0, 64, 0));  // Dark green text color
         inteCampList.setBackground(Color.LIGHT_GRAY);  // Light gray background
         inteCampList.setSelectionBackground(Color.YELLOW);  // Yellow selection background
         inteCampList.setSelectionForeground(Color.BLACK);  // Black selection text color
     }
 
     // Method to change the font and color of labels, text fields, and buttons within a given panel
     public static void changeLabelFont(JPanel panel) {
         // Define the font and color for the labels
         Font font = new Font("Arial", Font.BOLD, 14);  // Arial font, bold, size 14
         Color fontColor = new Color(0, 0, 80);  // Dark blue text color
 
         // Loop through all components in the panel
         for (Component comp : panel.getComponents()) {
             if (comp instanceof JLabel) {
                 JLabel label = (JLabel) comp;
                 label.setFont(font);  // Set the font
                 label.setForeground(fontColor);  // Set the font color
             }
             if (comp instanceof JTextField) {
                 // Customize JTextField (text box)
                 JTextField textField = (JTextField) comp;
                 textField.setBackground(Color.LIGHT_GRAY);  // Set background to light gray
                 textField.setForeground(Color.DARK_GRAY);   // Set text color to dark gray
             }
 
             if (comp instanceof JButton) {
                 // Customize JButton (button)
                 JButton button = (JButton) comp;
                 if (button.getText().equals("OK")) {
                     // If the button text is "OK", set its color to green and white background
                     button.setForeground(Color.GREEN);
                     button.setBackground(Color.WHITE);
                 } else if (button.getText().equals("Cancel")) {
                     // If the button text is "Cancel", set its color to red and white background
                     button.setForeground(Color.RED);
                     button.setBackground(Color.WHITE);
                 }
             }
         }
     }
 
     // Method to create and display the GUI
     public static void createAndShowGUI() {
         MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
         mdv6.addComponents();  // Add components to the window
         mdv6.setFrameFeatures();  // Set window features like size, location, etc.
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
 