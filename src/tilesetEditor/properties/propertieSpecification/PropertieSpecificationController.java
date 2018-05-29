package tilesetEditor.properties.propertieSpecification;

import util.Controller;

public abstract class PropertieSpecificationController extends Controller {
    protected PropertieSpecificationWindow window;

    public void init(PropertieSpecificationWindow window) {
        this.window = window;
    }
}
