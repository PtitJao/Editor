package Util;

import javafx.scene.image.Image;

import java.io.File;

public class Util {
    private static String CONTENT_PATH = "content" + File.separator;
    private static String ICON_PATH = "icons" + File.separator;
    private static String STYLE_PATH = "styles" + File.separator;

    public static Image loadImage(String name) {
        return new Image("file:" + CONTENT_PATH + ICON_PATH + name);
    }
}
