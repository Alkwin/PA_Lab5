package media;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;

public class Movie extends Item {
    private String releaseDate;

    public Movie(String name, String path, String newReleaseDate) {
        super(name, path);
        this.releaseDate = newReleaseDate;
    }

    public void load() throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        URI uri;
        uri = new URI(this.getPath());
        desktop.browse(uri);;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "releaseDate='" + releaseDate + "' " +
                super.toString() +
                '}';
    }
}
