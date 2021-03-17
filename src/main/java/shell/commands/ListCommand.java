package shell.commands;

import catalog.Catalog;

import java.util.List;

public class ListCommand extends Command {
    public ListCommand() {
        commandName = "list";
    }

    public void listCommand(Catalog catalog) {
        if(catalog.getItems().size() == 0) {
            throw new IllegalArgumentException("ItemList should not be empty.");
        }
        catalog.getItems().forEach(iteratedItem -> {
            System.out.println(iteratedItem.toString());
        });
    }

}
