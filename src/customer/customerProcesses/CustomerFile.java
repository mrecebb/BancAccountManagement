package customer.customerProcesses;

import customer.Customer;
import exteption.FileReadException;
import exteption.FileWriteException;
import notification.Notification;
// notification.Notification serializable deyilsə, Customer içində transient olsun:
// import notification.Notification;

import java.io.*;

public class CustomerFile {
    ;

    public CustomerFile(Customer customer) throws IOException {
        try (FileWriter f = new FileWriter("database.txt", true)){
            f.write( "\n" +
                    customer.getName() + " | " +
                    customer.getSurname() + " | " +
                    customer.getAge() + " | " +
                    customer.getCartNumber() + " | " +
                    customer.getPhoneNumber() + " | " +
                    customer.getEmail()
            );
            f.close();

            System.out.println("Successfully wrote to database.");
        } catch (IOException e) {
            throw new FileReadException("database.sar faylı hazırlana bilmədi");
        }
    }
}