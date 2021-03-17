package shell.commands;

import catalog.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveCommand extends Command {
    public SaveCommand() {
        commandName = "save";
    }

    public void saveCommand(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

}
