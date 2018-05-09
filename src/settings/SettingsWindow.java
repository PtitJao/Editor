package settings;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SettingsWindow {
    public static SettingsWindow INSTANCE;

    private Stage stage;

    public void start() {
        INSTANCE = this;

        Scene scene = new Scene(new Group(), Color.BLACK);

        stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Settings windows");
        stage.show();

        stage.setOnCloseRequest(e -> INSTANCE = null);
    }

    private void requestFocus() {
        stage.setIconified(false);
        stage.requestFocus();
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new SettingsWindow().start();
        INSTANCE.requestFocus();
    }
}
