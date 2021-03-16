package exceptions;

public class invalidNameException extends Exception {
    public invalidNameException(Exception ex) {
        super("Item not found", ex);
    }
}
