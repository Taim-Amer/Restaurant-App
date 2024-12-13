package view;

import view.components.GradientPanel;
import view.components.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static view.components.Button.createStyledButton;

public class MainWindow extends javax.swing.JFrame {
    private JPanel panel1;
    private JButton employeeButton;
    private JButton customerButton;

    public MainWindow() {
        panel1 = new GradientPanel();

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        buttonPanel.setOpaque(false);
        employeeButton = createStyledButton("Employee");
        customerButton = createStyledButton("Customer");
        buttonPanel.add(employeeButton);
        buttonPanel.add(customerButton);

        JLabel imageLabel = ImageUtil.createImageLabel("assets/main.png", 200, 200);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel1.add(buttonPanel, BorderLayout.CENTER);
        panel1.add(imageLabel, BorderLayout.CENTER);

        employeeButton.addActionListener(this::onEmployeeButtonClick);
        customerButton.addActionListener(this::onCustomerButtonClick);

        setTitle("Main Window");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }

    private void onEmployeeButtonClick(ActionEvent e) {
        JFrame employeeWindow = new EmployeeWindow();
        employeeWindow.setVisible(true);
    }

    private void onCustomerButtonClick(ActionEvent e) {
        JFrame customerWindow = new CustomerWindow();
        customerWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow frame = new MainWindow();
            frame.setVisible(true);
        });
    }
}
