package model;

import javafx.scene.image.Image;

import java.util.List;

public class Tileset {
    private Image image;
    private String name;
    private int columns;
    private int rows;
    private int offset;
    private List<Property> properties;
    private TileInfo[] tiles;

    public Tileset(Image image, String name, int columns, int rows, int offset, List<Property> properties, TileInfo[] tiles) {
        this.image = image;
        this.name = name;
        this.columns = columns;
        this.rows = rows;
        this.offset = offset;
        this.properties = properties;
        this.tiles = tiles;
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int getOffset() {
        return offset;
    }

    public List<Property> getProps() {
        return properties;
    }

    public TileInfo[] getTiles() {
        return tiles;
    }
}
