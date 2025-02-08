/*
 * This class extends the MobileDeviceV3 class and represents a more advanced version, MobileDeviceV4. 
 * It adds additional features such as icons, font sizes, colors, and fonts for the menu options.
 * 
 * Output:
 * The program creates a mobile device interface with menus for new, save, open, and exit, 
 * with icons, adjustable font sizes, color options, and font styles for the user interface.
 * 
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.lab9;

 import javax.swing.ImageIcon;
 import javax.swing.SwingUtilities;
 
 import java.awt.*;
 import prasartsri.yotsaphat.Lab8.MobileDeviceV3;
 
 public class MobileDeviceV4 extends MobileDeviceV3 {
 
     // Constructor that passes the title to the superclass
     MobileDeviceV4(String title) {
         super(title);
     }
 
     // Method to add components to the window
     protected void addComponents() {
         super.addComponents();  // Add components from the superclass
         addMenus();  // Add additional menu items
     }
 
     // Method to add menu items with features such as icons, size, color, and fonts
     protected void addMenus() {
         super.addMenus();  // Add menus from the superclass
         setIcon();  // Set the icons for menu items
         setSize();  // Set font sizes for menu options
         setColor();  // Set text colors for menu options
         setFont();   // Set fonts for menu options
     }
 
     // Method to set icons for different menu items
     protected void setIcon() {
         nEw.setIcon(new ImageIcon(
                 getClass().getClassLoader().getResource("images/new_icon.png")));
         save.setIcon(new ImageIcon(
                 getClass().getClassLoader().getResource("images/save_icon.png")));
         open.setIcon(new ImageIcon(
                 getClass().getClassLoader().getResource("images/open_icon.png")));
         exit.setIcon(new ImageIcon(
                 getClass().getClassLoader().getResource("images/exit_icon.png")));
     }
 
     // Method to set font sizes for the menu options
     protected void setSize() {
         small.setFont(new Font("Small", Font.PLAIN, 10));
         medium.setFont(new Font("Medium", Font.PLAIN, 14));
         large.setFont(new Font("Large", Font.PLAIN, 18));
         extraLarge.setFont(new Font("Extra Large", Font.PLAIN, 22));
     }
 
     // Method to set colors for menu options
     protected void setColor() {
         black.setForeground(Color.BLACK);
         red.setForeground(Color.RED);
         green.setForeground(Color.GREEN);
         blue.setForeground(Color.BLUE);
     }
 
     // Method to set fonts for the menu options
     protected void setFont() {
         f1.setFont(new Font("Serif", Font.PLAIN, 14));
         f2.setFont(new Font("SansSerif", Font.PLAIN, 14));
         f3.setFont(new Font("Monospaced", Font.PLAIN, 14));
     }
 
     // Method to create and display the GUI
     public static void createAndShowGUI() {
         MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
         mdv4.addComponents();  // Add components to the window
         mdv4.setFrameFeatures();  // Set window features like size and location
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
 