package view.components;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        this(text, null);
    }

    public CustomButton(String text, Icon icon) {
        super(text, icon);
        setPreferredSize(new Dimension(150, 45));
        setFont(new Font("Arial", Font.BOLD, 16));
        setBackground(new Color(52, 152, 219)); // احترافية الألوان (أزرق هادئ)
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setFocusPainted(false);

        // Hover effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(41, 128, 185)); // أزرق أغمق
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(52, 152, 219));
            }
        });
    }

    public void setCustomColors(Color backgroundColor, Color textColor) {
        setBackground(backgroundColor);
        setForeground(textColor);
    }
}
