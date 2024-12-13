package view;

import controllers.MealsController;
import view.components.CustomButton;
import view.components.NotificationDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MealPanel extends JPanel {
    private final JTextField nameField;
    private final JTextField priceField;
    private final JTextArea ingredientsArea;
    private final JButton addButton;
    private final MealsController mealsController;  // إضافة MealsController كمتغير

    public MealPanel(MealsController mealsController) {  // تلقي MealsController في الكونستركتور
        this.mealsController = mealsController;  // تخزينه للاستخدام لاحقاً

        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245)); // خلفية لونية فاتحة

        // إعداد اللوحة التي تحتوي على النموذج`
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(245, 245, 245)); // نفس اللون في الخلفية
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // اسم الوجبة
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Meal Name:"), gbc);
        nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBackground(Color.WHITE);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(52, 152, 219), 2));
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // سعر الوجبة
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Price:"), gbc);
        priceField = new JTextField(10);
        priceField.setFont(new Font("Arial", Font.PLAIN, 14));
        priceField.setBackground(Color.WHITE);
        priceField.setBorder(BorderFactory.createLineBorder(new Color(52, 152, 219), 2));
        gbc.gridx = 1;
        formPanel.add(priceField, gbc);

        // مكونات الوجبة
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Ingredients:"), gbc);
        ingredientsArea = new JTextArea(5, 20);
        ingredientsArea.setLineWrap(true);
        ingredientsArea.setWrapStyleWord(true);
        ingredientsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        ingredientsArea.setBackground(Color.WHITE);
        ingredientsArea.setBorder(BorderFactory.createLineBorder(new Color(52, 152, 219), 2));
        JScrollPane scrollPane = new JScrollPane(ingredientsArea);
        gbc.gridx = 1;
        formPanel.add(scrollPane, gbc);

        // إعداد الأزرار
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));

        // زر إضافة الوجبة
        addButton = new CustomButton("Add Meal", new ImageIcon("add-icon.png"));
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBackground(new Color(39, 174, 96)); // أخضر مميز
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setPreferredSize(new Dimension(150, 40));

        // Hover effect
        addButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                addButton.setBackground(new Color(34, 153, 84)); // تأثير اللون عند تحريك الماوس
            }
            public void mouseExited(MouseEvent evt) {
                addButton.setBackground(new Color(39, 174, 96)); // اللون الأصلي
            }
        });

        // إضافة التحقق عند الضغط على الزر
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String priceText = priceField.getText();
            String ingredientsText = ingredientsArea.getText();

            // تحقق من الحقول الفارغة
            if (name.isEmpty() || priceText.isEmpty() || ingredientsText.isEmpty()) {
                NotificationDialog.showErrorMessage(this, "All fields must be filled!");
                return;
            }

            // تحقق من السعر (هل هو قيمة عددية)
            try {
                double price = Double.parseDouble(priceText);

                // تحويل النص إلى قائمة من المكونات (مفصولة باستخدام الأسطر الجديدة أو الفواصل)
                List<String> ingredients = Arrays.stream(ingredientsText.split("[,\\n]+"))
                        .map(String::trim)
                        .collect(Collectors.toList());

                // أضف الوجبة باستخدام الـ Controller
                mealsController.addMeal(name, price, ingredients);  // إرسال المكونات كـ List<String> إلى الـ Controller
            } catch (NumberFormatException ex) {
                NotificationDialog.showErrorMessage(this, "Please enter a valid price.");
            }
        });

        buttonPanel.add(addButton);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // إضافة طريقة للوصول إلى الزر
    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JTextArea getIngredientsArea() {
        return ingredientsArea;
    }
}

