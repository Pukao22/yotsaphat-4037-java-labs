package prasartsri.yotsaphat.lab12;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;

import prasartsri.yotsaphat.lab10.MobileDeviceV11;

import java.awt.event.*;

/**
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 14, 2025
 * 
 * This class extends MobileDeviceV11 and adds additional functionality
 * such as handling text fields, adding listeners, and setting up the GUI.
 */
public class MobileDeviceV12 extends MobileDeviceV11 {
    // Constructor to initialize the frame with a title
    MobileDeviceV12(String title) {
        super(title);
    }

    // Adds components and sets names for the text fields
    public void addComponents(){
        super.addComponents(); // Calls the parent class's method to add base components
        fieldName.setName("Device Name"); // Sets a name for the fieldName text field
        fieldBrand.setName("Brand"); // Sets a name for the fieldBrand text field
        fieldPrice.setName("Price"); // Sets a name for the fieldPrice text field
    }

    // Creates and shows the GUI
    public static void createAndShowGUI() {
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12"); // Creates an instance of MobileDeviceV12
        mdv12.addComponents();  // Adds UI components
        mdv12.addListeners();   // Adds event listeners
        mdv12.setFrameFeatures(); // Sets frame properties
    }

    // Handles text field input validation for general text fields
    public static void handleNormalTextField(JTextField tf,JComponent nextComponent){
        String input = tf.getText(); // Gets the text entered by the user
        String name = tf.getName();  // Retrieves the field's name
        
        if (input.isEmpty()) {
            // If the field is empty, show an error message and disable the next component
            JOptionPane.showMessageDialog(tf, "Please enter some data in " + name, "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow(); // Set focus back to the text field
            nextComponent.setEnabled(false);
        } else {
            // If the input is valid, show a confirmation message and enable the next component
            JOptionPane.showMessageDialog(tf, name + " is changed to " + input, "Message", JOptionPane.INFORMATION_MESSAGE);
            nextComponent.setEnabled(true);
        }
    }

    // Handles text field input validation for positive numbers
    public static void handlePosNumTextField(JTextField tf, JComboBox<String> nextComponent) {
        String name = tf.getName(); // Retrieves the field's name
        String input = tf.getText(); // Gets the text entered by the user
    
        if (input == null || input.isEmpty()) {
            // If the field is empty, show an error message and disable the next component
            JOptionPane.showMessageDialog(tf, "Please enter some data in " + name, "Message", JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            try {
                double number = Double.parseDouble(input); // Attempts to parse the input as a double
    
                if (number <= 0) {
                    // If the number is not positive, show an error message
                    JOptionPane.showMessageDialog(tf, name + " must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(false);
                } else {
                    // If the input is valid, show a confirmation message and enable the next component
                    JOptionPane.showMessageDialog(tf, name + " is changed to " + number, "Message", JOptionPane.INFORMATION_MESSAGE);
                    nextComponent.setEnabled(true);
                }
            } catch (NumberFormatException ex) {
                // If input is not a valid number, show an error message
                JOptionPane.showMessageDialog(tf, "Please enter a valid number in " + name, "Error", JOptionPane.INFORMATION_MESSAGE);
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
            }
        }
    }
    
    // Handles action events when a user enters data in a text field
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // Calls the parent class's actionPerformed method
        Object srcObject = e.getSource(); // Gets the source of the event
        
        if (srcObject == fieldName) {
            handleNormalTextField(fieldName, fieldBrand);
        } else if (srcObject == fieldBrand) {
            handleNormalTextField(fieldBrand, fieldPrice);
        } else if (srcObject == fieldPrice ) {
            handlePosNumTextField(fieldPrice, opComboBox);
        }
    }

    // Adds event listeners to the text fields
    public void addListeners() {
        super.addListeners(); // Calls the parent class's addListeners method
        fieldName.addActionListener(this); // Adds an action listener to fieldName
        fieldBrand.addActionListener(this); // Adds an action listener to fieldBrand
        fieldPrice.addActionListener(this); // Adds an action listener to fieldPrice
    }
   
    // Main method to start the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();  // Calls the method to create and show the GUI
            }
        });
    }
}
