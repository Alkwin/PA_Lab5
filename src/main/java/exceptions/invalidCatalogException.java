package exceptions;

public class invalidCatalogException extends Exception {
    public invalidCatalogException(Exception ex) {
        super("Invalid file", ex);
    }
}
