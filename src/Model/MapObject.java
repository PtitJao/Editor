package Model;

import javax.swing.*;

public class MapObject extends GameObject {

    private Graphics graphics;
    private Double scale;

    public MapObject(String name, ImageIcon icon, Graphics graphics, Double scale) {
        super(name, icon);
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
