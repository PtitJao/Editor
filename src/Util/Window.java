package Util;

import Util.ModalWindows.ModalExceptionWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;

public class Window<T extends  Controller> {
    protected Stage stage;
    protected T controller;

    protected void start(String title, String icon, URL fxmlFile) {
        stage = new Stage();
        stage.setTitle(title);
        stage.getIcons().add(Util.loadImage(icon));


        Scene scene = null;
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
            fxmlLoader.load();
            controller = fxmlLoader.getController();
            root = fxmlLoader.getRoot();

            scene = new Scene(root, Color.BLACK);
        } catch (Exception e) {
            new ModalExceptionWindow("Settings fxml not found", "File settingsWindow.fxml has not been found.");
        }

        stage.setScene(scene);
    }

    public void reload(int value) {
        controller.reload(value);
    }

    protected void requestFocus() {
        stage.setIconified(false);
        stage.requestFocus();
    }

    public Stage getStage() {
        return stage;
    }
}
