package catalog;

import exceptions.invalidNameException;
import media.Image;
import media.Item;
import media.Movie;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void play(){
        if(items.size() == 0) {
            throw new IllegalArgumentException("ItemList should not be empty.");
        }
        items.forEach(iteratedItem -> {
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
    public Item searchByName(String nameToFind) throws invalidNameException {
        for (Item i : items) {
            if (i.getName().equals(nameToFind)) {
                return i;
            }
        }
        /*items.forEach(iteratedItem -> {
            if(iteratedItem.getName().equals(nameToFind)) {
                return iteratedItem;
            }
        });*/ // error???
        // We throw the exception if we don't find the name we were looking for
        throw new invalidNameException(new Exception());
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
