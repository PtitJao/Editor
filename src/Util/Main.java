package Util;

import javafx.application.Application;
import javafx.stage.Stage;
import settings.Settings;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Settings.init();

        new Test().start();
    }
}
