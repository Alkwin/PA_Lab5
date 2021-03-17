package shell.commands;

import catalog.Catalog;
import media.Image;
import media.Movie;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class PlayCommand extends Command {
    public PlayCommand() {
        commandName = "play";
    }

    public void playCommand(Catalog catalog) {
        if(catalog.getItems().size() == 0) {
            throw new IllegalArgumentException("ItemList should not be empty.");
        }
        catalog.getItems().forEach(iteratedItem -> {
            try {
                if(iteratedItem instanceof Image) {
                    ((Image) iteratedItem).load();
                } else if(iteratedItem instanceof Movie) {
                    ((Movie) iteratedItem).load();
                }
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        });
    }
}
