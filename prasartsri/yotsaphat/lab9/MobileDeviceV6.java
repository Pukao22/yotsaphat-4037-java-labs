package prasartsri.yotsaphat.lab9;
import javax.swing.*;
import java.awt.*;

public class MobileDeviceV6 extends MobileDeviceV5 {
    MobileDeviceV6(String title) {
        super(title);
        
    }
    protected void addComponents(){
        super.addComponents();
        changeLabelFont(fromPanel);
        changeLabelFont(extraPanel);
        changeLabelFont(buttonPanel);
        changeLabelFont(reateDevicPanel);
        changeLabelFont(inteCampPanel);
        featureJTextArea.setBackground(new Color(255, 255, 224));
        featureJTextArea.setForeground(Color.DARK_GRAY); 
        inteCampList.setForeground(new Color(0,64,0));
        inteCampList.setBackground( Color.LIGHT_GRAY);
        inteCampList.setSelectionBackground(Color.yellow);
        inteCampList.setSelectionForeground(Color.BLACK);
        
    }

    public static void changeLabelFont(JPanel panel) {
        // กำหนดค่าฟอนต์และสีที่ต้องการ
        Font font = new Font("Aerial", Font.BOLD, 14);  // font style, size
        // font color
    
        // เปลี่ยน font และ color ของ JLabel ทุกตัวใน panel
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                label.setFont(font);
                label.setForeground(new Color(0, 0, 80));
            }
            if (comp instanceof JTextField) {
                // ปรับแต่ง JTextField
                JTextField textField = (JTextField) comp;
                textField.setBackground(Color.LIGHT_GRAY);  // เปลี่ยนพื้นหลังเป็น Light Gray
                textField.setForeground(Color.DARK_GRAY);   // เปลี่ยนสีตัวอักษรเป็น Dark Gray
            }
          
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                // ตรวจสอบชื่อปุ่มและตั้งค่าสี
                if (button.getText().equals("OK")) {
                    button.setForeground(Color.GREEN);  // เปลี่ยนสีข้อความเป็น Green
                    button.setBackground(Color.WHITE);  // เปลี่ยนพื้นหลังเป็น White
                } else if (button.getText().equals("Cancel")) {
                    button.setForeground(Color.RED);  // เปลี่ยนสีข้อความเป็น Red
                    button.setBackground(Color.WHITE);  // เปลี่ยนพื้นหลังเป็น White
                }
            }
        }
    }
    
    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.addComponents(); // Add components to the window
        mdv6.setFrameFeatures(); // Set window features (like size, location)
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
