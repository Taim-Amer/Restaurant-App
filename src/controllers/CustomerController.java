package controllers;

import models.CustomerModel;
import models.DataManager;
import java.util.List;

public class CustomerController {
    public final DataManager dataManager;

    public CustomerController() {
        this.dataManager = new DataManager();
        this.dataManager.loadData();
    }

    public boolean registerCustomer(String username, String password, String phone, String residence) {
        List<CustomerModel> customers = dataManager.getAllCustomers();

        for (CustomerModel customer : customers) {
            if (customer.getUserName().equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return false;
            }
        }

        int newId = customers.size() + 1;
        CustomerModel newCustomer = new CustomerModel(newId, username, password, phone, residence);
        customers.add(newCustomer);
        dataManager.saveData();
        System.out.println("Customer registered successfully!");
        return true;
    }

    public boolean login(String username, String password, boolean isEmployee) {
        if (isEmployee) {
            if (username.equals("employee") && password.equals("employee123")) {
                System.out.println("Employee login successful!");
                return true;
            } else {
                System.out.println("Invalid employee credentials.");
                return false;
            }
        } else {
            List<CustomerModel> customers = dataManager.getAllCustomers();
            for (CustomerModel customer : customers) {
                if (customer.getUserName().equals(username) && customer.getPassword().equals(password)) {
                    System.out.println("Customer login successful!");
                    return true;
                }
            }
            System.out.println("Invalid customer credentials.");
            return false;
        }
    }
}
