package view;

import view.components.Button;
import view.components.GradientPanel;
import helpers.Functions;

import javax.swing.*;
import java.awt.*;

public class EmployeeWindow extends JFrame {
    private final JPanel panel;
    private final JButton categoryButton;
    private final JButton mealButton;
    private final JButton customerButton;
    private final JPanel contentPanel;  // اللوحة لعرض المكونات حسب الزر المضغوط

    public EmployeeWindow() {
        panel = new GradientPanel();

        setTitle("Employee Window");
        setSize(1500, 900);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // إنشاء لوحة الأزرار
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

        // إنشاء لوحة جديدة لعرض المكونات حسب الزر
        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());  // استخدام CardLayout لتبديل المحتوى بسهولة

        // إضافة المكونات لكل زر
        JPanel customerPanel = createCustomerPanel();
        JPanel categoryPanel = createCategoryPanel();
        JPanel mealPanel = createMealPanel();

        contentPanel.add(customerPanel, "Customer");
        contentPanel.add(categoryPanel, "Category");
        contentPanel.add(mealPanel, "Meal");

        // ضبط تخطيط النافذة باستخدام BorderLayout
        panel.setLayout(new BorderLayout());
        panel.add(buttonPanel, BorderLayout.NORTH);  // الأزرار في الجزء العلوي
        panel.add(contentPanel, BorderLayout.CENTER);  // المحتوى في المنتصف (أسفل الأزرار)

        // إضافة المستمعين للأزرار لتغيير المحتوى عند الضغط
        customerButton.addActionListener(e -> Functions.showPanel(contentPanel, "Customer"));
        categoryButton.addActionListener(e -> Functions.showPanel(contentPanel, "Category"));
        mealButton.addActionListener(e -> Functions.showPanel(contentPanel, "Meal"));

        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    // دالة لإنشاء محتوى خاص بـ Customer
    private JPanel createCustomerPanel() {
        JPanel customerPanel = new JPanel();
        customerPanel.add(new JLabel("محتوى خاص بـ Customer"));
        // يمكنك إضافة مكونات أخرى هنا
        return customerPanel;
    }

    // دالة لإنشاء محتوى خاص بـ Category
    private JPanel createCategoryPanel() {
        JPanel categoryPanel = new JPanel();
        categoryPanel.add(new JLabel("محتوى خاص بـ Category"));
        // يمكنك إضافة مكونات أخرى هنا
        return categoryPanel;
    }

    // دالة لإنشاء محتوى خاص بـ Meal
    private JPanel createMealPanel() {
        JPanel mealPanel = new JPanel();
        mealPanel.add(new JLabel("محتوى خاص بـ Meal"));
        // يمكنك إضافة مكونات أخرى هنا
        return mealPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeWindow window = new EmployeeWindow();
            window.setVisible(true);
        });
    }
}
