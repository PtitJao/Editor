package tilesetEditor.properties.propertieSpecification;

import javafx.stage.Modality;
import model.PropertySpecification;
import settings.Settings;
import util.Window;

import java.net.URL;

public abstract class PropertieSpecificationWindow<T, K extends PropertieSpecificationController> extends Window<K> {
    protected PropertySpecification<T> specif = null;

    public PropertieSpecificationWindow(PropertySpecification<T> specif) {
        this.specif = specif;
    }

    public void start(URL FXMLfile) {
        String title = Settings.language.getWord("propertiesSpecificationTitle");

        super.start(title, "modifPropertie.png", FXMLfile);

        controller.reload(3);
        controller.init(this);

        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public static PropertieSpecificationWindow getWindow(String type) {
        return getWindow(type, null);
    }

    public static PropertieSpecificationWindow getWindow(String type, PropertySpecification value) {
        PropertieSpecificationWindow window = null;

        switch (type) {
            case "bool":
                window = new PropertieBoolWindow(value);
                ((PropertieBoolWindow)window).start();
                break;
            case "string":
                window = new PropertieTextWindow(value);
                ((PropertieTextWindow)window).start();
                break;
            case "int":
                window = new PropertieSpinnerWindow<Integer>(value);
                ((PropertieSpinnerWindow)window).start(type);
                break;
            case "double":
                window = new PropertieSpinnerWindow<Double>(value);
                ((PropertieSpinnerWindow)window).start(type);
                break;
            case "char":
                window = new PropertieSpinnerWindow<Character>(value);
                ((PropertieSpinnerWindow)window).start(type);
                break;
        }

        return window;
    }

    public void setSpecif(PropertySpecification<T> specif) { this.specif = specif; }

    public PropertySpecification<T> getSpecif() {
        return specif;
    }
}
