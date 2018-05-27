package model;

import javafx.scene.image.Image;

public class MapObject extends GameObject {
    private Graphics graphics;
    private Double scale;

    public MapObject(String name, Image image, Graphics graphics, Double scale) {
        super(name, image);
        this.graphics = graphics;
        this.scale = scale;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }
}
