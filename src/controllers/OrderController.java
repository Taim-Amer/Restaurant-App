package controllers;

import models.DataManager;
import models.MealModel;
import models.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private final DataManager dataManager;
    private final List<OrderModel> orders;

    public OrderController() {
        this.dataManager = new DataManager();
        this.orders = new ArrayList<>();
        this.dataManager.loadData();
    }

    public List<MealModel> getMenu() {
        return dataManager.getAllMeals();
    }

    public void chooseMeal(String name, int quantity, String username, String type) {
        List<MealModel> meals = dataManager.getAllMeals();
        for (MealModel meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                double price = meal.getPrice();
                double total = price * quantity;

                double discount = 0;
                if (quantity > 10) {
                    discount = total * 0.1;
                } else if (total > 200) {
                    discount = total * 0.15;
                }

                total = total - discount;

                OrderModel order = new OrderModel(name, type, quantity, price, total, username);
                orders.add(order);

                meal.setQuantity(meal.getQuantity() - quantity);
                dataManager.saveData();

                System.out.println("Order successfully!");
                return;
            }
        }
        System.out.println("Product not found in the menu.");
    }

    public List<OrderModel> getAllOrders() {
        return orders;
    }

    public List<String> getMealIngredients(String name) {
        List<MealModel> meals = dataManager.getAllMeals();
        for (MealModel meal : meals) {
            if (meal.getName().equalsIgnoreCase(name)) {
                return meal.getIngredients();
            }
        }
        return new ArrayList<>();
    }


}
