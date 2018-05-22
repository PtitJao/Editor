package settings;

import Util.ModalWindows.ModalExceptionWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SettingsController {

    /**
     *
     * FXML Window
     *
     */

    @FXML // fx:id="languageLabel"
    private Label languageLabel; // Value injected by FXMLLoader

    @FXML // fx:id="languageChoice"
    private ChoiceBox<String> languageChoice; // Value injected by FXMLLoader

    @FXML // fx:id="styleLabel"
    private Label styleLabel; // Value injected by FXMLLoader

    @FXML // fx:id="styleChoice"
    private ChoiceBox<String> styleChoice; // Value injected by FXMLLoader

    @FXML // fx:id="directoryLabel"
    private Label directoryLabel; // Value injected by FXMLLoader

    @FXML // fx:id="directoryField"
    private TextField directoryField; // Value injected by FXMLLoader

    @FXML // fx:id="directoryButton"
    private Button directoryButton; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="applyButton"
    private Button applyButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    /*
    *
    * LISTENERS
    *
     */

    @FXML
    void directoryChoose(ActionEvent event) {

    }

    @FXML
    void okClicked(ActionEvent event) {
        System.out.println("OK");
        System.out.println(directoryLabel.getText());
        reload(3);
    }

    @FXML
    void applyClicked(ActionEvent event) {

    }

    @FXML
    void cancelClicked(ActionEvent event) {

    }

    /*
    *
    * UTILITIES
    *
     */

    void reload(int test) {
        if (test % 2 == 1) {
            languageChanged();
        }
        test /= 2;
        if (test % 2 == 1) {
            //style
        }

        try {
            List<Pair<String, String>> names = Language.getLanguagesName();
            names.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            List<String> languages = new ArrayList<>();

            String active = "";

            for (int i = 0; i < names.size(); ++i) {
                Pair<String, String> p = names.get(i);
                String value = p.getValue() + " (" + p.getKey() + ")";
                if (p.getKey().equals(Settings.language.getName()))
                    active = value;
                languages.add(value);
            }

            ObservableList<String> list = FXCollections.observableList(languages);
            languageChoice.setItems(list);
            languageChoice.setValue(active);
        } catch (Language.LanguageException e) {
            new ModalExceptionWindow("Impossible to load languages", e.getMessage());
        }
    }

    private void languageChanged() {
        languageLabel.setText(Settings.language.getWord("settingsLanguageLabel") + " :");
        styleLabel.setText(Settings.language.getWord("settingsStyleLabel") + " :");
        directoryLabel.setText(Settings.language.getWord("settingsDirectoryLabel") + " :");
        okButton.setText(Settings.language.getWord("okButton"));
        applyButton.setText(Settings.language.getWord("applyButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
