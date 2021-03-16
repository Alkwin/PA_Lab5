import catalog.Catalog;
import catalog.CatalogUtil;
import exceptions.invalidCatalogException;
import exceptions.invalidNameException;
import media.Image;
import media.Movie;

import java.io.IOException;

public class CatalogManager {
    private final String catalogPath = "media/catalog.ser";
    private final String catalogName = "genericCatalog";

    public void startProgram() {
        try {
            initializeCatalog();
            viewCatalog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeCatalog() throws IOException {
        Catalog catalog = new Catalog(catalogName, catalogPath);
        catalog.addItem(new Image("berserk", "media/files/berserk.jpg"));
        catalog.addItem(new Image("musashi", "media/files/musashi.jpg"));
        catalog.addItem(new Image("vidra", "media/files/vidra.jpg"));
        catalog.addItem(new Movie(";)", "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstleyVEVO", "25.09.2009"));

        CatalogUtil.save(catalog);
    }
    public void viewCatalog() throws invalidNameException, invalidCatalogException, IOException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("media/catalog.ser");

        //This will load all the catalog
        catalog.play();

        //This will load a single item
        CatalogUtil.view(catalog.searchByName("musashi") );
    }
}