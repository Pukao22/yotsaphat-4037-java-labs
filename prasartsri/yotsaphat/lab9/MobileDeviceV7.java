/*
 * This class extends MobileDeviceV6 and adds additional features such as 
 * setting default values for fields and displaying an image of the Samsung Galaxy S25 Ultra.
 * It includes pre-set device information like name, brand, price, and features.
 * 
 * Output:
 * The program shows the Samsung Galaxy S25 Ultra with device details (name, brand, price),
 * features listed in a text area, and an image of the device.
 * 
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.lab9;

 import javax.swing.SwingUtilities;
 import java.awt.*;
 
 public class MobileDeviceV7 extends MobileDeviceV6 {
 
     // Constructor that calls the superclass constructor
     MobileDeviceV7(String title) {
         super(title);
     }
 
     // Method to add components to the window
     protected void addComponents() {
         super.addComponents(); // Add components from the superclass
 
         // Set pre-defined text values for device fields
         fieldName.setText("Samsung Galaxy S25 Ultra");  // Set device name
         fieldBrand.setText("Samsung");  // Set brand name
         fieldPrice.setText("46,900");  // Set price
 
         // Set the feature text with a list of features for the device
         featureJTextArea.setText("-200MP Camera -1TB Storage -Snapdragon Gen 4 Processor -5000mAh Battery -6.8-inch AMOLED Display -120Hz Refresh Rate -Fast Charging"
                 .replace("-", "\n-"));  // Format features with line breaks
 
         // Set the initial value of the rating slider
         rateDevice.setValue(9);  // Set rating to 9
 
         // Create a ReadImage object to display the device's image
         myImage = new ReadImage("prasartsri/yotsaphat/lab9/images/S25-ultra.jpg");
         myImage.setSize(new Dimension(10, 10));  // Set the size of the image
         latestPanel.add(myImage);  // Add the image to the panel
 
         // Note: The previous code for ReadImage functionality is commented out.
     }
 
     // Declare a ReadImage object for displaying the device's image
     protected ReadImage myImage;
 
     // Method to create and display the GUI
     public static void createAndShowGUI() {
         MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
         mdv7.addComponents();  // Add components to the window
         mdv7.setFrameFeatures();  // Set window features like size, location
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
 