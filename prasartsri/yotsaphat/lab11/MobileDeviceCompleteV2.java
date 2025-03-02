package prasartsri.yotsaphat.lab11;

import javax.swing.*;            

import java.awt.event.*;      
/**
 * This program defines the MobileDeviceCompleteV2 class, which extends the MobileDeviceComplete class. 
 * It is designed to handle the functionality of input fields for device name, brand, and price, 
 * and shows a notification with the corresponding value when the Enter key is pressed in any of the fields. 
 * The program uses the ActionListener interface to detect when a user interacts with the text fields.
 *
 * Author: Yotsaphat Prasartsri   
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 2, 2025
 */

 public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

    /**
     * Constructor for MobileDeviceCompleteV2 that initializes the superclass MobileDeviceComplete with a title.
     * 
     * @param title The title of the mobile device window.
     */
    MobileDeviceCompleteV2(String title) {
        super(title);
    }

    /**
     * This method handles the action event triggered when the user presses Enter in any of the input fields.
     * It checks which field was pressed and displays a dialog box with the corresponding input value.
     * 
     * @param e The ActionEvent triggered by pressing Enter in one of the fields.
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == deviceNameField) {
            JOptionPane.showMessageDialog(null, "You pressed Enter in Device Name field: "+deviceNameField.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == brandField) {
            JOptionPane.showMessageDialog(null, "Brand field says: "+brandField.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == priceField) {
            JOptionPane.showMessageDialog(null, "Price entered: "+priceField.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Adds components to the window by calling the superclass method.
     */
    public void addComponents() {
        super.addComponents(); 
    }

    /**
     * Adds menus to the window by calling the superclass method.
     */
    protected void addMenus() {
        super.addMenus();
    }

    /**
     * Adds action listeners to the input fields for device name, brand, and price.
     */
    public void addListeners() {
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    /**
     * Creates and shows the GUI by adding components, menus, and listeners, and then setting window features.
     */
    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 mdvcv2 = new MobileDeviceCompleteV2("Mobile Device Complete V2"); 
        mdvcv2.addComponents(); 
        mdvcv2.addMenus();
        mdvcv2.addListeners(); 
        mdvcv2.setFrameFeatures(); 
    }

    /**
     * Main method to launch the program.
     * It invokes the createAndShowGUI method on the event dispatch thread.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}