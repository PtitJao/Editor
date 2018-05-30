package model;

import javafx.scene.image.Image;
import java.util.Map;

public class TileInfo {

    private Map<String,String> properties;
    private Image img;

    public TileInfo(Map<String, String> properties, Image img) {
        this.properties = properties;
        this.img = img;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

}
