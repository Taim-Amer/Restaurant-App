package models;

public class OrderModel {
    private int id;
    private int mealId;
    private int userId;
    private String orderType; // dine-in, delivery, or takeaway
    private double tip;
    private String status; // pending, completed, cancelled
//    private final LocalDateTime orderTime;

    public OrderModel(int id, int mealId, int userId, String orderType, double tip, String status) {
        this.id = id;
        this.mealId = mealId;
        this.userId = userId;
        this.orderType = orderType;
        this.tip = tip;
        this.status = status;
//        this.orderTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public LocalDateTime getOrderTime() {
//        return orderTime;
//    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", mealId=" + mealId + ", userId=" + userId + ", status='" + status + "'}";
    }
}
