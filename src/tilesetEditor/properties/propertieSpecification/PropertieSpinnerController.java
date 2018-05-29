package tilesetEditor.properties.propertieSpecification;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.PropertySpecification;
import settings.Settings;
import util.ModalWindows.ModalInfoWindow;

import java.util.ArrayList;
import java.util.List;

public class PropertieSpinnerController<T> extends PropertieSpecificationController<T> {

    @FXML
    private Label nameLabel;

    @FXML
    private Label valueLabel;

    @FXML
    private Label colorLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Spinner<T> valueSpinner;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    private SpinnerValueFactory getFactory(String type) {
        switch (type) {
            case "int":
                return new SpinnerValueFactory.IntegerSpinnerValueFactory(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            case "double":
                return new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE, Double.MAX_VALUE, 0);
            case "char":
                List<Character> chars = new ArrayList<>();

                for(int i = 0; i < 26; ++i)
                    chars.add((char)('a' + i));
                for(int i = 0; i < 26; ++i)
                    chars.add((char)('A' + i));
                for(int i = 0; i < 10; ++i)
                    chars.add((char)('0' + i));

                chars.add('#');
                chars.add('%');
                chars.add('&');
                chars.add('_');
                chars.add('@');
                chars.add('-');
                chars.add('+');
                chars.add('*');
                chars.add('/');
                chars.add('$');
                chars.add('=');
                chars.add('(');
                chars.add(')');
                chars.add('[');
                chars.add(']');
                chars.add('|');

                return new SpinnerValueFactory.ListSpinnerValueFactory<Character>(FXCollections.observableList(chars));
            default:
                return null;
        }
    }

    public void init(PropertieSpecificationWindow window, String type) {
        super.init(window);
        valueSpinner.setValueFactory(getFactory(type));

        PropertySpecification<T> spec = window.getSpecif();
        if (spec != null) {
            nameField.setText(spec.getName());
            valueSpinner.getValueFactory().setValue(spec.getValue());
            colorPicker.setValue(spec.getColor());
        }
    }

    @FXML
    void okClicked(ActionEvent event) {
        if (nameField.getText().equals("")) {
            new ModalInfoWindow(Settings.language.getWord("propertiesNameErrorTitle"), Settings.language.getWord("propertiesNameErrorText"));
            return;
        }
        PropertySpecification<T> spec = new PropertySpecification<>(nameField.getText(), valueSpinner.getValue(), colorPicker.getValue());
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
