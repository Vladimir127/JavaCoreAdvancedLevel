package lesson02.online;

public class NegativeDebitException extends Exception {
    public NegativeDebitException(String message) {
        super(message);
    }
}
