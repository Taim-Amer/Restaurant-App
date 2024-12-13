package view.components;

import javax.swing.*;
import java.awt.*;

public class Button {
    public static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
//        button.setBackground(new Color(255, 200, 150));
        button.setBackground(Color.lightGray);
        button.setForeground(Color.DARK_GRAY);
        button.setPreferredSize(new Dimension(200, 50));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setBorder(new RoundedBorder(10));
        return button;
    }
}
