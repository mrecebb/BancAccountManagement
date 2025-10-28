package notification;

import customer.Customer;

public interface Notification {
    String notificationName();
    void deductedNotification(double amount, Customer from);
    void addedNotification(double amount, Customer to);
    void createdNotification(Customer user);
    void increasedBalance(double amount, Customer user);
}
