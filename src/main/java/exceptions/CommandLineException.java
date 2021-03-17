package exceptions;

import java.io.IOException;

public class CommandLineException extends IOException {
    public CommandLineException(Exception ex) {
        super("Command line exception", ex);
    }
}
