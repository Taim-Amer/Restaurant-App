package controllers;

import models.CategoryModel;
import models.DataManager;
import models.MealModel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    private final DataManager dataManager;

    public EmployeeController() {
        this.dataManager = new DataManager();
        this.dataManager.loadData();
    }

    public List<String> getAllCategoryNames() {
        List<CategoryModel> categories = dataManager.getAllCategories();
        List<String> categoryNames = new ArrayList<>();
        for (CategoryModel category : categories) {
            categoryNames.addAll(category.getCategoryNames());
        }
        return categoryNames;
    }

    public List<String> getAllCategoryDescriptions() {
        List<CategoryModel> categories = dataManager.getAllCategories();
        List<String> categoryDescriptions = new ArrayList<>();
        for (CategoryModel category : categories) {
            categoryDescriptions.addAll(category.getCategoryDescriptions());
        }
        return categoryDescriptions;
    }

    public List<MealModel> getMealsByCategory(String categoryName) {
        List<CategoryModel> categories = dataManager.getAllCategories();
        for (CategoryModel category : categories) {
            if (category.getCategoryNames().contains(categoryName)) {
                return category.getMeals();
            }
        }
        return new ArrayList<>();
    }

    public void addCategory(String name, String description) {
        CategoryModel newCategory = new CategoryModel();

        newCategory.getCategoryNames().add(name);
        newCategory.getCategoryDescriptions().add(description);

        dataManager.getAllCategories().add(newCategory);
        dataManager.saveData();
    }

    List<String> getAllMealNames() {
        List<MealModel> meals = dataManager.getAllMeals();
        List<String> mealNames = new ArrayList<>();
        for (MealModel meal : meals) {
            mealNames.add(meal.getName());
        }
        return mealNames;
    }

    List<String> getAllMealDescriptions() {
        List<MealModel> meals = dataManager.getAllMeals();
        List<String> mealDescriptions = new ArrayList<>();
        for (MealModel meal : meals) {
            mealDescriptions.add(meal.getDescription());
        }
        return mealDescriptions;
    }

    public void addMeal(String name, int price, int quantity, String description, String category) {
        MealModel newMeal = new MealModel();
        newMeal.setName(name);
        newMeal.setPrice(price);
        newMeal.setQuantity(quantity);
        newMeal.setDescription(description);
        newMeal.setCategory(category);

        dataManager.getAllMeals().add(newMeal);
        dataManager.saveData();
    }

    public boolean updateMeals(String name, String newName, int newPrice, int newQuantity, String newDescription) {
        List<MealModel> meals = dataManager.getAllMeals();
        for (MealModel meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                meal.setName(newName);
                meal.setPrice(newPrice);
                meal.setQuantity(newQuantity);
                meal.setDescription(newDescription);
                dataManager.saveData();
                return true;
            }
        }
        return false;
    }

    public boolean deleteMeal(String name) {
        List<MealModel> meals = dataManager.getAllMeals();
        for (MealModel meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                meals.remove(meal);
                dataManager.saveData();
                return true;
            }
        }
        return false;
    }
}

