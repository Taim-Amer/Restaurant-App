package view;

import controllers.MealsController;
import models.DataManager;
import models.MealModel;
import view.components.CustomTable;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private DataManager dataManager;
    private MealsController mealsController;
    private CustomTable table;

    public MainFrame() {
        setTitle("Restaurant Management System");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize DataManager and MealsController
        dataManager = new DataManager();
        dataManager.loadData();  // Load existing meals from file
        table = new CustomTable(new String[]{"ID", "Name", "Price"});

        // Load existing meals into the table
        for (MealModel meal : dataManager.getAllMeals()) {
            table.addRow(new Object[]{meal.getId(), meal.getName(), meal.getPrice()});
        }

        // Pass DataManager and CustomTable to MealsController
        mealsController = new MealsController(dataManager, table);

        // Setup main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Table setup
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // MealPanel for adding a new meal
        MealPanel mealPanel = new MealPanel(mealsController);  // Pass MealsController here
        mainPanel.add(mealPanel, BorderLayout.WEST);

        // Final layout setup
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
