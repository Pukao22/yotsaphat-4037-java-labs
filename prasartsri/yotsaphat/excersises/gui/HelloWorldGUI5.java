package prasartsri.yotsaphat.excersises.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class HelloWorldGUI5 extends HelloWorldGUI4{
    protected JLabel langG, gender;
    protected JRadioButton python, java, javascript, male, female, other;
    protected ButtonGroup group_langG, group_gender;
    protected JPanel langG_Panel, gender_Panel;

    HelloWorldGUI5(String title) {
        super(title);
        langG = new JLabel("Languages: ");
        gender = new JLabel("Gender: ");
        python = new JRadioButton("Python");
        java = new JRadioButton("Java");
        javascript = new JRadioButton("Javascript");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other= new JRadioButton("Other");
        

    }
    protected void addComponents(){
        super.addComponents();

    }

    public static void createAndShowGUI() {
        HelloWorldGUI5 msw = new HelloWorldGUI5("4037");
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
