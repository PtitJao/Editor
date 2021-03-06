package settings;

import mapEditor.MapWindow;
import util.Controller;
import util.ModalWindows.ModalExceptionWindow;
import util.ModalWindows.ModalInfoWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.util.Pair;
import tilesetEditor.TilesetWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SettingsController extends Controller {

    /*
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

    private List<Pair<String, String>> names;
    private ObservableList<String> languages;

    /*
    *
    * LISTENERS
    *
     */

    @FXML
    void directoryChoose(ActionEvent event) {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle(Settings.language.getWord("settingsDirectoryChooser"));
        File file = dc.showDialog(SettingsWindow.INSTANCE.getStage());
        if (file != null)
            directoryField.setText(file.getAbsolutePath());
    }

    @FXML
    void okClicked(ActionEvent event) {
        applyClicked(event);
        SettingsWindow.INSTANCE.close();
    }

    @FXML
    void applyClicked(ActionEvent event) {
        int reloadValue = 0;

        if (!(Settings.language.getName().equals(names.get(languages.indexOf(languageChoice.getValue())).getKey()))) {
            reloadValue += 1;

            Settings.loadLanguage(names.get(languages.indexOf(languageChoice.getValue())).getKey());
        }

        boolean test = false;
        if (!directoryField.getText().equals("")) {
            File defaultDirectory = new File(directoryField.getText());

            test = !defaultDirectory.exists() || !defaultDirectory.isDirectory();
        }

        Settings.defaultDirectory = directoryField.getText();

        SettingsWindow.INSTANCE.reload(reloadValue);

        reloadAll(reloadValue);

        if (test) {
            new ModalInfoWindow(Settings.language.getWord("settingsDirectoryErrorTitle"), directoryField.getText() + " " + Settings.language.getWord("settingsDirectoryErrorMessage"));
            directoryField.setText("");
            Settings.defaultDirectory = directoryField.getText();
        }

        Settings.save();
    }

    private void reloadAll(int value) {
        if (TilesetWindow.INSTANCE != null)
            TilesetWindow.INSTANCE.reload(value);
        if (MapWindow.INSTANCE != null)
            MapWindow.INSTANCE.reload(value);
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        SettingsWindow.INSTANCE.close();
    }

    /*
    *
    * UTILITIES
    *
     */

    @Override
    public void reload(int value) {
        super.reload(value);

        directoryField.setText(Settings.defaultDirectory);
        try {
            names = Language.getLanguagesName();
            names.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            List<String> list = new ArrayList<>();

            String active = "";

            for (int i = 0; i < names.size(); ++i) {
                Pair<String, String> p = names.get(i);
                String tmp = p.getValue() + " (" + p.getKey() + ")";
                if (p.getKey().equals(Settings.language.getName()))
                    active = tmp;
                list.add(tmp);
            }

            languages = FXCollections.observableList(list);
            languageChoice.setItems(languages);
            languageChoice.setValue(active);
        } catch (Language.LanguageException e) {
            new ModalExceptionWindow("Impossible to load languages", e.getMessage());
        }
    }

    @Override
    protected void languageChanged() {
        languageLabel.setText(Settings.language.getWord("settingsLanguageLabel") + " :");
        styleLabel.setText(Settings.language.getWord("settingsStyleLabel") + " :");
        directoryLabel.setText(Settings.language.getWord("settingsDirectoryLabel") + " :");
        okButton.setText(Settings.language.getWord("okButton"));
        applyButton.setText(Settings.language.getWord("applyButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
