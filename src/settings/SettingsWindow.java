package settings;

import Util.ModalWindows.ModalExceptionWindow;
import Util.Window;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;

public class SettingsWindow extends Window {
    public static SettingsWindow INSTANCE;

    private SettingsController controller;

    public void start() {
        String title = Settings.language.getWord("settingsTitle");

        super.start(title, "preferencesicon.png");
        INSTANCE = this;

        Scene scene = null;
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("settingsWindow.fxml"));
            fxmlLoader.load();
            controller = fxmlLoader.getController();
            root = fxmlLoader.getRoot();

            scene = new Scene(root, Color.BLACK);
        } catch (Exception e) {
            e.printStackTrace();
            new ModalExceptionWindow("Settings fxml not found", "File settingsWindow.fxml has not been found.");
        }

        controller.reload(3);
        stage.setScene(scene);

        stage.setOnCloseRequest(e -> INSTANCE = null);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void reload() {
        controller.reload(3);
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new SettingsWindow().start();
        else
            INSTANCE.requestFocus();
    }
}
