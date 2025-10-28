import customer.customerProcesses.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);

    ArrayList<Command> commands = new ArrayList<>();

    public UserInterface() {
        commands.add(new CreateCustomer());
        commands.add(new SearchCustomer());
        commands.add(new PrintCustomer());
        commands.add(new IncreaseBalance());
        commands.add(new CardToCard());
    }

    public void startProgram() {
        while (true) {
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i+1)+ ". " + commands.get(i).commandName());
                if(i == commands.size() - 1){
                    System.out.println((i + 2) + ". Exit");
                }
            }
            System.out.print("Select command: ");
            int choice = input.nextInt();

            if (choice == commands.size() + 1) {
                break;
            }

            if (choice < commands.size() + 1) {
                commands.get(choice - 1).process();
            }

            else  {
                System.out.println("Invalid command");
            }
        }
    }
}
