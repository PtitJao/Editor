package Util.ModalWindows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import settings.Settings;

public class ModalConfirmController extends ModalControllerAbstract {
    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader

    @FXML
    void noButtonPressed(ActionEvent event) {
        ((ModalConfirmWindow)window).yesClicked();
        window.getStage().close();
    }

    @FXML
    void yesButtonPressed(ActionEvent event) {
        window.getStage().close();
    }

    @Override
    protected void languageChanged() {
        label.setText(message);
        button1.setText(Settings.language.getWord("yes"));
        button2.setText(Settings.language.getWord("no"));
    }
}
