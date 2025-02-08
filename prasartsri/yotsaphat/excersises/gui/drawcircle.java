package prasartsri.yotsaphat.excersises.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class drawcircle extends JPanel {
    private Ellipse2D.Double circle = new Ellipse2D.Double(10,10,100,100);
    private Rectangle2D.Double square = new Rectangle2D.Double(15+100/2-10,15+100/2-10,10,10);
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(circle);
        g2d.setColor(Color.blue);
        g2d.fill(square);

    }

    public Ellipse2D.Double getCircle(){
        return circle;
    }
    public void setFrameFeatures(JFrame window){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setSize((2*10+100),(2*10+100));
        window.setVisible(true);

    }
    public static void main(String[] args) {
        JFrame window = new JFrame("4037");
        drawcircle content = new drawcircle();
        window.setContentPane(content);
        content.setFrameFeatures(window);
        
    }
}
