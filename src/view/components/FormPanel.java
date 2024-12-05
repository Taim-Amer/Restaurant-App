package view.components;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    private GridBagConstraints gbc;

    public FormPanel(String title) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
                title, 0, 0, new Font("Arial", Font.BOLD, 14), new Color(52, 152, 219)
        ));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    public void addField(String label, JComponent field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;
        add(new JLabel(label + ":"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.7;
        add(field, gbc);
    }
}
