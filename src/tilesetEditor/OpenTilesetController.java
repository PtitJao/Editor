/**
 * Sample Skeleton for 'openTilesetWindow.fxml' Controller Class
 */

package tilesetEditor;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import model.Tileset;
import settings.Settings;
import util.Controller;
import util.ModalWindows.ModalInfoWindow;

public class OpenTilesetController extends Controller {

    @FXML // fx:id="label"
    private Label label; // Value injected by FXMLLoader

    @FXML // fx:id="choice"
    private ChoiceBox<String> choice; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    private OpenTilesetWindow window;

    public void init(OpenTilesetWindow window) {
        this.window = window;

        choice.setItems(FXCollections.observableList(Tileset.getTilesets()));
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        window.close();
    }

    @FXML
    void okClicked(ActionEvent event) {
        if (choice.getValue() == null) {
            new ModalInfoWindow(Settings.language.getWord("tilesetOpenErrorTitle"), Settings.language.getWord("tilesetOpenErrorText"));
            return;
        }
        window.setChoosed(choice.getValue());
        window.close();
    }

    @Override
    protected void languageChanged() {
        label.setText(Settings.language.getWord("tilesetOpenLabel") + " :");
        okButton.setText(Settings.language.getWord("okButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
