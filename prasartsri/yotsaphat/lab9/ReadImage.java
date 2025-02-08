/*
 * This class extends JPanel and is used to read and display an image on the panel.
 * It provides two constructors: one that reads a default image and one that accepts 
 * a file name to read a specific image. The image is drawn in the `paintComponent` method.
 * 
 * Output:
 * The program will display the image in a `JPanel` within the parent window. The image
 * is read from the specified file path and drawn within the component.
 * 
 * Author: Yotsaphat Prasartsri  
 * ID: 673040403-7  
 * Sec: 1  
 * Last Updated: February 1, 2025
 */

 package prasartsri.yotsaphat.lab9;

 import javax.imageio.ImageIO;
 import javax.swing.JPanel;
 import java.awt.*;
 import java.io.File;
 import java.io.IOException;
 import java.awt.image.BufferedImage;
 
 public class ReadImage extends JPanel {
     // BufferedImage variable to hold the image
     BufferedImage img;
 
     // Overriding paintComponent to draw the image
     @Override
     public void paintComponent(Graphics g) {
         super.paintComponent(g); // Call the superclass method
         g.drawImage(img, 0, 0, this); // Draw the image at coordinates (0, 0)
     }
 
     // Default constructor, loads a default image
     public ReadImage() {
         try {
             // Load the image from the specified path
             img = ImageIO.read(new File("prasartsri/yotsaphat/lab9/images/S25-ultra.jpg"));
         } catch (IOException e) {
             // Print the error if the image fails to load
             e.printStackTrace(System.err);
         }
     }
 
     // Constructor that accepts a file name and loads the image from the file
     public ReadImage(String fileName) {
         String name = fileName; // Assign the file name to a local variable
         try {
             // Load the image from the specified file path
             img = ImageIO.read(new File(name));
         } catch (IOException e) {
             // Print the error if the image fails to load
             e.printStackTrace(System.err);
         }
     }
 }
 