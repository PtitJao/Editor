package Util.ModalWindows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ModalController extends ModalControllerAbstract {
    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {
        window.getStage().close();
    }

    @Override
    protected void languageChanged() {
        label.setText(message);
        button1.setText("Ok");
    }
}
