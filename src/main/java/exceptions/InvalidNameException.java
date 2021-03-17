package exceptions;

public class InvalidNameException extends Exception {
    public InvalidNameException(Exception ex) {
        super("Item not found", ex);
    }
}
