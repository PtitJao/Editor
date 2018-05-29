/**
 * Sample Skeleton for 'propertiesModifyWindow.fxml' Controller Class
 */

package tilesetEditor.properties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import settings.Settings;
import tilesetEditor.properties.propertieSpecification.PropertieSpecificationWindow;
import util.Controller;

import java.util.Set;

public class PropertiesModifyController extends Controller {
    private PropertiesModifyWindow window;

    @FXML // fx:id="nameLabel"
    private Label nameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private TableView<?> table; // Value injected by FXMLLoader

    @FXML // fx:id="nameColumn"
    private TableColumn<?, ?> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="valueColumn"
    private TableColumn<?, ?> valueColumn; // Value injected by FXMLLoader

    @FXML // fx:id="colorColumn"
    private TableColumn<?, ?> colorColumn; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    public void init(PropertiesModifyWindow window) {
        this.window = window;
    }

    @FXML
    void addClicked(ActionEvent event) {
        PropertieSpecificationWindow modifier = PropertieSpecificationWindow.getWindow("bool");
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        window.close();
    }

    @FXML
    void modifyClicked(ActionEvent event) {

    }

    @FXML
    void okClicked(ActionEvent event) {

    }

    @FXML
    void removeClicked(ActionEvent event) {

    }

    @Override
    protected void languageChanged() {
        nameLabel.setText(Settings.language.getWord("propertiesName") + " :");
        nameColumn.setText(Settings.language.getWord("propertiesName"));
        valueColumn.setText(Settings.language.getWord("propertiesValue"));
        colorColumn.setText(Settings.language.getWord("propertiesColor"));
        okButton.setText(Settings.language.getWord("okButton"));
        cancelButton.setText(Settings.language.getWord("cancelButton"));
    }
}
