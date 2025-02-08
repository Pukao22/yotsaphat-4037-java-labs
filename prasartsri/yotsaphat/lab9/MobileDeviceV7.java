package prasartsri.yotsaphat.lab9;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;

// import prasartsri.yotsaphat.lab9.ReadImage.ReadWindowImage;

public class MobileDeviceV7 extends MobileDeviceV6 {
    
    MobileDeviceV7(String title) {
        super(title);
            
    }
    protected void addComponents(){
        super.addComponents();
        fieldName.setText("Samsung Galaxy S25 Ultra");
        fieldBrand.setText("Samsung");
        fieldPrice.setText("46,900");

        featureJTextArea.setText("-200MP Camera -1TB Storage -Snapdragon Gen 4 Processor -5000mAh Battery-6.8-inch AMOLED Display -120Hz Refresh Rate -Fast Charging" 
        .replace("-", "\n-"));
        rateDevice.setValue(9);

        // ReadImage readImage = new ReadImage();
        // latestPanel.add(readImage);
        myImage = new ReadWindowImage("prasartsri/yotsaphat/lab9/images/S25-ultra.jpg");
        myImage.setSize(new Dimension(10, 10));
        latestPanel.add(myImage);
        // readImage.paintComponent("prasartsri/yotsaphat/lab9/images/S25-ultra.jpg");
        

    }
    protected ReadWindowImage myImage;
    // public void paintComponent(String picturename) {
        
    // }
    
     public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents(); // Add components to the window
        mdv7.setFrameFeatures(); // Set window features (like size, location)
    }

    // Main method to launch the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Create and show the GUI window
            }
        });
    }
    public class ReadWindowImage extends JPanel{
        BufferedImage img;
        
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, this);
        }
    
        public ReadWindowImage() {
            try {
                img = ImageIO.read(getClass().getResource("prasartsri/yotsaphat/lab9/images/S25-ultra.jpg"));
            } catch (IOException e) {
               e.printStackTrace(System.err);
            }
        }
    
        public ReadWindowImage(String fileName) {
            String name = fileName;
            try {
                img = ImageIO.read(getClass().getResource(name));
            } catch (IOException e) {
               e.printStackTrace(System.err);
            }
        }
    }

}