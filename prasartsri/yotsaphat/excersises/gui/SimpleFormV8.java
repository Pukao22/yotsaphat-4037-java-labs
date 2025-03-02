package prasartsri.yotsaphat.excersises.gui;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.*;


public class SimpleFormV8 extends SimpleFormV7 {
     public SimpleFormV8(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == openMI) {
            JFileChooser openfile = new JFileChooser();
            int result = openfile.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String fullpath = openfile.getSelectedFile().getName();
                JOptionPane.showMessageDialog(null, "Opening " + fullpath);
            }else{
                JOptionPane.showMessageDialog(null, "Open file cancelled by the user");}
    }}


    public void addListeners() {
        super.addListeners();
        openMI.addActionListener(this);
    }

    public static void createAndShowGUI() {
        SimpleFormV8 window = new SimpleFormV8("SimpleFormV8");
        window.addComponents();
        window.addMenus();
        window.addListeners();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    }
