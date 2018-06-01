/**
 * Sample Skeleton for 'newMapWindow.fxml' Controller Class
 */

package mapEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import model.Tileset;
import settings.Settings;
import util.Controller;
import util.ModalWindows.ModalInfoWindow;

import java.util.List;

public class NewMapController extends Controller {
    private NewMapWindow window;

    @FXML // fx:id="nameLabel"
    private Label nameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tilesetLabel"
    private Label tilesetLabel; // Value injected by FXMLLoader

    @FXML // fx:id="mapWidthLabel"
    private Label mapWidthLabel; // Value injected by FXMLLoader

    @FXML // fx:id="mapHeightLabel"
    private Label mapHeightLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tileWidthLabel"
    private Label tileWidthLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tileHeightLabel"
    private Label tileHeightLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="tilesetChoice"
    private ChoiceBox<String> tilesetChoice; // Value injected by FXMLLoader

    @FXML // fx:id="mapWidthSpinner"
    private Spinner<Integer> mapWidthSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="mapHeightSpinner"
    private Spinner<Integer> mapHeightSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="tileWidthSpinner"
    private Spinner<Integer> tileWidthSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="tileHeightSpinner"
    private Spinner<Integer> tileHeightSpinner; // Value injected by FXMLLoader

    @FXML // fx:id="tilesetPanel"
    private Pane tilesetPanel; // Value injected by FXMLLoader

    @FXML // fx:id="tileLabel"
    private Label tileLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tileButton"
    private Button tileButton; // Value injected by FXMLLoader

    @FXML // fx:id="tilePanel"
    private Pane tilePanel; // Value injected by FXMLLoader

    @FXML // fx:id="createButton"
    private Button createButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    private int tilePicked = -1;
    private ObservableList<String> oList;

    public void init(NewMapWindow window) {
        this.window = window;

        List<String> tmp = Tileset.getTilesets();
        tmp.add(0, "None");
        oList = FXCollections.observableList(tmp);

        tilesetChoice.setItems(oList);
        tilesetChoice.setValue("None");

        mapWidthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 500, 100));
        mapHeightSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 500, 100));
        tileWidthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 50, 25));
        tileHeightSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 50, 25));

        mapWidthSpinner.focusedProperty().addListener((s, ov, nv) -> {
            if (!nv) {
                String text = mapWidthSpinner.getEditor().getText();
                StringConverter<Integer> converter = mapWidthSpinner.getValueFactory().getConverter();

                if (converter != null)
                    mapWidthSpinner.getValueFactory().setValue(converter.fromString(text));
            }
        });
        mapHeightSpinner.focusedProperty().addListener((s, ov, nv) -> {
            if (!nv) {
                String text = mapHeightSpinner.getEditor().getText();
                StringConverter<Integer> converter = mapHeightSpinner.getValueFactory().getConverter();

                if (converter != null)
                    mapHeightSpinner.getValueFactory().setValue(converter.fromString(text));
            }
        });
        tileWidthSpinner.focusedProperty().addListener((s, ov, nv) -> {
            if (!nv) {
                String text = tileWidthSpinner.getEditor().getText();
                StringConverter<Integer> converter = tileWidthSpinner.getValueFactory().getConverter();

                if (converter != null)
                    tileWidthSpinner.getValueFactory().setValue(converter.fromString(text));
            }
        });
        tileHeightSpinner.focusedProperty().addListener((s, ov, nv) -> {
            if (!nv) {
                String text = tileHeightSpinner.getEditor().getText();
                StringConverter<Integer> converter = tileHeightSpinner.getValueFactory().getConverter();

                if (converter != null)
                    tileHeightSpinner.getValueFactory().setValue(converter.fromString(text));
            }
        });
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        window.close();
    }

    @FXML
    void createClicked(ActionEvent event) {
        if (nameField.getText().equals("")) {
            new ModalInfoWindow(Settings.language.getWord("mapNameErrorTitle"), Settings.language.getWord("mapNameErrorText"));
            return;
        }

        MapDisplay map = null;
        if (tilePicked != -1)
            map = new MapDisplay(nameField.getText(), mapWidthSpinner.getValue(), mapHeightSpinner.getValue(), tileWidthSpinner.getValue(), tileHeightSpinner.getValue());
        /*
        else
            map = new MapDisplay(nameField.getText(), mapWidthSpinner.getValue(), mapHeightSpinner.getValue(), tileWidthSpinner.getValue(), tileHeightSpinner.getValue(), tileset, tilePicked);
         */

        window.setMap(map);

        window.close();
    }

    @FXML
    void noneClicked(ActionEvent event) {
        tilePicked = -1;
    }

    @Override
    protected void languageChanged() {
        nameLabel.setText(Settings.language.getWord("mapNameLabel") + " :");
        tilesetLabel.setText(Settings.language.getWord("tilesetLabel") + " :");
        mapWidthLabel.setText(Settings.language.getWord("mapWidthLabel") + " :");
        mapHeightLabel.setText(Settings.language.getWord("mapHeightLabel") + " :");
        tileWidthLabel.setText(Settings.language.getWord("tileWidthLabel") + " :");
        tileHeightLabel.setText(Settings.language.getWord("tileHeightLabel") + " :");

        tileLabel.setText(Settings.language.getWord("tileLabel") + " :");
        tileButton.setText(Settings.language.getWord("tileButton"));

        createButton.setText(Settings.language.getWord("createButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
