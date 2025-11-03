package customer.customerProcesses;

import customer.Customer;
import customer.CustomerDatabase;

import java.util.Scanner;

public class IncreaseBalance implements Command {
    CustomerDatabase database = new CustomerDatabase();

    @Override
    public String commandName() {
        return "Increase Balance";
    }

    @Override
    public void process() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        int id = input.nextInt();
        boolean found = false;

        if (database.getCustomer(id) != null) {
            for (int i = 0; i < database.getDatabaseSize(); i++) {
                Customer customer = database.getCustomer(id);

                if (customer.getId() == id) {
                    found = true;
                    System.out.println("Name: " + customer.getName() + "\nSurname: " + customer.getSurname() + "\nYour Balance: " +  customer.getBalance());
                    System.out.print("Increase Balance: ");
                    double amount = input.nextDouble();
                    customer.setBalance(customer.getBalance() + amount);
                    customer.getNotification().increasedBalance(amount, customer);
                    break;
                }
            }

        } else {
            System.out.println("Customer " + id + " not found");
        }

        if (!found) {
            System.out.println("User not found!");
        }
    }
}
