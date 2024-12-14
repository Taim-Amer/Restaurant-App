package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class CategoryModel {
    static Collection<String> categoryNames = new LinkedList<>();
    static Collection<String> categoryDescriptions = new LinkedList<>();
    ArrayList<MealModel> meals;
    static int size = 0;

    public CategoryModel(ArrayList<MealModel> meals) {
        this.meals = meals;
    }

    public CategoryModel(){}

    public Collection<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(Collection<String> categoryNames) {
        CategoryModel.categoryNames = categoryNames;
    }

    public ArrayList<MealModel> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<MealModel> meals) {
        this.meals = meals;
    }

    public Collection<String> getCategoryDescriptions() {
        return categoryDescriptions;
    }

    public void setCategoryDescriptions(Collection<String> categoryDescriptions) {
        CategoryModel.categoryDescriptions = categoryDescriptions;
    }
}
