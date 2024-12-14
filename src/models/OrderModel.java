package models;

public class OrderModel {
    int id;
    String meal, type;
    String status;
    int quantity;
    double price, total;
    String userName;

    public OrderModel(int id, String meal, String type, int quantity, double price, double total, String userName, String status) {
        this.id = id;
        this.meal = meal;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.userName = userName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
