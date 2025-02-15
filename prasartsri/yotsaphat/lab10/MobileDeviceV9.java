package prasartsri.yotsaphat.lab10;

import java.awt.event.*;
import javax.swing.*;

/**
 * This program defines the MobileDeviceV9 class, which extends MobileDeviceV8, 
 * and adds additional functionality such as file handling (open, save), text customization (font size, color), 
 * and a reset feature. It allows users to input mobile device details, view and modify them, 
 * and customize the appearance of the input fields with different font sizes and colors. 
 * The program includes a GUI with buttons for performing various actions such as opening and saving files, 
 * changing font styles, and resetting the fields.
 * 
 * Author: Yotsaphat Prasartsri   
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

public class MobileDeviceV9 extends MobileDeviceV8 {
    protected JFileChooser openfile, savefile;

    /**
     * Handles events triggered by the user such as opening a file, saving data, 
     * changing font sizes or colors, and resetting input fields.
     * 
     * @param e ActionEvent triggered by the user's interaction with the buttons.
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);  // Calls the superclass method to handle common actions

        Object src = e.getSource();
        if (src == nEw) {
            // Reset all fields to their default values
            fieldName.setText("");
            fieldBrand.setText("");
            fieldPrice.setText("");
            deviceType1.setSelected(true);
            opComboBox.setSelectedIndex(0);
            featureJTextArea.setText("");
            inteCampList.clearSelection();
            rateDevice.setValue(5);

        } else if (src == open) {
            // Open a file using JFileChooser and display the file name
            JFileChooser openfile = new JFileChooser();
            int result = openfile.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String fullpath = openfile.getSelectedFile().getName();
                JOptionPane.showMessageDialog(null, "Opening: " + fullpath);
            }

        } else if (src == save) {
            // Save data to a file using JFileChooser and show a success message
            JFileChooser savefile = new JFileChooser();
            int resultsave = savefile.showSaveDialog(null);
            if (resultsave == JFileChooser.APPROVE_OPTION) {
                String fullpath = savefile.getSelectedFile().getName();
                JOptionPane.showMessageDialog(null, "Data is saved to " + fullpath + " successfully!", "Save",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (src == exit) {
            // Exit the program
            System.exit(0);

        } else if (src == small) {
            // Change the font size of the fields to small
            fieldName.setFont(small.getFont());
            fieldBrand.setFont(small.getFont());
            fieldPrice.setFont(small.getFont());
            featureJTextArea.setFont(small.getFont());

        } else if (src == medium) {
            // Change the font size of the fields to medium
            fieldName.setFont(medium.getFont());
            fieldBrand.setFont(medium.getFont());
            fieldPrice.setFont(medium.getFont());
            featureJTextArea.setFont(medium.getFont());

        } else if (src == large) {
            // Change the font size of the fields to large
            fieldName.setFont(large.getFont());
            fieldBrand.setFont(large.getFont());
            fieldPrice.setFont(large.getFont());
            featureJTextArea.setFont(large.getFont());

        } else if (src == extraLarge) {
            // Change the font size of the fields to extra large
            fieldName.setFont(extraLarge.getFont());
            fieldBrand.setFont(extraLarge.getFont());
            fieldPrice.setFont(extraLarge.getFont());
            featureJTextArea.setFont(extraLarge.getFont());

        } else if (src == black) {
            // Change the font color to black
            fieldName.setForeground(black.getForeground());
            fieldBrand.setForeground(black.getForeground());
            fieldPrice.setForeground(black.getForeground());
            featureJTextArea.setForeground(black.getForeground());

        } else if (src == red) {
            // Change the font color to red
            fieldName.setForeground(red.getForeground());
            fieldBrand.setForeground(red.getForeground());
            fieldPrice.setForeground(red.getForeground());
            featureJTextArea.setForeground(red.getForeground());

        } else if (src == green) {
            // Change the font color to green
            fieldName.setForeground(green.getForeground());
            fieldBrand.setForeground(green.getForeground());
            fieldPrice.setForeground(green.getForeground());
            featureJTextArea.setForeground(green.getForeground());

        } else if (src == blue) {
            // Change the font color to blue
            fieldName.setForeground(blue.getForeground());
            fieldBrand.setForeground(blue.getForeground());
            fieldPrice.setForeground(blue.getForeground());
            featureJTextArea.setForeground(blue.getForeground());

        } else if (src == f1) {
            // Change the font style to f1
            fieldName.setFont(f1.getFont());
            fieldBrand.setFont(f1.getFont());
            fieldPrice.setFont(f1.getFont());
            featureJTextArea.setFont(f1.getFont());

        } else if (src == f2) {
            // Change the font style to f2
            fieldName.setFont(f2.getFont());
            fieldBrand.setFont(f2.getFont());
            fieldPrice.setFont(f2.getFont());
            featureJTextArea.setFont(f2.getFont());

        } else if (src == f3) {
            // Change the font style to f3
            fieldName.setFont(f3.getFont());
            fieldBrand.setFont(f3.getFont());
            fieldPrice.setFont(f3.getFont());
            featureJTextArea.setFont(f3.getFont());
        }
    }

    /**
     * Constructor for MobileDeviceV9 that initializes the superclass MobileDeviceV8 with a title.
     * 
     * @param title The title of the mobile device window.
     */
    MobileDeviceV9(String title) {
        super(title);
    }

    /**
     * Adds components (UI elements) to the window by calling the superclass method.
     */
    public void addComponents() {
        super.addComponents();
    }

    /**
     * Adds action listeners to the buttons for various actions such as open, save, font size/color changes, etc.
     */
    public void addListeners() {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        nEw.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);
        black.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        f1.addActionListener(this);
        f2.addActionListener(this);
        f3.addActionListener(this);
        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
        extraLarge.addActionListener(this);
    }

    /**
     * Creates and shows the GUI by adding components and setting up listeners.
     */
    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.addComponents();
        mdv9.addListeners();
        mdv9.setFrameFeatures(); // Set window features like size and location
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
