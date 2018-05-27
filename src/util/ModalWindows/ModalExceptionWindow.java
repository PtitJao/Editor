package util.ModalWindows;

public class ModalExceptionWindow extends ModalWindow<ModalController> {
    public ModalExceptionWindow(String title, String message) {
        super("Exception : " + title, message, "warningIcon.png", "modalWindow.fxml");

        start();
        System.exit(-1);
    }
}
