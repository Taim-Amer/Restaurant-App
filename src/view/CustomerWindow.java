package view;

import javax.swing.*;

public class CustomerWindow extends JFrame {
    public CustomerWindow() {
        setTitle("Customer Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome to the Customer Window"));
        add(panel);
    }
}
