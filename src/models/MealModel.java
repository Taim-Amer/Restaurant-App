package models;

public class MealModel {
    String name;
    double price;
    int quantity;
    String description;
    String department;

    public MealModel(String name, double price, int quantity, String description, String department) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.department = department;
    }

    public MealModel(){}

    public String getName() {
        return name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
