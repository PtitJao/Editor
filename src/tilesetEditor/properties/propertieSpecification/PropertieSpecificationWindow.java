package tilesetEditor.properties.propertieSpecification;

import javafx.stage.Modality;
import settings.Settings;
import util.Window;

import java.net.URL;

public abstract class PropertieSpecificationWindow<K extends PropertieSpecificationController> extends Window<K> {
    public void start(URL FXMLfile) {
        String title = Settings.language.getWord("propertiesSpecificationTitle");

        super.start(title, "modifPropertie.png", FXMLfile);

        controller.reload(3);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    public void close() {
        stage.close();
    }

    public static PropertieSpecificationWindow getWindow(String type) {
        PropertieSpecificationWindow window = null;

        switch (type) {
            case "bool":
                window = new PropertieBoolWindow();
                ((PropertieBoolWindow)window).start();
                break;
            case "string":
                window = new PropertieTextWindow();
                ((PropertieTextWindow)window).start();
                break;
            case "int":
                window = new PropertieSpinnerWindow<Integer>();
                ((PropertieSpinnerWindow)window).start(type);
                break;
            case "double":
                window = new PropertieSpinnerWindow<Double>();
                ((PropertieSpinnerWindow)window).start(type);
                break;
            case "char":
                window = new PropertieSpinnerWindow<Character>();
                ((PropertieSpinnerWindow)window).start(type);
                break;
        }

        return window;
    }
}
