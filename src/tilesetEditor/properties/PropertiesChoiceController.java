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
import model.Property;
import settings.Settings;
import util.Controller;
import util.ModalWindows.ModalInfoWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PropertiesChoiceController extends Controller {
    private PropertiesChoiceWindow window;
    private Property prop = null;

    @FXML // fx:id="textLabel"
    private Label textLabel; // Value injected by FXMLLoader

    @FXML // fx:id="typeChoice"
    private ChoiceBox<String> typeChoice; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    String[] types = {"bool", "int", "double", "char", "string"};
    ObservableList<String> oList;

    public void init(PropertiesChoiceWindow window) {
        this.window = window;

        List<String> list = new ArrayList<>();
        for (String type : types)
            list.add(Settings.language.getWord(type));

        oList = FXCollections.observableList(list);
        typeChoice.setItems(oList);
        typeChoice.setValue(oList.get(0));
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        window.close();
    }

    @FXML
    void okClicked(ActionEvent event) {
        String type = types[oList.indexOf(typeChoice.getValue())];
        PropertiesModifyWindow modifier;

        switch (type) {
            case "bool":
                modifier = new PropertiesModifyWindow<Boolean>(type);
                break;
            case "int":
                modifier = new PropertiesModifyWindow<Integer>(type);
                break;
            case "double":
                modifier = new PropertiesModifyWindow<Double>(type);
                break;
            case "char":
                modifier = new PropertiesModifyWindow<Character>(type);
                break;
            case "string":
                modifier = new PropertiesModifyWindow<String>(type);
                break;
            default:
                modifier = null;
                break;
        }

        if (modifier != null) {
            window.close();
            modifier.start();
            prop = modifier.getProp();
        } else
            new ModalInfoWindow(Settings.language.getWord("propertiesTypeErrorTitle"), Settings.language.getWord("propertiesTypeErrorText"));
    }

    public Property getProp() {
        return prop;
    }

    @Override
    protected void languageChanged() {
        textLabel.setText(Settings.language.getWord("propertiesQuestionLabel"));
        okButton.setText(Settings.language.getWord("okButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
