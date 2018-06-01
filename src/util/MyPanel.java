package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import util.ModalWindows.ModalExceptionWindow;

import java.net.URL;

public class MyPanel<T extends Controller> {
    protected Parent root;
    protected T controller;

    protected void load(URL fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
            fxmlLoader.load();
            controller = fxmlLoader.getController();
            root = fxmlLoader.getRoot();
        } catch (Exception e) {
            e.printStackTrace();
            new ModalExceptionWindow(fxmlFile.toString() + " not found", "File " + fxmlFile.toString() + " has not been found.");
        }
    }

    public void reload(int value) {
        controller.reload(value);
    }

    public Parent getRoot() {
        return root;
    }
}
