package view;

import controllers.EmployeeController;
import helpers.Functions;
import view.components.Button;
import view.components.GradientPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmployeeWindow extends JFrame {
    private final JPanel panel;
    private final JButton categoryButton;
    private final JButton mealButton;
    private final JButton customerButton;
    private final JPanel contentPanel;

    public EmployeeWindow() {
        panel = new GradientPanel();

        setTitle("Employee Window");
        setSize(1500, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        buttonPanel.setOpaque(false);

        customerButton = Button.createStyledButton("Customer");
        categoryButton = Button.createStyledButton("Category");
        mealButton = Button.createStyledButton("Meal");

        buttonPanel.add(customerButton);
        buttonPanel.add(categoryButton);
        buttonPanel.add(mealButton);

        customerButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        categoryButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        mealButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());

        JPanel customerPanel = createCustomerPanel();
        JPanel categoryPanel = createCategoryPanel();
        JPanel mealPanel = createMealPanel();

        contentPanel.add(customerPanel, "Customer");
        contentPanel.add(categoryPanel, "Category");
        contentPanel.add(mealPanel, "Meal");

        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(contentPanel, BorderLayout.CENTER);

        customerButton.addActionListener(e -> Functions.showPanel(contentPanel, "Customer"));
        categoryButton.addActionListener(e -> Functions.showPanel(contentPanel, "Category"));
        mealButton.addActionListener(e -> Functions.showPanel(contentPanel, "Meal"));

        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    private JPanel createCustomerPanel() {
        JPanel customerPanel = new JPanel();
        customerPanel.add(new JLabel("محتوى خاص بـ Customer"));
        return customerPanel;
    }

    // دالة لإنشاء محتوى خاص بـ Category

    private JPanel createCategoryPanel() {
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BorderLayout());

        EmployeeController employeeController = new EmployeeController();
        List<String> categoryNames = employeeController.getAllCategoryNames();

        System.out.println("Category names: " + categoryNames); // تتبع البيانات

        // تحقق إذا كانت البيانات فارغة
        if (categoryNames.isEmpty()) {
            System.out.println("No categories available.");
        }

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String name : categoryNames) {
            listModel.addElement(name);
        }

        JList<String> categoryList = new JList<>(listModel);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(categoryList);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(300, 0));

        categoryPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        categoryPanel.add(rightPanel, BorderLayout.CENTER);

        return categoryPanel;
    }

    private JPanel createMealPanel() {
        JPanel mealPanel = new JPanel();
        mealPanel.add(new JLabel("محتوى خاص بـ Meal"));
        return mealPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeWindow window = new EmployeeWindow();
            window.setVisible(true);
        });
    }
}
