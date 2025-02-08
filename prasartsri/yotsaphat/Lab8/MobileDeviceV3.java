/**
 * This program creates a mobile device interface (MobileDeviceV3) with a menu bar.
 * The menu bar includes "File" options (New, Open, Save, Exit) and "Config" options 
 * such as size, color, and font settings. 
 * The interface is built on top of MobileDeviceV2, adding more functionality and a better UI.
 * 
 * Author: Yotsaphat Prasartsri
 * ID : 673040403-7
 * Sec : 1
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.Lab8;

 import java.awt.*;
 import javax.swing.*;
 
 public class MobileDeviceV3 extends MobileDeviceV2 {
 
     protected JMenuBar menuBar;  // The menu bar
     protected JPanel nortPanel;  // Panel to hold the menu bar
     protected JMenu fileMenu, conFigJMenu, size, color, font;  // Menus for file, configuration, size, color, and font
     protected JMenuItem nEw, open, save, exit, small, medium, large, extraLarge,
                         black, red, green, blue, f1, f2, f3;  // Menu items for each option
 
     // Constructor that calls the parent constructor and sets the title
    public MobileDeviceV3(String title) {
         super(title);
     }
 
     // Method to add components to the window (menu items and panels)
     protected void addComponents() {
         super.addComponents();  // Add components from the parent class (MobileDeviceV2)
         addMenus(); // call addMenus method
     }
     protected void addMenus(){
         // Initialize the panels and menu items
         nortPanel = new JPanel();
         nortPanel.setLayout(new BorderLayout());
         menuBar = new JMenuBar();
         fileMenu = new JMenu("File");
         conFigJMenu = new JMenu("ConFig");
         size = new JMenu("Size");
         color = new JMenu("Color");
         font = new JMenu("Font");
 
         // Initialize menu items
         nEw = new JMenuItem("New");
         open = new JMenuItem("Open");
         save = new JMenuItem("Save");
         exit = new JMenuItem("Exit");
         small = new JMenuItem("Small");
         medium = new JMenuItem("Medium");
         large = new JMenuItem("Large");
         extraLarge = new JMenuItem("Extra Large");
         black = new JMenuItem("Black");
         red = new JMenuItem("Red");
         green = new JMenuItem("Green");
         blue = new JMenuItem("Blue");
         f1 = new JMenuItem("Font 1");
         f2 = new JMenuItem("Font 2");
         f3 = new JMenuItem("Font 3");
 
         // Add items to the respective menus
         size.add(small);
         size.add(medium);
         size.add(large);
         size.add(extraLarge);
 
         color.add(black);
         color.add(red);
         color.add(green);
         color.add(blue);
 
         font.add(f1);
         font.add(f2);
         font.add(f3);
 
         // Add menus to the configuration menu
         conFigJMenu.add(size);
         conFigJMenu.add(color);
         conFigJMenu.add(font);
 
         // Add file menu items to the file menu
         fileMenu.add(nEw);
         fileMenu.add(open);
         fileMenu.add(save);
         fileMenu.add(exit);
 
         // Add menus to the menu bar
         menuBar.add(fileMenu);
         menuBar.add(conFigJMenu);
 
         // Add the menu bar to the north panel
         nortPanel.add(menuBar, BorderLayout.NORTH);
         nortPanel.add(fromPanel, BorderLayout.SOUTH);  // Assuming 'fromPanel' is defined elsewhere
         mainPanel.add(nortPanel, BorderLayout.NORTH);

     }


 
     // Method to create and show the GUI window
     public static void createAndShowGUI() {
         MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
         mdv3.addComponents();  // Add components to the window
         mdv3.setFrameFeatures();  // Set window features (like size, location)
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
 