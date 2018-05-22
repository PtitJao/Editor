package Util.ModalWindows;

public class ModalConfirmWindow extends ModalWindow<ModalConfirmController> {
    private boolean result = false;

    public ModalConfirmWindow(String title, String message, String icon, String fxmlFile) {
        super(title, message, icon, fxmlFile);
        start();
    }

    public void yesClicked() {
        result = true;
    }

    public boolean getResult() { return result; }
}
