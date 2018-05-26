package Util;

import Util.ModalWindows.ModalExceptionWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Window<T extends  Controller> {
    private static String ICON_PATH = "window" + File.separator;

    protected Stage stage;
    protected T controller;

    protected void start(String title, String icon, URL fxmlFile) {
        stage = new Stage();
        stage.setTitle(title);
        stage.getIcons().add(Util.loadImage(ICON_PATH + icon));


        Scene scene = null;
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
            fxmlLoader.load();
            controller = fxmlLoader.getController();
            root = fxmlLoader.getRoot();

            scene = new Scene(root, Color.BLACK);
        } catch (Exception e) {
            e.printStackTrace();
            new ModalExceptionWindow(fxmlFile.toString() + " not found", "File " + fxmlFile.toString() + " has not been found.");
        }

        stage.setScene(scene);
        stage.sizeToScene();
    }

    public void reload(int value) {
        controller.reload(value);
        stage.sizeToScene();
    }

    protected void requestFocus() {
        stage.setIconified(false);
        stage.requestFocus();
    }

    public Stage getStage() {
        return stage;
    }
}
