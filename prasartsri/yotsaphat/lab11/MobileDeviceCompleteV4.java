package prasartsri.yotsaphat.lab11;

import javax.swing.*; 

import java.awt.Color;
import java.awt.event.*;

/**
 * This program defines the MobileDeviceCompleteV4 class, which extends MobileDeviceCompleteV2.
 * It adds the functionality to customize text color in input fields by using JColorChooser.
 * The user can select a color from the color dialog to apply to the text in the input fields.
 * It also includes the addition of a "Config" menu with an option to open the color chooser.
 *
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 2, 2025
 */
public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 {
    protected JMenu configMenu, color;  // Menu for configuration and color options
    protected JMenuItem customrMI;  // Menu item to open color chooser
    protected JColorChooser  tcc;  // Color chooser for selecting a color

    /**
     * Constructor for MobileDeviceCompleteV4 that initializes the superclass MobileDeviceCompleteV2 with a title.
     * 
     * @param title The title of the mobile device window.
     */
    MobileDeviceCompleteV4(String title) {
        super(title);
    }

    /**
     * Handles action events, including the event triggered by selecting the "Custom" menu item.
     * If the "Custom" menu item is clicked, a color chooser dialog is shown, and the selected color 
     * is applied to the text in the input fields.
     * 
     * @param e The ActionEvent triggered by selecting the menu item.
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        
        // If "Custom" menu item is selected
        if (src == customrMI) {
            // Show the JColorChooser dialog and let the user select a color
            Color newColor = JColorChooser.showDialog(null, "Choose Text Color", topPanel.getForeground());

            // If the user selects a color (newColor != null)
            if (newColor != null) {
                // Apply the selected color to the text fields
                deviceNameField.setForeground(newColor);
                brandField.setForeground(newColor);
                priceField.setForeground(newColor); 
            }
        }
    }

    /**
     * Adds components to the window by calling the superclass method.
     */
    public void addComponents() {
        super.addComponents();
    }

    /**
     * Adds listeners to the window's components, including the action listener for the "Custom" menu item.
     */
    public void addListeners() {
        super.addListeners();
        customrMI.addActionListener(this);  // Add listener to handle custom color selection
    }

    /**
     * Adds the menu bar and the "Config" menu with a "Custom" option for changing text colors.
     */
    protected void addMenus() {
        super.addMenus();
        configMenu = new JMenu("Config");  // Create "Config" menu
        color = new JMenu("Color");  // Create "Color" sub-menu
        customrMI = new JMenuItem("Custom");  // Create menu item to choose custom color

        configMenu.add(color);  // Add "Color" menu to "Config" menu
        color.add(customrMI);  // Add "Custom" item to the "Color" menu

        menuBar.add(configMenu);  // Add "Config" menu to the menu bar
    }

    /**
     * Creates and shows the GUI by adding components, menus, listeners, and setting window features.
     */
    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 mdvcv4 = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        mdvcv4.addComponents();  // Add components to the window
        mdvcv4.addMenus();  // Add menu bar to the window
        mdvcv4.addListeners();  // Add listeners for events
        mdvcv4.setFrameFeatures();  // Set window features like size and location
    }

    /**
     * Main method to launch the program.
     * It invokes the createAndShowGUI method on the event dispatch thread.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {  
            public void run() {
                createAndShowGUI();  // Create and show the GUI window
            }
        });
    }
}
