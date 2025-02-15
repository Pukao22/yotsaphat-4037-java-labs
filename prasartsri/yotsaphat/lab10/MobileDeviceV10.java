package prasartsri.yotsaphat.lab10;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

/**
 * This program defines the MobileDeviceV10 class, which extends MobileDeviceV9, 
 * and adds additional functionality including handling changes in ratings, 
 * vendor selection from a list, and operating system selection from a combo box. 
 * The program interacts with the user through dialog boxes to display information 
 * about the selected rating, vendor, and operating system. 
 * It also provides the ability to adjust the rating, select a vendor from a list, 
 * and choose an operating system from a dropdown menu.
 * 
 * Author: Yotsaphat Prasartsri   
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener {
    
    /**
     * Constructor for MobileDeviceV10 that initializes the superclass MobileDeviceV9 with a title.
     * 
     * @param title The title of the mobile device window.
     */
    MobileDeviceV10(String title) {
        super(title);
    }

    /**
     * Adds components (UI elements) to the window by calling the superclass method.
     */
    public void addComponents() {
        super.addComponents();
    }

    /**
     * Handles the event when the rating slider value is changed.
     * It shows a dialog box displaying the new rating value.
     * 
     * @param e The ChangeEvent triggered when the rating is adjusted.
     */
    public void stateChanged(ChangeEvent e) {
        int value = rateDevice.getValue();
        JOptionPane.showMessageDialog(null, "New rating: " + value, "Rating Adjustment",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the event when a new vendor is selected from the list.
     * It shows a dialog box displaying the name of the selected vendor.
     * 
     * @param e The ListSelectionEvent triggered when a new vendor is selected.
     */
    public void valueChanged(ListSelectionEvent e) {
        String selectedinteCamplist = inteCampList.getSelectedValue();
        JOptionPane.showMessageDialog(null, "Device Available at: " + selectedinteCamplist, "Vendor Selection",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the event when the operating system is selected from the combo box.
     * It shows a dialog box displaying the selected operating system.
     * 
     * @param e The ActionEvent triggered when an operating system is selected.
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);  // Calls the superclass method to handle other actions
        String selectedopValue = (String) opComboBox.getSelectedItem();
        JOptionPane.showMessageDialog(null, "You selected Operating System: " + selectedopValue, "OS Selection",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Adds action listeners to the various components for rating, vendor selection, and OS selection.
     */
    public void addListeners() {
        super.addListeners();
        rateDevice.addChangeListener(this);  // Add change listener for the rating slider
        inteCampList.addListSelectionListener(this);  // Add list selection listener for the vendor list
        opComboBox.addActionListener(this);  // Add action listener for the operating system combo box
    }

    /**
     * Creates and shows the GUI by adding components and setting up listeners.
     */
    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents(); // Add components to the window
        mdv10.addListeners();  // Add listeners to the components
        mdv10.setFrameFeatures(); // Set window features like size, location
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
