package util.ModalWindows;

import settings.Settings;

public class ModalConfirmWindow extends ModalWindow<ModalConfirmController> {
    private boolean result = false;

    public ModalConfirmWindow(String message) {
        super(Settings.language.getWord("confirmationTitle"), message, "question16.png", "confirmWindow.fxml");
        start();
    }

    public void yesClicked() {
        result = true;
    }

    public boolean getResult() { return result; }
}
