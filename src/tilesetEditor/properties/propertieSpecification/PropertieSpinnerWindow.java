package tilesetEditor.properties.propertieSpecification;

import model.PropertySpecification;

public class PropertieSpinnerWindow<T> extends PropertieSpecificationWindow<T, PropertieSpinnerController<T>> {
    private String type;

    public PropertieSpinnerWindow(PropertySpecification<T> specif) {
        super(specif);
    }

    public void start(String type) {
        this.type = type;
        super.start(getClass().getResource("propertieSpinnerWindow.fxml"));
    }

    public String getType() {
        return type;
    }
}
