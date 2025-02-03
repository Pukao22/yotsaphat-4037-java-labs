package prasartsri.yotsaphat.lab9;

import javax.swing.SwingUtilities;

import prasartsri.yotsaphat.Lab8.MobileDeviceV3;;

public class MobileDeviceV4 extends MobileDeviceV3{
    MobileDeviceV4(String title) {
        super(title);
    }
protected void addMenus(){
    super.addMenus();
}
 public static void createAndShowGUI() {
         MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
         mdv4.addComponents();  // Add components to the window
         mdv4.setFrameFeatures();  // Set window features (like size, location)
     }
 
     // Main method to launch the program
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI();  // Create and show the GUI window
             }
         });
     }
 
}
