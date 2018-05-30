package model;

import javafx.scene.image.Image;

import java.util.List;

public class Tileset {

    private Image image;
    private int Columns;
    private int Rows;
    private int Offset;
    private List<Property> properties;
    private TileInfo [] tiles;

    public Tileset(Image image, int columns, int rows, int offset, List<Property> properties, TileInfo[] tiles) {
        this.image = image;
        Columns = columns;
        Rows = rows;
        Offset = offset;
        this.properties = properties;
        this.tiles = tiles;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getColumns() {
        return Columns;
    }

    public void setColumns(int columns) {
        Columns = columns;
    }

    public int getRows() {
        return Rows;
    }

    public void setRows(int rows) {
        Rows = rows;
    }

    public int getOffset() {
        return Offset;
    }

    public void setOffset(int offset) {
        Offset = offset;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public TileInfo[] getTiles() {
        return tiles;
    }

    public void setTiles(TileInfo[] tiles) {
        this.tiles = tiles;
    }
}
