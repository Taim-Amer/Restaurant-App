package models;

public class CustomerModel {
    int id;
    String NameCustomer;
    String address;
    String userName;
    String password;
    public CustomerModel(int id, String NameCustomer, String address, String userName, String password) {
        this.id = id;
        this.NameCustomer = NameCustomer;
        this.address = address;
        this.userName = userName;
        this.password = password;

    }

}

