package prasartsri.yotsaphat.lab9;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import java.awt.*;
import prasartsri.yotsaphat.Lab8.MobileDeviceV3;

public class MobileDeviceV4 extends MobileDeviceV3 {
    MobileDeviceV4(String title) {
        super(title);
    }

    protected void addComponents() {
        super.addComponents();
        addMenus();

    }

    protected void addMenus() {
        super.addMenus();
        setIcon();
        setSize();
        setColor();
        setFont();
    }

    protected void setIcon() {
        nEw.setIcon(new ImageIcon(
                getClass().getClassLoader().getResource("prasartsri/yotsaphat/lab9/images/new_icon.png")));
        save.setIcon(new ImageIcon(
                getClass().getClassLoader().getResource("prasartsri/yotsaphat/lab9/images/save_icon.png")));
        open.setIcon(new ImageIcon(
                getClass().getClassLoader().getResource("prasartsri/yotsaphat/lab9/images/open_icon.png")));
        exit.setIcon(new ImageIcon(
                getClass().getClassLoader().getResource("prasartsri/yotsaphat/lab9/images/exit_icon.png")));

    }

    protected void setSize() {
        small.setFont(new Font("Small", Font.PLAIN, 10));
        medium.setFont(new Font("Medium", Font.PLAIN, 14));
        large.setFont(new Font("Large", Font.PLAIN, 18));
        extraLarge.setFont(new Font("Extra Large", Font.PLAIN, 22));
    }

    protected void setColor() {
        black.setForeground(Color.BLACK);
        red.setForeground(Color.RED);
        green.setForeground(Color.GREEN);
        blue.setForeground(Color.BLUE);

    }

    protected void setFont() {
        f1.setFont(new Font("Serif", Font.PLAIN, 14));
        f2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        f3.setFont(new Font("Monospaced", Font.PLAIN, 14));

    }

    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents(); // Add components to the window
        mdv4.setFrameFeatures(); // Set window features (like size, location)
    }

    // Main method to launch the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); // Create and show the GUI window
            }
        });
    }

}
