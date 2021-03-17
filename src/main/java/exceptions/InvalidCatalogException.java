package exceptions;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid file", ex);
    }
}
