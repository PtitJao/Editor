/**
 * Sample Skeleton for 'paletteTerrain.fxml' Controller Class
 */

package mapEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import settings.Settings;
import util.Controller;

public class PaletteTerrainController extends Controller {

    @FXML // fx:id="layerLabel"
    private Label layerLabel; // Value injected by FXMLLoader

    @FXML // fx:id="layerChoice"
    private ChoiceBox<String> layerChoice; // Value injected by FXMLLoader

    @FXML // fx:id="selectionButton"
    private Button selectionButton; // Value injected by FXMLLoader

    @FXML // fx:id="pencilButton"
    private Button pencilButton; // Value injected by FXMLLoader

    @FXML // fx:id="eraseButton"
    private Button eraseButton; // Value injected by FXMLLoader

    @FXML // fx:id="squareButton"
    private Button squareButton; // Value injected by FXMLLoader

    @FXML // fx:id="roundButton"
    private Button roundButton; // Value injected by FXMLLoader

    @FXML // fx:id="tilesetPanel"
    private Pane tilesetPanel; // Value injected by FXMLLoader

    @FXML
    void addTilesetButton(ActionEvent event) {

    }

    @FXML
    void eraseClicked(ActionEvent event) {

    }

    @FXML
    void pencilClicked(ActionEvent event) {

    }

    @FXML
    void roundClicked(ActionEvent event) {

    }

    @FXML
    void selectionClicked(ActionEvent event) {

    }

    @FXML
    void squareClicked(ActionEvent event) {

    }

    @Override
    protected void languageChanged() {
        layerLabel.setText(Settings.language.getWord("layer") + " :");
    }
}
