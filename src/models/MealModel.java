package models;

import java.util.List;

public class MealModel {
    private static int idCounter = 0;
    private final int id;
    private final String name;
    private final double price;
    private final List<String> ingredients;

    public MealModel(String name, double price, List<String> ingredients) {
        this.id = ++idCounter;  // Auto-increment ID
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
