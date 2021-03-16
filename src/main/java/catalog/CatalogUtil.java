package catalog;

import exceptions.invalidCatalogException;
import media.Image;
import media.Item;
import media.Movie;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws invalidCatalogException, IOException, ClassNotFoundException {
        File f = new File(path);
        if(!f.exists() || f.isDirectory()) {
            throw new invalidCatalogException( new Exception() );
        }

        try (var ois = new ObjectInputStream(
                new FileInputStream( path ))){
                return (Catalog) ois.readObject();
        }
    }
}