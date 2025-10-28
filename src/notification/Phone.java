package notification;

import customer.Customer;

public class Phone implements Notification{
    @Override
    public String notificationName() {
        return "Phone";
    }

    @Override
    public void deductedNotification(double amount, Customer from) {
        System.out.println(from.getPhoneNumber() + ": Hello " + from.getName() + ". " +
                amount + "AZN was deducted from your account. Balance: " + from.getBalance());
    }

    @Override
    public void addedNotification(double amount, Customer to) {
        System.out.println(to.getPhoneNumber() + ": Hello " + to.getName() + ". " +
                amount + "AZN has been added to your account. Balance: " + to.getBalance());
    }

    @Override
    public void createdNotification(Customer user) {
        System.out.println(user.getPhoneNumber() + ": Welcome " + user.getName() +
                "! This is your new bank account. Your card number: " + user.getCartNumber());
    }

    @Override
    public void increasedBalance(double amount, Customer user) {
        System.out.println(user.getPhoneNumber() + ": Your balance has been increased " +
                amount +"AZN. Balance: " + user.getBalance());
    }
}
