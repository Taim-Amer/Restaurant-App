package controllers;

import models.CustomerModel;
import models.DataManager;
import models.MealModel;
import models.OrderModel;
import utils.SMSService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

                OrderModel order = new OrderModel(id, getCustomerId(username), name, type, quantity, price, total, username, "preparing");
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

    public void updateOrderStatus(int orderId, String newStatus, int customerId) {
        for (OrderModel order : orders) {
            if (order.getOrderId() == orderId && order.getCustomerId() == customerId) {
                order.setStatus(newStatus);
                dataManager.saveData();

                sendNotification(order);
                System.out.println("Order status updated and notification sent.");
                return;
            }
        }
        System.out.println("Order or customer not found.");
    }

    public void sendNotification(OrderModel order) {
        String notificationMessage = "Order Status Update:\n";
        notificationMessage += "Order ID: " + order.getOrderId() + "\n";
        notificationMessage += "Meal: " + order.getMeal() + "\n";
        notificationMessage += "Quantity: " + order.getQuantity() + "\n";
        notificationMessage += "Status: " + order.getStatus() + "\n";

        String customerPhoneNumber = getCustomerPhoneNumber(order.getCustomerId());

        SMSService smsNotification = new SMSService();
        smsNotification.sendSMS(customerPhoneNumber, notificationMessage);
    }

    public String getCustomerPhoneNumber(int customerId) {
        List<CustomerModel> customers = dataManager.getAllCustomers();
        for (CustomerModel customer : customers) {
            if (customer.getId() == customerId) {
                return customer.getPhone();
            }
        }
        return null;
    }

    public void exportOrdersToFile() {
        try (FileWriter writer = new FileWriter("C:\\Users\\taim\\Desktop\\restaurant\\order.txt")) {
            writer.write("Order Details:\n");
            writer.write("-------------------------------------------------\n");
            for (OrderModel order : orders) {
                writer.write("Order ID: " + order.getOrderId() + "\n");
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

    public int getCustomerId(String username) {
        List<CustomerModel> customers = dataManager.getAllCustomers();

        for (CustomerModel customer : customers) {
            if (customer.getUserName().equals(username)) {
                return customer.getId();
            }
        }
        return 1;
    }

    public void exportReport() {
        try (FileWriter writer = new FileWriter("C:\\Users\\taim\\Desktop\\restaurant\\report.txt")) {
            int totalOrders = orders.size();
            writer.write("Total Orders: " + totalOrders + "\n");

            String mostOrderedMeal = getMostOrderedMeal();
            writer.write("Most Ordered Meal: " + mostOrderedMeal + "\n");

            double dailyRevenue = getDailyRevenue();
            writer.write("Daily Revenue: $" + dailyRevenue + "\n");

            List<String> regularCustomers = getRegularCustomers();
            writer.write("Regular Customers: " + regularCustomers + "\n");

            writer.write("-------------------------------------------------\n");
            System.out.println("Report exported successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while exporting the report: " + e.getMessage());
        }
    }

    private String getMostOrderedMeal() {
        Map<String, Integer> mealCountMap = new HashMap<>();
        for (OrderModel order : orders) {
            String mealName = order.getMeal();
            mealCountMap.put(mealName, mealCountMap.getOrDefault(mealName, 0) + 1);
        }

        String mostOrderedMeal = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : mealCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostOrderedMeal = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostOrderedMeal;
    }
    private double getDailyRevenue() {
        double totalRevenue = 0;
        for (OrderModel order : orders) {
            totalRevenue += order.getTotal();
        }
        return totalRevenue;
    }
    private List<String> getRegularCustomers() {
        Map<String, Integer> customerOrderCount = new HashMap<>();
        for (OrderModel order : orders) {
            String username = order.getUserName();
            customerOrderCount.put(username, customerOrderCount.getOrDefault(username, 0) + 1);
        }

        List<String> regularCustomers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : customerOrderCount.entrySet()) {
            if (entry.getValue() > 1) {
                regularCustomers.add(entry.getKey());
            }
        }

        return regularCustomers;
    }

}
