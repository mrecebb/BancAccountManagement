package customer.customerProcesses;

import customer.CustomerDatabase;

public class PrintCustomer implements Command {
    CustomerDatabase database = new CustomerDatabase();
    @Override
    public String commandName() {
        return "Print All Customers";
    }

    @Override
    public void process() {
        database.getCustomers();
    }
}
