package controllers;

import models.DataManager;

public class CustomerController {
    public final DataManager dataManager;

    public CustomerController() {
        this.dataManager = new DataManager();
        this.dataManager.loadData();
    }
}
