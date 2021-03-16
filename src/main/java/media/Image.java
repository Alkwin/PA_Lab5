package media;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Image extends Item {
    /**
     * We don't have any special attributes as of yet, so we initialize it as a standard item
     */
    public Image(String name, String location)
    {
        super(name,location);
    }

    public void load() throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        File f = new File(this.getPath());
        desktop.browse(f.toURI());
    }
}
