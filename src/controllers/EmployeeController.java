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

    public void addCategory(String name, String description) {
        CategoryModel newCategory = new CategoryModel();

        // إضافة الاسم والوصف إلى القوائم الخاصة بكل كائن
        newCategory.getCategoryNames().add(name);
        newCategory.getCategoryDescriptions().add(description);

        // إضافة الصنف إلى القائمة
        dataManager.getAllCategories().add(newCategory);
        dataManager.saveData();
    }

    public void addMeal(String name, int price, int quantity, String description) {
        MealModel newMeal = new MealModel();
        newMeal.setName(name);
        newMeal.setPrice(price);
        newMeal.setQuantity(quantity);
        newMeal.setDescription(description);

        dataManager.getAllMeals().add(newMeal);
        dataManager.saveData();
    }
}

