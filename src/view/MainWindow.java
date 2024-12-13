package view;

import javax.swing.*;

public class MainWindow extends  javax.swing.JFrame{
    private JPanel panel1;
    private JButton employeeButton;
    private JButton customerButton;



    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
