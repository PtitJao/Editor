/**
 * Sample Skeleton for 'propertiesChoiceWindow.fxml' Controller Class
 */

package tilesetEditor.properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import settings.Settings;
import util.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PropertiesChoiceController extends Controller {
    private PropertiesChoiceWindow window;

    @FXML // fx:id="textLabel"
    private Label textLabel; // Value injected by FXMLLoader

    @FXML // fx:id="typeChoice"
    private ChoiceBox<String> typeChoice; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    String[] types = {"bool", "int", "double", "char", "string"};

    public void init(PropertiesChoiceWindow window) {
        this.window = window;

        List<String> list = new ArrayList<>();
        for (String type : types)
            list.add(Settings.language.getWord(type));

        ObservableList<String> oList = FXCollections.observableList(list);
        typeChoice.setItems(oList);
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        window.close();
    }

    @FXML
    void okClicked(ActionEvent event) {
        new PropertiesModifyWindow().start();
    }

    @Override
    protected void languageChanged() {
        textLabel.setText(Settings.language.getWord("propertiesQuestionLabel"));
        okButton.setText(Settings.language.getWord("okButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
