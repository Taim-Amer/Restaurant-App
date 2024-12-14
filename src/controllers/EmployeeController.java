package controllers;

import models.CategoryModel;
import models.DataManager;
import models.MealModel;

public class EmployeeController {

    private final DataManager dataManager;

    public EmployeeController() {
        this.dataManager = new DataManager();
        this.dataManager.loadData();
    }

    public void addCategory(String name, String description){
        CategoryModel newCategory = new CategoryModel();

        newCategory.getCategoryNames().add(name);
        newCategory.getCategoryDescriptions().add(description);

        dataManager.getAllCategories().add(newCategory);
        dataManager.saveData();

    }

    public void addMeal(String name, int price, int quantity, String description){
        MealModel newMeal = new MealModel();
        newMeal.setName(name);
        newMeal.setPrice(price);
        newMeal.setQuantity(quantity);
        newMeal.setDescription(description);

        dataManager.getAllMeals().add(newMeal);
        dataManager.saveData();
    }

}
