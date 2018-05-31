package model;

import java.util.List;

public class TileInfo {
    private List<Integer> properties;

    public TileInfo(List<Integer> properties) {
        this.properties = properties;
    }

    public List<Integer> getProps() {
        return properties;
    }
}
