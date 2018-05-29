package tilesetEditor.properties.propertieSpecification;

import model.PropertySpecification;

public class PropertieSpinnerWindow<T> extends PropertieSpecificationWindow<T, PropertieSpinnerController<T>> {
    public PropertieSpinnerWindow(PropertySpecification<T> specif) {
        super(specif);
    }

    public void start(String type) {
        super.start(getClass().getResource("propertieSpinnerWindow.fxml"));

        controller.init(this, type);
    }
}
