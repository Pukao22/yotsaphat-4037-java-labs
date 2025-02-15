package prasartsri.yotsaphat.excersises.gui;


import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SimpleFormV7 extends SimpleFormV6 implements ItemListener {

    public SimpleFormV7(String title) {
        super(title);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getItemSelectable();
        if (src instanceof JRadioButton) {
            JRadioButton rbtn = (JRadioButton) src;
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(null , rbtn.getText() + " is selected");
            }
        }
    }

    public String getSelectedGender() {
        if (male.isSelected()) {
            return male.getText();
        }
        else if (female.isSelected()) {
            return female.getText();
        }
        else if (other.isSelected()) {
            return other.getText();
        }
        return "Not selected";
    }

    public String getSelectedLanguages() {
        StringBuffer selectedLanguages = new StringBuffer();
        if (python.isSelected()) {
            selectedLanguages.append(python.getText() + " "); 
        }
        if (java.isSelected()) {
            selectedLanguages.append(java.getText() + " ");
        }
        if (javascript.isSelected()) {
            selectedLanguages.append(javascript.getText() + " ");
        }
        if (selectedLanguages.isEmpty()) {
            return null;
        }
        return selectedLanguages.substring(0, selectedLanguages.length()-1).toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String name = nameTxt.getText();
            String addr = addrTxtArea.getText();
            String gender = getSelectedGender();
            String languages = getSelectedLanguages();
            JOptionPane.showMessageDialog(null, name + " live in " + addr + " gender is " + gender +
            " knows this languages: " + languages );
        }
    }


    public void addListeners() {
        super.addListeners();
        male.addItemListener(this);
        female.addItemListener(this);
        other.addItemListener(this);
    }

    public static void createAndShowGUI() {
        SimpleFormV7 window = new SimpleFormV7("SimpleFormV7");
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