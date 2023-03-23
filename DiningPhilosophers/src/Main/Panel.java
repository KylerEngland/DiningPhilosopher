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
            g2.drawOval(200, 200, 300, 300);
            g2.drawOval(310, 210, 75, 75);
            g2.drawOval(410, 290, 75, 75);
            g2.drawOval(370, 400, 75, 75);
            g2.drawOval(260, 400, 75, 75);
            g2.drawOval(220, 290, 75, 75);
        }
}
