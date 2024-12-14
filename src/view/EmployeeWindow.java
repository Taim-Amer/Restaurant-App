package view;

import helpers.Functions;
import view.components.Button;
import view.components.GradientPanel;

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
        categoryPanel.setLayout(new BorderLayout()); // استخدام BorderLayout لتقسيم المناطق

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Category 1");
        listModel.addElement("Category 2");
        listModel.addElement("Category 3");
        listModel.addElement("Category 4");

        JList<String> categoryList = new JList<>(listModel);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        categoryList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setFont(new Font("Arial", Font.BOLD, 18)); // تكبير حجم النص
                label.setHorizontalAlignment(SwingConstants.CENTER); // توسيط النص
                label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
                return label;
            }
        });

        JScrollPane scrollPane = new JScrollPane(categoryList);

        // إزالة الإطار الافتراضي للقائمة
//        categoryList.setBorder(null);

        // إضافة إطار ملون وزوايا دائرية مباشرة على JScrollPane
//        scrollPane.setBorder(new RoundedBorder(20)); // تعيين الإطار الملون (مثال: لون أزرق)

        // إضافة العنوان والقائمة إلى لوحة على الجانب الأيسر
        JPanel leftPanel = new JPanel(new BorderLayout());
//        leftPanel.add(titleLabel, BorderLayout.NORTH);
        leftPanel.add(scrollPane, BorderLayout.CENTER);
            leftPanel.setBackground(Color.WHITE); // الخلفية البيضاء
        leftPanel.setPreferredSize(new Dimension(300, 0)); // تحديد عرض اللوحة

        // إضافة اللوحة إلى الجانب الأيسر من `categoryPanel`
        categoryPanel.add(leftPanel, BorderLayout.WEST);

        // يمكن إضافة مكونات أخرى في القسم الأيمن إذا لزم الأمر
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE); // مثال على محتوى في الجانب الأيمن
        categoryPanel.add(rightPanel, BorderLayout.CENTER);

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
