package view;

import javax.swing.*;

public class EmployeeWindow extends JFrame {
    public EmployeeWindow() {
        setTitle("Employee Window");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome to the Employee Window"));
        add(panel);
    }
}
