package exteption;

public class InvalidAge extends RuntimeException {
    public InvalidAge(String message) {
        super(message);
    }
}
