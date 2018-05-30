package tilesetEditor.properties.propertieSpecification;

import model.PropertySpecification;

public class PropertieBoolWindow extends PropertieSpecificationWindow<Boolean, PropertieBoolController> {
    public PropertieBoolWindow(PropertySpecification<Boolean> specif) {
        super(specif);
    }

    public void start() {
        super.start(getClass().getResource("propertieBoolWindow.fxml"));
    }
}
