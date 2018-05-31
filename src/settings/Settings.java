package settings;

import util.ModalWindows.ModalExceptionWindow;
import util.ModalWindows.ModalInfoWindow;

import javax.swing.text.html.StyleSheet;
import java.io.*;

public class Settings {
    private static String PATH = "config";

    public static Language language;
    public static StyleSheet theme = null;
    public static String defaultDirectory  = "";

    public static void init() {
        if (new File(PATH).exists()) {
            initFromFile();
            return;
        }
        defaultLanguage();
    }

    private static void initFromFile() {
        File file = new File(PATH);
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            language = new Language(br.readLine());
            defaultDirectory = br.readLine();

            br.close();
            isr.close();
            is.close();
        } catch (Exception e) {
            defaultLanguage();
        }
    }

    public static void save() {
        File file = new File(PATH);

        try {
            OutputStream os = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(language.getName());
            bw.newLine();
            bw.write(defaultDirectory);

            bw.close();
            osw.close();
            os.close();
        } catch (Exception e) {
            // NOTHING TO DO, SAVE JUST FAILED
        }
    }

    public static void loadLanguage(String lang) {
        try {
            language = new Language(lang);
        } catch (Exception e1) {
            new ModalInfoWindow("Language", "Unable to load language : " + lang + "\nDefault language will be load instead");

            defaultLanguage();
        }
    }

    private static void defaultLanguage() {
        try {
            language = new Language();
        } catch (Exception e2) {
            new ModalExceptionWindow("Default language", "Unable to load default language.\nApplication will close.");
        }
    }

    public static boolean checkDirectory() {
        if (defaultDirectory.equals(""))
            new ModalInfoWindow(language.getWord("defaultDirectoryTitle"), language.getWord("defaultDirectoryText") + "\n" + language.getWord("defaultDirectoryText2"));
        return !defaultDirectory.equals("");
    }
}
