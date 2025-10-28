package notification;

import customer.Customer;

public class Email implements Notification {
    @Override
    public String notificationName() {
        return "Email";
    }

    @Override
    public void deductedNotification(double amount, Customer from) {
        System.out.println(from.getEmail() + ": Hello " + from.getName() + ". " +
                amount + "AZN was deducted from your account. Balance: " + from.getBalance());
    }

    @Override
    public void addedNotification(double amount, Customer to) {
        System.out.println(to.getEmail() + ": Hello " + to.getName() + ". " +
                amount + "AZN has been added to your account. Balance: " + to.getBalance());
    }

    @Override
    public void createdNotification(Customer user) {
        System.out.println(user.getEmail() + ": Welcome " + user.getName() +
                "! This is your new bank account. Your card number: " + user.getCartNumber());
    }

    @Override
    public void increasedBalance(double amount, Customer user) {
        System.out.println(user.getEmail() + ": Your balance has been increased " +
                amount +"AZN. Balance: " + user.getBalance());
    }
}
