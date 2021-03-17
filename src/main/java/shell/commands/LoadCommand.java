package shell.commands;

import catalog.Catalog;
import exceptions.InvalidCatalogException;
import media.Image;
import media.Item;
import media.Movie;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URISyntaxException;
import java.util.List;

public class LoadCommand extends Command {
    public LoadCommand() {
        commandName = "load";
        arguments = List.of("<item_name>");
    }

    public Catalog loadCommand(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        File f = new File(path);
        if(!f.exists() || f.isDirectory()) {
            throw new InvalidCatalogException( new Exception() );
        }

        try (var ois = new ObjectInputStream(
                new FileInputStream(path))){
            return (Catalog) ois.readObject();
        }
    }

}
