package prasartsri.yotsaphat.excersises.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HelloWorldGUI2 extends JFrame {
    protected JButton food1;
    protected JButton food2;
    protected JButton food3;
    protected JLabel message = new JLabel("Yotsaphat: ");
    protected JPanel maiPanel;
    protected JPanel buttonPanel;

    HelloWorldGUI2(String title) {
        super(title);

    }

    protected void addComponents() {
        food1 = new JButton("Pizza");
        food2 = new JButton("Dog");
        food3 = new JButton("Cat");
        maiPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonPanel.add(message);
        buttonPanel.add(food1);
        buttonPanel.add(food2);
        buttonPanel.add(food3);
        maiPanel.add(buttonPanel);
        this.add(maiPanel);

    }

    protected void setFrameFeatures() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);

    }

    public static void createAndShowGUI() {
        HelloWorldGUI2 msw = new HelloWorldGUI2("4037");
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
