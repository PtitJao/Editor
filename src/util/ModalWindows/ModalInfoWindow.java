package util.ModalWindows;

public class ModalInfoWindow extends ModalWindow<ModalController> {
    public ModalInfoWindow(String title, String message) {
        super("Info : " + title, message, "InfoIcon.png", "modalWindow.fxml");

        start();
    }
}
