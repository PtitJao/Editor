package settings;

import Util.ModalWindows.ModalExceptionWindow;
import Util.ModalWindows.ModalInfoWindow;

import javax.swing.text.html.StyleSheet;
import java.io.File;

public class Settings {
    private static String PATH = "config";

    public static Language language;
    public static StyleSheet theme = null;
    public static String defaultDirectory  = null;

    public static void init() {
        if (new File(PATH).exists()) {
            initFromFile();
            return;
        }
        defaultLanguage();
    }

    public static void initFromFile() {
        String language = "en";

        loadLanguage(language);
    }

    public static void loadLanguage(String lang) {
        try {
            language = new Language(lang);
        } catch (Exception e1) {
            new ModalInfoWindow("Language", "Unable to load language : " + lang + "\nDefault language will be load instead");

            defaultLanguage();
        }
    }

    public static void defaultLanguage() {
        try {
            language = new Language();
        } catch (Exception e2) {
            new ModalExceptionWindow("Default language", "Unable to load default language.\nApplication will close.");
        }
    }
}
