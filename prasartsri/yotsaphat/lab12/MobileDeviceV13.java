package prasartsri.yotsaphat.lab12;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import prasartsri.yotsaphat.Lab7.MobileDevice;

/**
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 14, 2025
 * 
 * This class extends MobileDeviceV12 and adds additional buttons and functionality
 * to handle adding and displaying mobile devices.
 */
public class MobileDeviceV13 extends MobileDeviceV12 {
    protected JButton addButton, displayButton; // Buttons for adding and displaying devices
    protected ArrayList<prasartsri.yotsaphat.Lab7.MobileDevice> mobileDevice = new ArrayList<>(); // List to store mobile devices

    // Constructor to initialize the frame with a title
    MobileDeviceV13(String title) {
        super(title);
    }

    // Adds components including buttons for add and display functionality
    public void addComponents() {
        super.addComponents();
        addButton = new JButton("Add"); // Button to add a device
        displayButton = new JButton("Display"); // Button to display all devices
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
    }

    // Creates and shows the GUI
    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        mdv13.addComponents();
        mdv13.addListeners();
        mdv13.setFrameFeatures();
    }

    // Handles button click events
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton(); // Calls method to handle adding a device
        } else if (src == displayButton) {
            handleDisplayButton(); // Calls method to handle displaying devices
        } else {
            super.actionPerformed(e);
        }
    }

    // Handles adding a new mobile device to the list
    public void handleAddButton() {
        String name = handleGetTextInTextField(fieldName);
        String brand = handleGetTextInTextField(fieldBrand);
        Double price = handleGetNumInTextField(fieldPrice);
        String mobileDeviceType = deviceType1.isSelected() ? "Smartphone" : "Tablet";
        
        if (name == null || brand == null || Double.isNaN(price)) {
            return; // If any input is invalid, return without adding the device
        }

        if (deviceType1.isSelected()) {
            mobileDevice.add(new SmartPhone(name, brand, price)); // Adds a smartphone to the list
        } else {
            mobileDevice.add(new Tablet(name, brand, price)); // Adds a tablet to the list
        }
        
        String msg = mobileDeviceType + " " + name + " is added";
        JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    // Handles displaying the list of added mobile devices
    public void handleDisplayButton() {
        StringBuffer msg = new StringBuffer();
        for (MobileDevice mobileDevice : mobileDevice) {
            msg.append(mobileDevice.toString() + "\n");
        }
        
        if (msg.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Handles retrieving text from a text field with validation
    public String handleGetTextInTextField(JTextField tf) {
        String text = tf.getText();
        if (text.isEmpty()) {
            tf.requestFocusInWindow();
            String msg = "Please enter some data in " + tf.getName();
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return text;
    }

    // Handles retrieving numeric values from a text field with validation
    public Double handleGetNumInTextField(JTextField tf) {
        String msg;
        if (tf.getText().isEmpty()) {
            tf.requestFocusInWindow();
            msg = "Please enter some data in " + tf.getName();
            JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                double PriceCheck = Double.parseDouble(tf.getText()); // Attempts to parse input as a double
                if (PriceCheck < 0) {
                    tf.requestFocusInWindow();
                    msg = tf.getName() + " must be a positive number";
                    JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    return PriceCheck;
                }
            } catch (NumberFormatException e) {
                tf.requestFocusInWindow();
                msg = "Please enter a valid number in " + tf.getName();
                JOptionPane.showMessageDialog(this, msg, "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        return Double.NaN;
    }

    // Adds event listeners to buttons
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this); // Adds an action listener to addButton
        displayButton.addActionListener(this); // Adds an action listener to displayButton
    }

    // Main method to start the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Calls method to create and show the GUI
            }
        });
    }
}
