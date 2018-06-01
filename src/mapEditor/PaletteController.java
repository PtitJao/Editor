/**
 * Sample Skeleton for 'palette.fxml' Controller Class
 */

package mapEditor;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import settings.Settings;
import util.Controller;

public class PaletteController extends Controller {
    private PaletteTerrainPanel terrainPanel;

    @FXML // fx:id="paletteLabel"
    private Label paletteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="paletteChoice"
    private ChoiceBox<String> paletteChoice; // Value injected by FXMLLoader

    @FXML // fx:id="palettePanel"
    private Pane palettePanel; // Value injected by FXMLLoader

    public void init() {
        terrainPanel = new PaletteTerrainPanel();
        terrainPanel.load();

        palettePanel.getChildren().add(terrainPanel.getRoot());
    }

    @Override
    public void reload(int value) {
        super.reload(value);
        terrainPanel.reload(value);
    }

    @Override
    protected void languageChanged() {
        paletteLabel.setText(Settings.language.getWord("palette") + " :");
    }
}
