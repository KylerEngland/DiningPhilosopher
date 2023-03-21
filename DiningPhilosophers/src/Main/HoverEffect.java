package Main;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverEffect extends MouseAdapter {

    private Color originalColor;

    public HoverEffect() {
        super();
    }

    public void mouseEntered(MouseEvent e) {
        // Save the original color
        originalColor = e.getComponent().getBackground();

        // Lighten the background color
        float[] hsb = Color.RGBtoHSB(originalColor.getRed(), originalColor.getGreen(), originalColor.getBlue(), null);
        Color brighterColor = Color.getHSBColor(hsb[0], hsb[1], Math.min(1.0f, hsb[2] + 0.2f));
        e.getComponent().setBackground(brighterColor);
    }

    public void mouseExited(MouseEvent e) {
        // Restore the original color
        e.getComponent().setBackground(originalColor);
    }
}
