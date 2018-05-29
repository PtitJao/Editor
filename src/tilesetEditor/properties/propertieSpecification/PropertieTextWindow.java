package tilesetEditor.properties.propertieSpecification;

import model.PropertySpecification;

public class PropertieTextWindow extends PropertieSpecificationWindow<String, PropertieTextController> {
    public PropertieTextWindow(PropertySpecification<String> specif) {
        super(specif);
    }

    public void start() {
        super.start(getClass().getResource("propertieTextWindow.fxml"));

        controller.init(this);
    }
}
