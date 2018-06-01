package mapEditor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.Tileset;

import java.util.ArrayList;
import java.util.List;

public class MapDisplay extends StackPane {
    private class TileDisplay extends StackPane {
        private int x;
        private int y;
        private List<Integer> layers = new ArrayList<>();
        private List<ImageView> imgs = new ArrayList<>();

        public TileDisplay(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public TileDisplay(int x, int y, int defaultTile) {
            this.x = x;
            this.y = y;
            this.layers.add(defaultTile);
            //push default tile
        }
    }

    private List<Tileset> layers;

    private String name;
    private TileDisplay[][] tiles;

    private int tileWidth;
    private int tileHeight;


    public MapDisplay(String name, int width, int height, int tileWidth, int tileHeight) {
        this.name = name;
        this.tiles = new TileDisplay[width][height];
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        for (int i = 0; i < tiles.length; ++i)
            for (int j = 0; j < tiles[0].length; ++j)
                tiles[i][j] = new TileDisplay(i, j);

        init();
    }

    public MapDisplay(String name, int width, int height, int tileWidth, int tileHeight, Tileset tileset, int defaultTile) {
        this.name = name;
        this.tiles = new TileDisplay[width][height];
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.layers.add(tileset);

        for (int i = 0; i < tiles.length; ++i)
            for (int j = 0; j < tiles[0].length; ++j)
                tiles[i][j] = new TileDisplay(i, j, defaultTile);

        init();
    }

    public void init() {
        for (int i = 0; i < tiles.length; ++i)
            for (int j = 0; j < tiles[0].length; ++j) {
                tiles[i][j].setTranslateX(i * tileWidth);
                tiles[i][j].setTranslateY(j * tileWidth);

                tiles[i][j].setMinWidth(tileWidth);
                tiles[i][j].setMaxWidth(tileWidth);
                tiles[i][j].setPrefWidth(tileWidth);

                tiles[i][j].setMinHeight(tileWidth);
                tiles[i][j].setMaxHeight(tileWidth);
                tiles[i][j].setPrefHeight(tileWidth);

                this.getChildren().add(tiles[i][j]);
            }



    }
}