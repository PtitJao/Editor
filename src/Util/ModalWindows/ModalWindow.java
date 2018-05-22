package Util.ModalWindows;

import Util.Window;

public abstract class ModalWindow<T extends ModalControllerAbstract> extends Window<T> {
    public ModalWindow(String title, String message, String icon, String fxmlFile) {
        start(title, icon, getClass().getResource(fxmlFile));
        controller.setMessage(message);
        controller.setWindow(this);
        controller.reload(3);
    }

    protected void start() {
        stage.showAndWait();
    }
}
