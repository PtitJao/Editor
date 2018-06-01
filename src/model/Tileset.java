package model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import settings.Settings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Tileset {
    public static final String PATH = "content" + File.separator + "tileset";

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

    public void bullshitSave(BufferedWriter bw) throws Exception {
        BufferedImage img = SwingFXUtils.fromFXImage(image, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        byte[] ba = baos.toByteArray();
        String encoded = Base64.getEncoder().encodeToString(ba);

        bw.write(encoded + "\n");

        bw.write(name + "\n");
        bw.write(columns + "\n");
        bw.write(rows + "\n");
        bw.write(offset + "\n");

        bw.write(properties.size() + "\n");
        for (Property p : properties)
            p.bullshitSave(bw);

        bw.write(tiles.length + "\n");
        for (TileInfo ti : tiles)
            ti.bullshitSave(bw);
    }

    public static Tileset bullshitLoad(BufferedReader br) throws Exception {
        String s_img = br.readLine();
        byte[] ba = Base64.getDecoder().decode(s_img);
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        BufferedImage bi = ImageIO.read(bais);

        Image image = SwingFXUtils.toFXImage(bi, null);

        String name = br.readLine();
        int columns = Integer.parseInt(br.readLine());
        int rows = Integer.parseInt(br.readLine());
        int offset = Integer.parseInt(br.readLine());

        List<Property> props = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; ++i)
            props.add(Property.bullshitLoad(br));

        int size2 = Integer.parseInt(br.readLine());
        TileInfo[] tiles = new TileInfo[size2];
        for (int i = 0; i < size2; ++i)
            tiles[i] = TileInfo.bullshitLoad(br, size);

        return new Tileset(image, name, columns, rows, offset, props, tiles);
    }

    public static List<String> getTilesets() {
        List<String> ret = new ArrayList<>();

        File file = new File(Settings.defaultDirectory + File.separator + PATH);

        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                String name = child.getName();
                ret.add(name.substring(0, name.length() - 4));
            }
        }

        return ret;
    }

    public static File getFile(String name) {
        return new File(Settings.defaultDirectory + File.separator + PATH + File.separator + name + ".tls");
    }
}
