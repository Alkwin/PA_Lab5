package shell.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    String commandName = "";

    /**
     * This we we can keep track of each commands' arguments
     * This does not include the '--help' argument, which is a default for every command
     */
    List<String> arguments = new ArrayList<>();

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
