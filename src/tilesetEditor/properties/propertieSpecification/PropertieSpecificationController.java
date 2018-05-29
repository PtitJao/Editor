package tilesetEditor.properties.propertieSpecification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import util.Controller;

public abstract class PropertieSpecificationController<T> extends Controller {
    protected PropertieSpecificationWindow window;

    public void init(PropertieSpecificationWindow window) {
        this.window = window;
    }

    @FXML
    void cancelClicked(ActionEvent event) {
        window.close();
    }
}
