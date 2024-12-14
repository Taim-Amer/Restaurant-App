package models;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {
    private List<String> categoryNames = new ArrayList<>();  // تغيير إلى List بدلاً من Collection
    private List<String> categoryDescriptions = new ArrayList<>(); // تغيير إلى List بدلاً من Collection
    private ArrayList<MealModel> meals;

    public CategoryModel() {
        // Constructor فارغ
    }

    public CategoryModel(ArrayList<MealModel> meals) {
        this.meals = meals;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<String> getCategoryDescriptions() {
        return categoryDescriptions;
    }

    public void setCategoryDescriptions(List<String> categoryDescriptions) {
        this.categoryDescriptions = categoryDescriptions;
    }

    public ArrayList<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<MealModel> meals) {
        this.meals = meals;
    }
}
