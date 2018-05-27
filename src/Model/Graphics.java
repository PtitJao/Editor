package Model;

import javafx.scene.image.Image;

public class Graphics {

    protected String name;
    protected Image image;

    public Graphics(String name, Image image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
