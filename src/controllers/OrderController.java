package controllers;

import models.DataManager;
import models.MealModel;
import models.OrderModel;

import java.io.FileWriter;
import java.io.IOException;
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

    public void chooseMeal(int id, int quantity, String username, String type) {
        List<MealModel> meals = dataManager.getAllMeals();
        for (MealModel meal : meals) {
            if (meal.getId() == id) {
                double price = meal.getPrice();
                String name = meal.getName();
                double total = price * quantity;

                double discount = 0;
                if (quantity > 10) {
                    discount = total * 0.1;
                } else if (total > 200) {
                    discount = total * 0.15;
                }

                total = total - discount;

                OrderModel order = new OrderModel(id, name, type, quantity, price, total, username, "preparing");
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

    public void updateOrderStatus(int orderId, String newStatus){
        for (OrderModel order : orders){
            if (order.getMeal().hashCode() == orderId){
                order.setStatus(newStatus);
                dataManager.saveData();
                System.out.println("Order status updated successfully.");
                return;
            }
        }
        System.out.println("Order not found.");
    }

    public void exportOrdersToFile() {
        try (FileWriter writer = new FileWriter("C:\\Users\\taim\\Desktop\\restaurant\\order.txt")) {
            writer.write("Order Details:\n");
            writer.write("-------------------------------------------------\n");
            for (OrderModel order : orders) {
                writer.write("Order ID: " + order.getId() + "\n");
                writer.write("Meal Name: " + order.getMeal() + "\n");
                writer.write("Type: " + order.getType() + "\n");
                writer.write("Quantity: " + order.getQuantity() + "\n");
                writer.write("Price: " + order.getPrice() + "\n");
                writer.write("Total: " + order.getTotal() + "\n");
                writer.write("Customer: " + order.getUserName() + "\n");
                writer.write("-------------------------------------------------\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while exporting orders: " + e.getMessage());
        }
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
