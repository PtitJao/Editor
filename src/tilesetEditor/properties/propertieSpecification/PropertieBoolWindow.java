package tilesetEditor.properties.propertieSpecification;

public class PropertieBoolWindow extends PropertieSpecificationWindow<Boolean, PropertieBoolController> {
    public void start() {
        super.start(getClass().getResource("propertieBoolWindow.fxml"));

        controller.init(this);
    }
}
