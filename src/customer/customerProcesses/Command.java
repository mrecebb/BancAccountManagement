package customer.customerProcesses;

public interface Command {
    String commandName();
    void process();
}
