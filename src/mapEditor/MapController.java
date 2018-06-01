/**
 * Sample Skeleton for 'mapEditorWindow.fxml' Controller Class
 */

package mapEditor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import settings.Settings;
import settings.SettingsWindow;
import tilesetEditor.TilesetWindow;
import util.Controller;

public class MapController extends Controller{

    @FXML // fx:id="menuFile"
    private Menu menuFile; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileNew"
    private MenuItem menuFileNew; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileOpen"
    private MenuItem menuFileOpen; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileSave"
    private MenuItem menuFileSave; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileClose"
    private MenuItem menuFileClose; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileSettings"
    private MenuItem menuFileSettings; // Value injected by FXMLLoader

    @FXML // fx:id="menuFileQuit"
    private MenuItem menuFileQuit; // Value injected by FXMLLoader

    @FXML // fx:id="menuEdit"
    private Menu menuEdit; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditUndo"
    private MenuItem menuEditUndo; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditRedo"
    private MenuItem menuEditRedo; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditCut"
    private MenuItem menuEditCut; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditCopy"
    private MenuItem menuEditCopy; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditPaste"
    private MenuItem menuEditPaste; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditDelete"
    private MenuItem menuEditDelete; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditSelectAll"
    private MenuItem menuEditSelectAll; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditClearSelection"
    private MenuItem menuEditClearSelection; // Value injected by FXMLLoader

    @FXML // fx:id="menuLayer"
    private Menu menuLayer; // Value injected by FXMLLoader

    @FXML // fx:id="menuLayerPalette"
    private MenuItem menuLayerPalette; // Value injected by FXMLLoader

    @FXML // fx:id="menuLayerShowTerrain"
    private Menu menuLayerShowTerrain; // Value injected by FXMLLoader

    @FXML // fx:id="menuLayerShowAllTerrain"
    private CheckMenuItem menuLayerShowAllTerrain; // Value injected by FXMLLoader

    @FXML // fx:id="menuLayerShowObject"
    private Menu menuLayerShowObject; // Value injected by FXMLLoader

    @FXML // fx:id="menuLayerShowAllObject"
    private CheckMenuItem menuLayerShowAllObject; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditors"
    private Menu menuEditors; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditorsGameObjectEditor"
    private MenuItem menuEditorsGameObjectEditor; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditorsAnimationEditor"
    private MenuItem menuEditorsAnimationEditor; // Value injected by FXMLLoader

    @FXML // fx:id="menuEditorsTilesetEditor"
    private MenuItem menuEditorsTilesetEditor; // Value injected by FXMLLoader

    @FXML // fx:id="menuHelp"
    private Menu menuHelp; // Value injected by FXMLLoader

    @FXML // fx:id="menuHelpAbout"
    private MenuItem menuHelpAbout; // Value injected by FXMLLoader

    @FXML // fx:id="mapPanel"
    private ScrollPane mapPanel; // Value injected by FXMLLoader

    @FXML // fx:id="minimapPanel"
    private Pane minimapPanel; // Value injected by FXMLLoader

    @FXML // fx:id="previewPanel"
    private Pane previewPanel; // Value injected by FXMLLoader

    @FXML // fx:id="fileTree"
    private TreeView<?> fileTree; // Value injected by FXMLLoader

    public void init() {
        Palette.launchWindow();
    }

    @FXML
    void aboutClicked(ActionEvent event) {

    }

    @FXML
    void animationEditorClicked(ActionEvent event) {

    }

    @FXML
    void clearSelectionClicked(ActionEvent event) {

    }

    @FXML
    void closeClicked(ActionEvent event) {

    }

    @FXML
    void copyClicked(ActionEvent event) {

    }

    @FXML
    void cutClicked(ActionEvent event) {

    }

    @FXML
    void deleteClicked(ActionEvent event) {

    }

    @FXML
    void gameObjectEditorClicked(ActionEvent event) {

    }

    @FXML
    void newMapClicked(ActionEvent event) {
        new NewMapWindow().start();
    }

    @FXML
    void openClicked(ActionEvent event) {

    }

    @FXML
    void paletteClicked(ActionEvent event) {
        Palette.launchWindow();
    }

    @FXML
    void pasteClicked(ActionEvent event) {

    }

    @FXML
    void quitClicked(ActionEvent event) {
        MapWindow.INSTANCE.close();
    }

    @FXML
    void redoClicked(ActionEvent event) {

    }

    @FXML
    void saveClicked(ActionEvent event) {

    }

    @FXML
    void selectAllClicked(ActionEvent event) {

    }

    @FXML
    void settingsClicked(ActionEvent event) {
        SettingsWindow.launchWindow();
    }

    @FXML
    void showAllObjectClicked(ActionEvent event) {

    }

    @FXML
    void showAllTerrainClicked(ActionEvent event) {

    }

    @FXML
    void tilesetEditorClicked(ActionEvent event) {
        TilesetWindow.launchWindow();
    }

    @FXML
    void undoClicked(ActionEvent event) {

    }

    @Override
    protected void languageChanged() {
        menuFile.setText(Settings.language.getWord("menuFile"));
        menuFileNew.setText(Settings.language.getWord("menuFileNew"));
        menuFileOpen.setText(Settings.language.getWord("menuFileOpen"));
        menuFileSave.setText(Settings.language.getWord("menuFileSave"));
        menuFileClose.setText(Settings.language.getWord("menuFileClose"));
        menuFileSettings.setText(Settings.language.getWord("menuFileSettings"));
        menuFileQuit.setText(Settings.language.getWord("menuFileQuit"));

        menuEdit.setText(Settings.language.getWord("menuEdit"));
        menuEditUndo.setText(Settings.language.getWord("menuEditUndo"));
        menuEditRedo.setText(Settings.language.getWord("menuEditRedo"));
        menuEditCut.setText(Settings.language.getWord("menuEditCut"));
        menuEditCopy.setText(Settings.language.getWord("menuEditCopy"));
        menuEditPaste.setText(Settings.language.getWord("menuEditPaste"));
        menuEditDelete.setText(Settings.language.getWord("menuEditDelete"));
        menuEditSelectAll.setText(Settings.language.getWord("menuEditSelectAll"));
        menuEditClearSelection.setText(Settings.language.getWord("menuEditClearSelection"));

        menuLayer.setText(Settings.language.getWord("menuLayer"));
        menuLayerPalette.setText(Settings.language.getWord("menuLayerPalette"));
        menuLayerShowTerrain.setText(Settings.language.getWord("menuLayerShowTerrain"));
        menuLayerShowObject.setText(Settings.language.getWord("menuLayerShowObject"));
        menuLayerShowAllTerrain.setText(Settings.language.getWord("menuLayerShowAll"));
        menuLayerShowAllObject.setText(Settings.language.getWord("menuLayerShowAll"));

        menuEditors.setText(Settings.language.getWord("menuEditors"));
        menuEditorsGameObjectEditor.setText(Settings.language.getWord("objectTitle"));
        menuEditorsAnimationEditor.setText(Settings.language.getWord("animationTitle"));
        menuEditorsTilesetEditor.setText(Settings.language.getWord("tilesetTitle"));

        menuHelp.setText(Settings.language.getWord("menuHelp"));
        menuHelpAbout.setText(Settings.language.getWord("menuHelpAbout"));
    }
}
