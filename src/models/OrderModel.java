package models;

public class OrderModel {
    String meal, type;
    int quantity;
    double price, total;
    String userName;

    public OrderModel(String meal, String type, int quantity, double price, double total, String userName) {
        this.meal = meal;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.userName = userName;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return this.price * this.quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
