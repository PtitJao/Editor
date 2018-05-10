package Util.ModalWindows;

import Util.Window;

public class ModalWindow extends Window {
    public ModalWindow(String title, String icon) {
        start(title, icon);
    }

    protected void start() {
        stage.showAndWait();
    }
}
