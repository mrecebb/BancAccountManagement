package customer;

import notification.Notification;

import java.util.ArrayList;

public class CustomerDatabase {
    private static final ArrayList<Customer> customers = new ArrayList<>();

    public Customer addCustomer(String name, String surname, int age, String cardNumber, String phone, String email, Notification notification) {
        Customer customer = new Customer();

        customer.setId();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setAge(age);
        customer.setCartNumber(cardNumber);
        customer.setPhoneNumber(phone);
        customer.setEmail(email);
        customer.setBalance(0);
        customer.setNotification(notification);

        addCustomer(customer);

        return customer;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void getCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    public int getDatabaseSize() {
        return customers.size();
    }
}
