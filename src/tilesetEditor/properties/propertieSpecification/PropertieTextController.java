package tilesetEditor.properties.propertieSpecification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.PropertySpecification;
import settings.Settings;
import util.ModalWindows.ModalInfoWindow;

public class PropertieTextController extends PropertieSpecificationController<String> {

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
    void okClicked(ActionEvent event) {
        if (nameField.getText().equals("")) {
            new ModalInfoWindow(Settings.language.getWord("propertiesNameErrorTitle"), Settings.language.getWord("propertiesNameErrorText"));
            return;
        }
        PropertySpecification<String> spec = new PropertySpecification<>(nameField.getText(), valueField.getText(), colorPicker.getValue());
        window.setSpecif(spec);
        window.close();
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
