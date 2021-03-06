/**
 * Sample Skeleton for 'propertiesModifyWindow.fxml' Controller Class
 */

package tilesetEditor.properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import model.Property;
import model.PropertySpecification;
import settings.Settings;
import tilesetEditor.properties.propertieSpecification.PropertieSpecificationWindow;
import util.Controller;
import util.ModalWindows.ModalConfirmWindow;
import util.ModalWindows.ModalInfoWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PropertiesModifyController<T> extends Controller {
    private PropertiesModifyWindow window;
    private Property<T> prop;
    private ObservableList<PropertySpecification<T>> oList;

    private int size;
    private List<Integer> remove = new ArrayList<>();

    @FXML // fx:id="nameLabel"
    private Label nameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private TableView<PropertySpecification<T>> table; // Value injected by FXMLLoader

    @FXML // fx:id="nameColumn"
    private TableColumn<PropertySpecification<T>, String> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="valueColumn"
    private TableColumn<PropertySpecification<T>, T> valueColumn; // Value injected by FXMLLoader

    @FXML // fx:id="colorColumn"
    private TableColumn<PropertySpecification<T>, Color> colorColumn; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    public void init(PropertiesModifyWindow window) {
        this.window = window;
        oList = FXCollections.observableList(new ArrayList<>(prop.getSpecif()));
        nameField.setText(prop.getName());
        size = prop.getSpecif().size();

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        table.setItems(oList);
    }

    @FXML
    void addClicked(ActionEvent event) {
        PropertieSpecificationWindow modifier = PropertieSpecificationWindow.getWindow(window.getType());
        PropertySpecification<T> spec = modifier.getSpecif();

        if (spec != null)
            oList.add(spec);

    }

    @FXML
    void cancelClicked(ActionEvent event) {
        if (!oList.equals(prop.getSpecif()))
            if (new ModalConfirmWindow(Settings.language.getWord("modificationDone") + ".\n" + Settings.language.getWord("quitQuestion")).getResult())
                return;
        window.close();
    }

    @FXML
    void modifyClicked(ActionEvent event) {
        PropertySpecification<T> spec = table.getSelectionModel().getSelectedItem();

        if (spec != null) {
            PropertieSpecificationWindow modifier = PropertieSpecificationWindow.getWindow(window.getType(), spec);
            oList.set(oList.indexOf(spec), modifier.getSpecif());
        }
    }

    @FXML
    void okClicked(ActionEvent event) {
        if (nameField.getText().equals("")) {
            new ModalInfoWindow(Settings.language.getWord("propertiesNameErrorTitle"), Settings.language.getWord("propertiesNameErrorText"));
            return;
        } else if (oList.size() == 0) {
            new ModalInfoWindow(Settings.language.getWord("propertiesEmptyErrorTitle"), Settings.language.getWord("propertiesEmptyErrorText"));
            return;
        }
        prop.setName(nameField.getText());
        prop.setSpecif(oList);
        window.close();
    }

    @FXML
    void removeClicked(ActionEvent event) {
        PropertySpecification<T> spec = table.getSelectionModel().getSelectedItem();

        if (spec != null) {
            if (oList.indexOf(spec) < size) {
                size--;
                remove.add(oList.indexOf(spec));
            }

            oList.remove(spec);
        }
    }

    public Property getProp() {
        return prop;
    }

    public void setProp(Property prop) {
        this.prop = prop;
    }

    public List<Integer> getRemove() { return remove; }

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
