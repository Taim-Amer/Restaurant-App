package view.components;
import javax.swing.*;
import java.awt.*;

public class ImageUtil {
    public static JLabel createImageLabel(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JLabel label;
        label = new JLabel(new ImageIcon(image));
        return label;
    }
}
