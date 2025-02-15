package prasartsri.yotsaphat.lab10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.*;

/**
 * This program defines the MobileDeviceV11 class, which extends MobileDeviceV10, 
 * and introduces the handling of item state changes for selecting device types. 
 * The program also supports keyboard shortcuts and accelerators for actions like 
 * creating a new device, saving, opening, and exiting the program. 
 * When a user selects a device type, a dialog box is shown indicating the selected device type.
 * 
 * Author: Yotsaphat Prasartsri   
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

public class MobileDeviceV11 extends MobileDeviceV10 implements ItemListener {
    
    /**
     * Constructor for MobileDeviceV11 that initializes the superclass MobileDeviceV10 with a title.
     * 
     * @param title The title of the mobile device window.
     */
    MobileDeviceV11(String title) {
        super(title);
    }

    /**
     * Handles item state changes when a device type radio button is selected.
     * It shows a dialog box displaying the selected device type.
     * 
     * @param e The ItemEvent triggered when a radio button selection changes.
     */
    public void itemStateChanged(ItemEvent e) {
        if (deviceType1.isSelected()) {
            JOptionPane.showMessageDialog(null, deviceType1.getText() + " is selected");
        } else if (deviceType2.isSelected()) {
            JOptionPane.showMessageDialog(null, deviceType2.getText() + " is selected");
        }
    }

    /**
     * Adds components (UI elements) to the window and sets up keyboard accelerators 
     * and mnemonics for menu actions such as new, save, open, and exit.
     */
    public void addComponents() {
        super.addComponents();
        
        // Set mnemonics for menu items
        nEw.setMnemonic(KeyEvent.VK_N);
        save.setMnemonic(KeyEvent.VK_S);
        open.setMnemonic(KeyEvent.VK_O);
        exit.setMnemonic(KeyEvent.VK_X);

        // Set keyboard accelerators for menu actions with CTRL key
        nEw.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
    }

    /**
     * Handles the event when a new vendor is selected from the list.
     * Calls the superclass method to show the vendor selection dialog.
     * 
     * @param e The ListSelectionEvent triggered when a new vendor is selected.
     */
    public void valueChanged(ListSelectionEvent e) {
        super.valueChanged(e);
    }

    /**
     * Handles the event when the rating slider value is changed.
     * Calls the superclass method to show the rating adjustment dialog.
     * 
     * @param e The ChangeEvent triggered when the rating slider value changes.
     */
    public void stateChanged(ChangeEvent e) {
        super.stateChanged(e);
    }

    /**
     * Handles other actions when buttons like OK and Cancel are clicked.
     * Calls the superclass method to perform those actions.
     * 
     * @param e The ActionEvent triggered when a button is clicked.
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    /**
     * Adds listeners for item selection (device type) along with other listeners inherited from superclass.
     */
    public void addListeners() {
        super.addListeners();
        deviceType1.addItemListener(this);  // Add item listener for the first device type
        deviceType2.addItemListener(this);  // Add item listener for the second device type
    }

    /**
     * Creates and shows the GUI by adding components and setting up listeners.
     */
    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.addComponents(); // Add components to the window
        mdv11.addListeners();  // Add listeners to the components
        mdv11.setFrameFeatures(); // Set window features like size, location
    }

    /**
     * Main method to launch the program.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Create and show the GUI window
            }
        });
    }
}
