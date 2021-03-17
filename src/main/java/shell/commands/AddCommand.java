package shell.commands;

import catalog.Catalog;
import media.Item;

import java.util.List;

public class AddCommand extends Command {
    public AddCommand() {
        commandName = "add";
        arguments = List.of("<item_type> <item_name> <item_path>");
    }

    public void executeAddCommand(Catalog catalog, Item newItem) {
        catalog.addItem(newItem);
    }
}
