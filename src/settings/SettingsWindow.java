package settings;

import util.Window;
import javafx.stage.Modality;

public class SettingsWindow extends Window<SettingsController> {
    public static SettingsWindow INSTANCE;

    public void start() {
        String title = Settings.language.getWord("settingsTitle");

        super.start(title, "preferencesicon.png", getClass().getResource("settingsWindow.fxml"));
        INSTANCE = this;

        controller.reload(3);
        stage.setOnCloseRequest(e -> INSTANCE = null);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    public void close() {
        stage.close();
        INSTANCE = null;
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new SettingsWindow().start();
        else
            INSTANCE.requestFocus();
    }
}
