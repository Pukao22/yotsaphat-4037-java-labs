package prasartsri.yotsaphat.lab11;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

/**
 * This program defines the MobileDeviceCompleteV3 class, which extends MobileDeviceCompleteV2,
 * and adds additional functionality to handle events related to the resizing, moving, showing, 
 * and hiding of the window. The program provides dialog boxes to display information when the window
 * is resized, moved, shown, or hidden. This class uses ComponentListener for these events.
 *
 * Author: Yotsaphat Prasartsri
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: March 2, 2025
 */

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    /**
     * Constructor for MobileDeviceCompleteV3 that initializes the superclass MobileDeviceCompleteV2 with a title.
     * 
     * @param title The title of the mobile device window.
     */
    MobileDeviceCompleteV3(String title) {
        super(title);
    }

    /**
     * Handles action events when the user presses Enter in any of the input fields.
     * This method simply calls the superclass method to keep the existing functionality.
     * 
     * @param e The ActionEvent triggered when Enter is pressed in a field.
     */
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    /**
     * Handles the event when the window is resized.
     * It shows a dialog box with the new width and height of the window.
     * 
     * @param e The ComponentEvent triggered when the window is resized.
     */
    public void componentResized(ComponentEvent e) {
        Dimension size = this.getSize();
        JOptionPane.showMessageDialog(null, "Window resized to: " 
                + size.width + "x" + size.height);
    }

    /**
     * Handles the event when the window is moved.
     * It shows a dialog box with the new location of the window (X and Y coordinates).
     * 
     * @param e The ComponentEvent triggered when the window is moved.
     */
    public void componentMoved(ComponentEvent e) {
        Point location = this.getLocation();
        JOptionPane.showMessageDialog(null, "Window moved to: X = " 
                + location.x + " Y = " + location.y);
    }

    /**
     * Handles the event when the window is hidden.
     * It shows a dialog box saying the window is now invisible.
     * 
     * @param e The ComponentEvent triggered when the window is hidden.
     */
    public void componentHidden(ComponentEvent e) {
        JOptionPane.showMessageDialog(null, "Window is now invisible ");
    }

    /**
     * Handles the event when the window is shown.
     * It shows a dialog box saying the window is now visible.
     * 
     * @param e The ComponentEvent triggered when the window is shown.
     */
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(null, "Window is now visible ");
    }

    /**
     * Adds components to the window by calling the superclass method.
     */
    public void addComponents() {
        super.addComponents(); 
    }

    /**
     * Adds listeners to the window. This includes adding the ComponentListener 
     * to detect events like resizing, moving, hiding, and showing the window.
     */
    public void addListeners() {
        super.addListeners();
        this.addComponentListener(this);  // Adds a ComponentListener to detect resizing, moving, etc.
    }

    /**
     * Creates and shows the GUI by adding components, listeners, and setting window features.
     */
    public static void createAndShowGUI() {
        MobileDeviceCompleteV3 mdvcv3 = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        mdvcv3.addComponents();  // Add components to the window
        mdvcv3.addListeners();   // Add listeners for the window's events
        mdvcv3.setFrameFeatures();  // Set window features like size, location
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
