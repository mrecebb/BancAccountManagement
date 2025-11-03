package customer.customerProcesses;

import customer.Customer;
import customer.CustomerDatabase;
import exteption.HaveNotEnoughMoney;

import java.util.Scanner;

public class CardToCard implements Command {
    CustomerDatabase database = new CustomerDatabase();

    @Override
    public String commandName() {
        return "Card To Card";
    }

    @Override
    public void process() {
        Scanner input = new Scanner(System.in);

        System.out.print("Who will you send the money to? Please enter id: ");
        int receiverID = input.nextInt();

        System.out.print("Who will send the money? Please enter id: ");
        int senderID = input.nextInt();

        System.out.print("How much money will you send? Please enter amount: ");
        double amount = input.nextDouble();

        if (senderID <= database.getDatabaseSize() && receiverID <= database.getDatabaseSize()) {
            if (database.getCustomer(senderID).getBalance() >= amount) {
                sendMoney(senderID, receiverID, amount);
                database.getCustomer(senderID).getNotification().deductedNotification(amount, database.getCustomer(senderID));
                database.getCustomer(receiverID).getNotification().addedNotification(amount, database.getCustomer(receiverID));
            }

            else {
                throw new HaveNotEnoughMoney("you want to send " + amount + " manat, but you have " + database.getCustomer(senderID).getBalance() + " manat");
            }
        }

        else {
            System.out.println("Please enter a valid id!");
        }
    }

    private void sendMoney(int senderID, int sendID, double amount) {
        Customer sender = database.getCustomer(senderID);
        Customer receiver = database.getCustomer(sendID);

        receiver.setBalance(receiver.getBalance() + amount);
        sender.setBalance(sender.getBalance() - amount);
    }
}
