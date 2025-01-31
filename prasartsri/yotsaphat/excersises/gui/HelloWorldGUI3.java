package prasartsri.yotsaphat.excersises.gui;

import java.awt.*;

import javax.swing.*;


public class HelloWorldGUI3 extends HelloWorldGUI2 {
    protected JLabel message;
    protected JTextField name;
    protected JPanel textFieldPanel;
    

    HelloWorldGUI3(String title) {
        super(title);

    }

    protected void addComponents() {
        food1 = new JButton("Pizza");         
        food2 = new JButton("Dog");         
        food3 = new JButton("Cat");
        message = new JLabel("Name: ");
        name = new JTextField("Yotsaphat",15);

        

        textFieldPanel = new JPanel();
        buttonPanel = new JPanel();
        maiPanel = new JPanel();
        maiPanel.setLayout(new BorderLayout());
        
        buttonPanel.add(food1);         
        buttonPanel.add(food2);         
        buttonPanel.add(food3);
        textFieldPanel.add(message);
        textFieldPanel.add(name);
        
        
        
        maiPanel.add(textFieldPanel, BorderLayout.NORTH);
        maiPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        this.add(maiPanel);

    }
    public static void createAndShowGUI() {
        HelloWorldGUI3 msw = new HelloWorldGUI3("4037");
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