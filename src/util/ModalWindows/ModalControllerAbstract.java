package util.ModalWindows;

import util.Controller;

public abstract class ModalControllerAbstract extends Controller {
    protected String message;
    protected ModalWindow window;

    public void setMessage(String s) {
        message = s;
    }

    public void setWindow(ModalWindow w) {
        window = w;
    }
}
