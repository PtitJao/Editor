package model;

import javafx.scene.image.Image;
import java.util.Map;

public class TileInfo {

    private Map<String,Property> properties;
    private Image img;

    public TileInfo(Map<String, Property> properties, Image img) {
        this.properties = properties;
        this.img = img;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

}
