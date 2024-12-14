package models;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {
    private List<String> categoryNames = new ArrayList<>();
    private List<String> categoryDescriptions = new ArrayList<>();
    private List<MealModel> meals = new ArrayList<>();

    public CategoryModel() {}

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

    public List<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<MealModel> meals) {
        this.meals = meals;
    }
}
