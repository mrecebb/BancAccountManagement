package customer.customerProcesses;

import customer.Customer;
import customer.CustomerDatabase;

import java.util.Scanner;

public class SearchCustomer implements Command {
    CustomerDatabase database = new CustomerDatabase();

    @Override
    public String commandName() {
        return "Search Customer";
    }

    @Override
    public void process() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID or Customer Name: ");
        String key = sc.nextLine();

        if (checkIsDigit(key)) {
            searchID(key);
        } else {
            searchName(key);
        }
    }

    private void searchName(String key) {
        boolean found = false;
        for (int i = 0; i <= database.getDatabaseSize(); i++) {
            Customer customer = database.getCustomer(i);

            if (customer != null && (customer.getName().toLowerCase().contains(key.toLowerCase()))) {
                System.out.println("User found: \n" + customer);
                found = true;
            }
        }

        if (!found) {
            System.out.println("User not found");
        }
    }

    private void searchID(String key) {
        boolean found = false;
        for (int i = 0; i <= database.getDatabaseSize(); i++) {
            Customer customer = database.getCustomer(i);

            if(customer != null && (customer.getId() == Integer.parseInt(key))) {
                System.out.println("User found: \n" + customer);
                found = true;
            }
        }

        if (!found) {
            System.out.println("ID not found");
        }
    }

    private boolean checkIsDigit(String key) {
        for (char c : key.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
