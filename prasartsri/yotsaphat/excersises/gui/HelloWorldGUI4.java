package prasartsri.yotsaphat.excersises.gui;

import java.awt.*;

import javax.swing.*;

public class HelloWorldGUI4 extends HelloWorldGUI3{

    protected JScrollPane scrollPane;
    protected JTextArea textAreaAddress;
    protected JLabel address;
    protected JPanel addressJPanel;
    protected JButton okButton,cancelButton;

    HelloWorldGUI4(String title) {
        super(title);

    }
    
    

    protected void addComponents() {
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        message = new JLabel("Name: ");
        address = new JLabel("Address:");
        addressJPanel = new JPanel();
        name = new JTextField("Yotsaphat",15);
        scrollPane = new JScrollPane(textAreaAddress);
        textAreaAddress = new JTextArea(3,10);
        textAreaAddress.setText("Thai, Khonkean Universityyyyyy"+"Thai, Khonkean Universityyyyyy"+"Thai, Khonkean Universityyyyyy"+"Thai, Khonkean Universityyyyyy");
        textAreaAddress.setLineWrap(true);
        textAreaAddress.setWrapStyleWord(true);

        

        textFieldPanel = new JPanel();
        buttonPanel = new JPanel();
        maiPanel = new JPanel();
        maiPanel.setLayout(new BorderLayout());
        
        buttonPanel.add(okButton);         
        buttonPanel.add(cancelButton);         
        
        textFieldPanel.add(message);
        textFieldPanel.add(name);

        scrollPane = new JScrollPane(textAreaAddress);
        addressJPanel.add(address);
        addressJPanel.add(scrollPane);
        
        
        
        
        maiPanel.add(textFieldPanel, BorderLayout.NORTH);
        maiPanel.add(addressJPanel, BorderLayout.CENTER);
        maiPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        this.add(maiPanel);

    }
    public static void createAndShowGUI() {
        HelloWorldGUI4 msw = new HelloWorldGUI4("4037");
        msw.addComponents();
        msw.setFrameFeatures();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }

        });

    }
}
