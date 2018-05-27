package util;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.io.File;

public class Util {
    private static String CONTENT_PATH = "src" + File.separator;
    private static String ICON_PATH = "icon" + File.separator;
    private static String STYLE_PATH = "styles" + File.separator;

    public static Image loadImage(String name) {
        return new Image("file:" + CONTENT_PATH + ICON_PATH + name);
    }

    public static Image subimage(Image img, int x, int y, int w, int h) {
        PixelReader pr = img.getPixelReader();

        WritableImage ret = new WritableImage(w, h);
        PixelWriter pw = ret.getPixelWriter();

        for (int i = 0; i < w; ++i)
            for (int j = 0; j < h; ++j)
                pw.setArgb(i, j, pr.getArgb(x + i, y + j));

        return ret;
    }
}
