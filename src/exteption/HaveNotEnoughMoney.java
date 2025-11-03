package exteption;

public class HaveNotEnoughMoney extends RuntimeException {
    public HaveNotEnoughMoney(String message) {
        super(message);
    }
}
