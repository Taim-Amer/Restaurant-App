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
    private List<CustomerModel> users;
    private List<CategoryModel> categories;

    private static final String MEALS_FILE = "database/meals.json";
    private static final String ORDERS_FILE = "database/orders.json";
    private static final String USERS_FILE = "database/users.json";
    private static final String CATEGORIES_FILE = "database/categories.json";

    // Constructor
    public DataManager() {
        meals = new ArrayList<>();
        orders = new ArrayList<>();
        users = new ArrayList<>();
        categories = new ArrayList<>();
    }

    public void addMeal(MealModel meal) {
        meals.add(meal);
    }

    public List<MealModel> getAllMeals() {
        return meals;
    }

    public List<OrderModel> getAllOrders() {
        return orders;
    }
    public List<CategoryModel> getAllCategories() {return categories;}

    public void saveData() {
        Gson gson = new Gson();
        try (FileWriter mealWriter = new FileWriter(MEALS_FILE);
             FileWriter orderWriter = new FileWriter(ORDERS_FILE);
             FileWriter categoryWriter = new FileWriter(CATEGORIES_FILE);
             FileWriter userWriter = new FileWriter(USERS_FILE)) {

            gson.toJson(meals, mealWriter);
            gson.toJson(orders, orderWriter);
            gson.toJson(categories, categoryWriter);
            gson.toJson(users, userWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        Gson gson = new Gson();

        try (FileReader mealReader = new FileReader(MEALS_FILE);
             FileReader orderReader = new FileReader(ORDERS_FILE);
             FileReader categoryReader = new FileReader(CATEGORIES_FILE);
             FileReader userReader = new FileReader(USERS_FILE)) {

            Type mealListType = new TypeToken<List<MealModel>>() {
            }.getType();
            Type orderListType = new TypeToken<List<OrderModel>>() {
            }.getType();
            Type userListType = new TypeToken<List<CustomerModel>>() {
            }.getType();
            Type categoryListType = new TypeToken<List<CategoryModel>>() {
            }.getType();

            meals = gson.fromJson(mealReader, mealListType);
            orders = gson.fromJson(orderReader, orderListType);
            categories = gson.fromJson(categoryReader, categoryListType);
            users = gson.fromJson(userReader, userListType);

            if (meals == null) meals = new ArrayList<>();
            if (orders == null) orders = new ArrayList<>();
            if (users == null) users = new ArrayList<>();
            if (categories == null) categories = new ArrayList<>();

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
