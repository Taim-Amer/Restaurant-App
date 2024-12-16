package models;

public class OrderModel {
    private int orderId;
    private int customerId;
    private String meal;
    private String type;
    private int quantity;
    private double price;
    private double total;
    private String status;
    private String userName;

    public OrderModel(int orderId, int customerId, String meal, String type, int quantity, double price, double total, String userName, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.meal = meal;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.userName = userName;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
