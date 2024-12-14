import controllers.EmployeeController;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();

        List<String> categoryNames = employeeController.getAllCategoryNames();
        List<String> categoryDescriptions = employeeController.getAllCategoryDescriptions();

        System.out.println("Before adding category:");
        System.out.println("Category Names: " + categoryNames);
        System.out.println("Category Descriptions: " + categoryDescriptions);

        employeeController.addCategory("Vegetarian Food", "Healthy and plant-based dishes");

        categoryNames = employeeController.getAllCategoryNames();
        categoryDescriptions = employeeController.getAllCategoryDescriptions();

        System.out.println("\nAfter adding category:");
        System.out.println("Category Names: " + categoryNames);
        System.out.println("Category Descriptions: " + categoryDescriptions);
    }
}
