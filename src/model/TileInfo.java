package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class TileInfo {
    private List<Integer> properties;

    public TileInfo(List<Integer> properties) {
        this.properties = properties;
    }

    public List<Integer> getProps() {
        return properties;
    }

    public void bullshitSave(BufferedWriter bw) throws Exception {
        for (Integer i : properties)
            bw.write(i + "\n");
    }

    public static TileInfo bullshitLoad(BufferedReader br, int size) throws Exception {
        List<Integer> props = new ArrayList<>();

        for (int i = 0; i < size; ++i)
            props.add(Integer.parseInt(br.readLine()));

        return new TileInfo(props);
    }
}
