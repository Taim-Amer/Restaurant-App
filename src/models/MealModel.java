package models;

import java.util.List;

public class MealModel {
    private String name;
    private double price;
    private int quantity;
    private List<String> ingredients;
    private String category;
    private String description;

    public MealModel(String name, double price, int quantity, List<String> ingredients, String category, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ingredients = ingredients;
        this.category = category;
        this.description = description;
    }

    public MealModel() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
