package settings;

import Util.Window;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class SettingsWindow extends Window {
    public static SettingsWindow INSTANCE;

    public void start() {
        String title = Settings.language.getWord("settings");

        System.out.println(title);

        super.start(title, "preferencesicon.png");
        INSTANCE = this;

        Scene scene = new Scene(new Group(), Color.BLACK);

        stage.setScene(scene);

        stage.setOnCloseRequest(e -> INSTANCE = null);

        stage.show();
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new SettingsWindow().start();
        INSTANCE.requestFocus();
    }
}
