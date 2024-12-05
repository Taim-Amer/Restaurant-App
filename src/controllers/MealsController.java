package controllers;

import models.DataManager;
import models.MealModel;
import view.components.CustomTable;

import java.util.List;

public class MealsController {
    private DataManager dataManager;
    private CustomTable table;

    public MealsController(DataManager dataManager, CustomTable table) {
        this.dataManager = dataManager;
        this.table = table;
    }

    // Function to add a new meal and update the table
    public void addMeal(String name, double price, List<String> ingredients) {
        // Create a new meal object
        MealModel newMeal = new MealModel(name, price, ingredients);

        // Add it to the data manager
        dataManager.addMeal(newMeal);

        // Add the meal to the table for immediate UI update
        table.addRow(new Object[]{newMeal.getId(), newMeal.getName(), newMeal.getPrice()});

        // Save data to JSON
        dataManager.saveData();
    }
}
