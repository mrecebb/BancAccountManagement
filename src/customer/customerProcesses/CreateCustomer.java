package customer.customerProcesses;

import customer.Customer;
import customer.CustomerDatabase;
import exteption.InvalidAge;
import notification.Email;
import notification.Notification;
import notification.Phone;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateCustomer implements Command {
    CustomerDatabase database = new CustomerDatabase();

    ArrayList<Notification> notifications = new ArrayList<>();

    public CreateCustomer() {
        notifications.add(new Email());
        notifications.add(new Phone());
    }

    @Override
    public String commandName() {
        return "Create Customer";
    }

    @Override
    public void process() {
        Scanner input = new Scanner(System.in);

        // name information
        System.out.print("Please enter your name(5-16 characters and only symbol): ");
        String name = input.nextLine();
        while (checkText(name)) {
            System.out.print("Please enter a valid name(5-16 characters and only symbol): ");
            name = input.nextLine();
        }
        System.out.println("\n");

        // surname information
        System.out.print("Please enter your surname(5-16 characters and only symbol): ");
        String surname = input.nextLine();
        while (checkText(surname)) {
            System.out.print("Please enter a valid surname(5-16 characters and only symbol): ");
            surname = input.nextLine();
        }
        System.out.println("\n");

        System.out.print("Please enter your age: ");
        int age = input.nextInt();

        if (!checkAge(age)) {
            throw new InvalidAge("your age must be greater than 18"); // exception atdim
        }
        System.out.println("\n");

        // card number information
        System.out.print("Please enter your cart number(16 numbers): ");
        String cart = input.nextLine();
        while (!checkCardNumber(cart)) {
            System.out.print("Please enter a valid cart number(16 numbers): ");
            cart = input.nextLine();
        }
        System.out.println("\n");

        // phone number information
        System.out.print("Please enter your phone number(Format: +994 12 345 67 89): ");
        String phone = input.nextLine();
        while (!checkPhoneNumber(phone)) {
            System.out.print("Please enter a valid phone number(Format: +994 12 345 67 89): ");
            phone = input.nextLine();
        }

        phone = phone.replaceAll("\\s++", "");
        System.out.println("\n");

        // email information
        System.out.print("Please enter your email address: ");
        String email = input.nextLine();
        while (!checkEmail(email)) {
            System.out.print("Please enter a valid email address: ");
            email = input.nextLine();
        }
        System.out.println("\n");

        // notification information
        System.out.println("Where should we send you messages from?");
        for (int i = 0; i < notifications.size(); i++) {
            System.out.println((i + 1) + ". " + notifications.get(i).notificationName());
        }

        System.out.print("Choose: ");
        int choice = input.nextInt();

        System.out.println("\n");

        while (choice <= 0 || choice > notifications.size()) {
            System.out.print("Please enter a valid choice: ");
            choice = input.nextInt();
        }

        Notification addNotification = notifications.get(choice - 1);

        Customer newCustomer = database.addCustomer(name, surname, age, cart, phone, email, addNotification);
        newCustomer.getNotification().createdNotification(newCustomer);
    }

    private boolean checkText(String name) {
        boolean hasDigit = false;
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        return (name.length() <= 2 || name.length() >= 16) || hasDigit;
    }

    private boolean checkAge(int age) {
        return age >= 18;
    }




    private boolean checkCardNumber(String cardNumber) {
        boolean hasCharacter = false;
        for (char c : cardNumber.toCharArray()) {
            if (Character.isLetter(c)) {
                hasCharacter = true;
                break;
            }
        }

        boolean trueCardNumber = false;
        int sum = 0;

        if (cardNumber.length() == 16 && !hasCharacter) {
            for (int i = 1; i <= 16; i++) {
                if (i % 2 != 0) {
                    int num = Integer.parseInt(String.valueOf(cardNumber.charAt(i - 1)));

                    if (num * 2 > 9) {
                        int newNum = num * 2;
                        int numSum = 0;

                        while (newNum > 0) {
                            numSum += newNum % 10;
                            newNum /= 10;
                        }

                        sum += numSum;
                    } else {
                        sum += num * 2;
                    }
                } else {
                    int num = Integer.parseInt(String.valueOf(cardNumber.charAt(i - 1)));
                    sum += num;
                }
            }
        }

        if (sum % 10 == 0) {
            trueCardNumber = true;
        }

        return (cardNumber.length() == 16) && !hasCharacter && trueCardNumber;
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        boolean hasCharacter = false;
        for (char c : phoneNumber.toCharArray()) {
            if (Character.isLetter(c)) {
                hasCharacter = true;
                break;
            }
        }
        String temp = phoneNumber.replaceAll("\\s+", "");
        boolean format = (temp.length() == 13);

        return format && !hasCharacter;
    }

    private boolean checkEmail(String email) {
        boolean hasPoint = false;
        boolean hasSymbol = false;
        for (char c : email.toCharArray()) {
            if (c == '.') {
                hasPoint = true;
                continue;
            }

            if (c == '@') {
                hasSymbol = true;
            }
        }
        return hasPoint && hasSymbol;
    }
}
