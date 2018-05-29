package tilesetEditor.properties.propertieSpecification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import settings.Settings;

public class PropertieTextController extends PropertieSpecificationController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private Label colorLabel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField valueField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

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
