package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<MealModel> meals;
    private List<OrderModel> orders;
    private List<UserModel> users;

    private static final String MEALS_FILE = "database/meals.json";
    private static final String ORDERS_FILE = "database/orders.json";
    private static final String USERS_FILE = "database/users.json";

    // Constructor
    public DataManager() {
        meals = new ArrayList<>();
        orders = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Meal management
    public void addMeal(MealModel meal) {
        meals.add(meal);
    }

    public MealModel getMealById(int id) {
        for (MealModel meal : meals) {
            if (meal.getId() == id) {
                return meal;
            }
        }
        return null;
    }

    public List<MealModel> getAllMeals() {
        return meals;
    }

    // Order management
    public void addOrder(OrderModel order) {
        orders.add(order);
    }

    public OrderModel getOrderById(int id) {
        for (OrderModel order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<OrderModel> getAllOrders() {
        return orders;
    }

    // User management
    public void addUser(UserModel user) {
        users.add(user);
    }

    public UserModel getUserById(int id) {
        for (UserModel user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<UserModel> getAllUsers() {
        return users;
    }

    // Save data to JSON
    public void saveData() {
        Gson gson = new Gson();
        try (FileWriter mealWriter = new FileWriter(MEALS_FILE);
             FileWriter orderWriter = new FileWriter(ORDERS_FILE);
             FileWriter userWriter = new FileWriter(USERS_FILE)) {

            gson.toJson(meals, mealWriter);
            gson.toJson(orders, orderWriter);
            gson.toJson(users, userWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from JSON
    public void loadData() {
        Gson gson = new Gson();

        try (FileReader mealReader = new FileReader(MEALS_FILE);
             FileReader orderReader = new FileReader(ORDERS_FILE);
             FileReader userReader = new FileReader(USERS_FILE)) {

            Type mealListType = new TypeToken<List<MealModel>>() {}.getType();
            Type orderListType = new TypeToken<List<OrderModel>>() {}.getType();
            Type userListType = new TypeToken<List<UserModel>>() {}.getType();

            meals = gson.fromJson(mealReader, mealListType);
            orders = gson.fromJson(orderReader, orderListType);
            users = gson.fromJson(userReader, userListType);

            // Handle null cases (if files are empty or don't exist)
            if (meals == null) meals = new ArrayList<>();
            if (orders == null) orders = new ArrayList<>();
            if (users == null) users = new ArrayList<>();

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}