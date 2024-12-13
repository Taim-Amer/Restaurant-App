package controllers;

import models.DataManager;
import models.MealModel;

public class MealsController {
    private final DataManager dataManager;
//    private final CustomTable table;

    public MealsController(DataManager dataManager) {
        this.dataManager = dataManager;
//        this.table = table;
    }

    public void addMeal(String name, double price, int quantity, String description, String department) {
        MealModel newMeal = new MealModel(name, price, quantity, description, department);
        dataManager.addMeal(newMeal);
        dataManager.saveData();
//        table.addRow(new Object[]{newMeal.getId(), newMeal.getName(), newMeal.getPrice()});
    }
}
