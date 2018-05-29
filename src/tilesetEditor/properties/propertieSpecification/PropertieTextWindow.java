package tilesetEditor.properties.propertieSpecification;

public class PropertieTextWindow extends PropertieSpecificationWindow<PropertieTextController> {
    public void start() {
        super.start(getClass().getResource("propertieTextWindow.fxml"));

        controller.init(this);
    }
}
