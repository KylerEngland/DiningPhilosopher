package Main;

import java.awt.*;

import javax.swing.JPanel;

public class Panel extends JPanel {
    Panel(){
        setPreferredSize(new Dimension(600,600));
    }

    @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setStroke(new BasicStroke(3));
            g2.setColor(Color.BLACK);
            g2.drawOval(200, 200, 200, 200);
        }
}
