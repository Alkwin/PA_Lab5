package catalog;

import exceptions.InvalidCatalogException;

import java.io.*;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        File f = new File(path);
        if(!f.exists() || f.isDirectory()) {
            throw new InvalidCatalogException( new Exception() );
        }

        try (var ois = new ObjectInputStream(
                new FileInputStream( path ))){
                return (Catalog) ois.readObject();
        }
    }
}