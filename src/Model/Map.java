package Model;

import java.util.List;

public class Map {

    private int width;
    private int height;
    private List<Layer> layers;

    public Map(int width, int height, List<Layer> layers) {
        this.width = width;
        this.height = height;
        this.layers = layers;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
}
