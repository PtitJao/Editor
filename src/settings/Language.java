package settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Language {
    private Map<String, String> words;

    /**
     * Constructor of the language
     * @param path Path to the language file to load
     */
    public Language(String path) throws Exception {
        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        words = new HashMap<>();

        br.readLine(); // Skip language name
        String line;
        String[] separated;

        while ((line = br.readLine()) != null) {
            separated = line.split(":");

            if (separated.length == 2)
                words.put(separated[0], separated[1]);
        }

        br.close();
        isr.close();
        fis.close();
    }

    /**
     * Function that returns the word corresponding to the key
     * @param key The identifier of the word (same for all languages)
     * @return The word in the right language or "undefined" if the key doesn't exists
     */
    public String getWord(String key) {
        String ret = words.get(key);

        if (ret == null)
            ret = "Undefined";

        return ret;
    }

    /**
     * Function that return the name of the a language
     * @param path The path of the file language
     * @return The name of the language in its own language
     * @throws Exception Thrown if something wrong happens while parsing file
     */
    private static String getName(String path) throws Exception {
        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String ret = br.readLine();

        br.close();
        isr.close();
        fis.close();

        return ret;
    }

    /**
     * Function that return all the languages'name in the language folder
     * @return The list containing all the languages'name
     * @throws LanguageFolderNotFoundException Thrown when the language folder does'nt exist
     * @throws LanguageFolderWrongFormatException Thrown when the language folder is not a directory
     * @throws NoLanguageFoundException Thrown when there are no language found
     */
    public static List<String> getLanguagesName() throws LanguageFolderNotFoundException, LanguageFolderWrongFormatException, NoLanguageFoundException {
        String folderPath = "content\\languages";

        File folder = new File(folderPath);

        if (!folder.exists())
            throw new LanguageFolderNotFoundException();
        if (!folder.isDirectory())
            throw new LanguageFolderWrongFormatException();

        List<String> ret = new ArrayList<>();

        File[] childs = folder.listFiles();

        if (childs == null)
            throw new NoLanguageFoundException();

        String name;
        for (File child : childs) {
            try {
                name = getName(child.getAbsolutePath());
                ret.add(name);
            } catch (Exception e) {}
        }

        if (ret.size() == 0)
            throw new NoLanguageFoundException();

        return ret;
    }

    /*
     * CUSTOM EXCEPTIONS
     */

    public static class LanguageException extends Exception {
        public LanguageException(String msg) { super(msg); }
    }
    public static class LanguageFolderNotFoundException extends LanguageException {
        public LanguageFolderNotFoundException() {
            super("Languages folder is not found");
        }
    }
    public static class LanguageFolderWrongFormatException extends LanguageException {
        public LanguageFolderWrongFormatException() {
            super("content/languages is not a folder");
        }
    }
    public static class NoLanguageFoundException extends LanguageException {
        public NoLanguageFoundException() {
            super("No language file has been found");
        }
    }
}
