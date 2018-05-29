package tilesetEditor.properties.propertieSpecification;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class PropertieBoolController extends PropertieSpecificationController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private Label colorLabel;

    @FXML
    private TextField nameField;

    @FXML
    private ChoiceBox<Boolean> valueChoice;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @Override
    public void init(PropertieSpecificationWindow window) {
        super.init(window);
        List<Boolean> list = new ArrayList<>();
        list.add(Boolean.TRUE);
        list.add(Boolean.FALSE);
        valueChoice.setItems(FXCollections.observableList(list));
        valueChoice.setValue(Boolean.TRUE);
    }

    @FXML
    void cancelClicked(ActionEvent event) {

    }

    @FXML
    void okClicked(ActionEvent event) {

    }

    @Override
    protected void languageChanged() {
        nameLabel.setText(Settings.language.getWord("propertiesName") + " :");
        valueLabel.setText(Settings.language.getWord("propertiesValue") + " :");
        colorLabel.setText(Settings.language.getWord("propertiesColor") + " :");
        okButton.setText(Settings.language.getWord("okButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
