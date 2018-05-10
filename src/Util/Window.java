package Util;

import javafx.stage.Stage;

public class Window {
    protected Stage stage;

    protected void start(String title, String icon) {
        stage = new Stage();
        stage.setTitle(title);
        stage.getIcons().add(Util.loadImage(icon));
    }

    protected void requestFocus() {
        stage.setIconified(false);
        stage.requestFocus();
    }
}
