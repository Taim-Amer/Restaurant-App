package view.components;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(255, 223, 186),  // لون فاتح
                0, height, new Color(255, 140, 0) // لون غامق
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}
