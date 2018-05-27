package util.ModalWindows;

public class ModalConfirmWindow extends ModalWindow<ModalConfirmController> {
    private boolean result = false;

    public ModalConfirmWindow(String title, String message) {
        super(title, message, "question16.png", "confirmWindow.fxml");
        start();
    }

    public void yesClicked() {
        result = true;
    }

    public boolean getResult() { return result; }
}
