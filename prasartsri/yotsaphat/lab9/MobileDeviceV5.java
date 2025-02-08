package prasartsri.yotsaphat.lab9;

import javax.swing.*;
import java.awt.*;


public class MobileDeviceV5 extends MobileDeviceV4 {
    protected JList <String>inteCampList;
    protected String[] inteCamp = {"AIS","True","DTAC","Shopee"};
    protected JPanel inteCampPanel,reateDevicPanel,latestPanel;
    protected JLabel inteCampLabel,rateDevicLabel;
    protected JSlider rateDevice;
    protected JScrollPane inteJScrollPane;

    
    
    MobileDeviceV5(String title) {
        super(title);
        
    }
    
    
    protected void addComponents(){
        super.addComponents();
        inteCampLabel = new JLabel("The device is availble at: ");

        inteCampList = new JList<>(inteCamp);
        inteCampList.setVisibleRowCount(4);
        inteCampList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        inteCampList.setSelectedIndex(0); 
        
        inteJScrollPane = new JScrollPane(inteCampList);

        
        
        rateDevice = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
        rateDevice.setMajorTickSpacing(1);
        rateDevice.setPaintTicks(true);      
        rateDevice.setPaintLabels(true);

        rateDevicLabel = new JLabel("Rate the device(0-10): ");

        inteCampPanel = new JPanel();
        inteCampPanel.setLayout(new GridLayout(1,2));

        reateDevicPanel = new JPanel();
        reateDevicPanel.setLayout(new BorderLayout());
        
        inteCampPanel.add(inteCampLabel);
        inteCampPanel.add(inteJScrollPane);


        

        reateDevicPanel.add(rateDevicLabel, BorderLayout.CENTER);
        reateDevicPanel.add(rateDevice, BorderLayout.SOUTH);
        
        latestPanel = new JPanel();
        latestPanel.setLayout(new GridLayout(4,1));
        
        latestPanel.add(extraPanel);
        latestPanel.add(inteCampPanel);
        latestPanel.add(reateDevicPanel);

        mainPanel.add(latestPanel,BorderLayout.CENTER);
        
        

        


    }
    
    
    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents(); // Add components to the window
        mdv5.setFrameFeatures(); // Set window features (like size, location)
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