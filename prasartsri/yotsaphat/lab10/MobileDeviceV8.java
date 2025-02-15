package prasartsri.yotsaphat.lab10;

import java.awt.event.*;
import javax.swing.*;
import prasartsri.yotsaphat.lab9.MobileDeviceV7;

/**
 * This program defines a MobileDeviceV8 class that extends MobileDeviceV7 and implements ActionListener.
 * The MobileDeviceV8 class provides an interface for inputting mobile device information such as name, brand, price, 
 * type, operating system, features, availability, and rating. 
 * It includes event handling for the "OK" and "Cancel" buttons. 
 * When the "OK" button is pressed, the device information entered by the user is displayed in a dialog box.
 * When the "Cancel" button is pressed, all input fields are reset to their default values.
 * 
 * Author: Yotsaphat Prasartsri   
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    /**
     * This method handles the events when either the "OK" or "Cancel" button is clicked.
     * When the "OK" button is pressed, it collects all the data from the input fields and displays it in a dialog box.
     * When the "Cancel" button is pressed, it resets all input fields to their default values.
     * 
     * @param e ActionEvent triggered by the button click
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == okButton) {
            // Show the device information in a dialog box
            JOptionPane.showMessageDialog(null, "Device Name: " + fieldName.getText() + "\n" +
                    "Brand: " + fieldBrand.getText() + "\n" +
                    "Price: " + fieldPrice.getText() + "\n" +
                    "Type: " + (deviceType1.isSelected() ? "Smartphone" : "Tablet") + "\n" +
                    "Operating System: " + opComboBox.getSelectedItem() + "\n" +
                    "Features: " + featureJTextArea.getText() +
                    "Available at: " + inteCampList.getSelectedValue() + "\n" +
                    "Rating: " + rateDevice.getValue(), "Device information", JOptionPane.INFORMATION_MESSAGE);

        } else if (src == cancelButton) {
            // Reset all fields and selections to their default values
            fieldName.setText("");
            fieldBrand.setText("");
            fieldPrice.setText("");
            deviceType1.setSelected(true);
            opComboBox.setSelectedIndex(0);
            featureJTextArea.setText("");
            inteCampList.clearSelection();
            rateDevice.setValue(5);
        }
    }

    /**
     * Constructor for MobileDeviceV8, initializes the superclass MobileDeviceV7 with a title.
     * 
     * @param title The title to be set for the mobile device window
     */
    MobileDeviceV8(String title) {
        super(title);
    }

    /**
     * This method adds the necessary components (UI elements) to the window by calling the superclass method.
     */
    public void addComponents() {
        super.addComponents(); // Call the superclass method to add components
    }

    /**
     * This method adds action listeners to the "OK" and "Cancel" buttons so that the actionPerformed method is triggered.
     */
    public void addListeners() {
        okButton.addActionListener(this); // Add action listener for OK button
        cancelButton.addActionListener(this); // Add action listener for Cancel button
    }

    /**
     * This method creates and shows the GUI, setting up the window with components and listeners.
     */
    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8"); // Create an instance of MobileDeviceV8
        mdv8.addComponents(); // Add components to the window
        mdv8.addListeners(); // Add action listeners
        mdv8.setFrameFeatures(); // Set window features such as size and location
    }

    /**
     * Main method to launch the program. It initializes the GUI on the event dispatch thread.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Create and display the GUI window
            }
        });
    }
}
