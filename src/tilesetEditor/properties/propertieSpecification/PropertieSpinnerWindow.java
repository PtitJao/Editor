package tilesetEditor.properties.propertieSpecification;

public class PropertieSpinnerWindow<T> extends PropertieSpecificationWindow<PropertieSpinnerController<T>> {
    public void start(String type) {
        super.start(getClass().getResource("propertieSpinnerWindow.fxml"));

        controller.init(this, type);
    }
}