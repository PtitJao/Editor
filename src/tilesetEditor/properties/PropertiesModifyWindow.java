package tilesetEditor.properties;

import javafx.stage.Modality;
import model.Property;
import settings.Settings;
import util.Window;

import java.util.List;

public class PropertiesModifyWindow<T> extends Window<PropertiesModifyController<T>> {
    private String type;

    public PropertiesModifyWindow(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void start() {
        start(null);
    }

    public void start(Property prop) {
        String title = Settings.language.getWord("propertiesModifyTitle");

        super.start(title, "modifPropertie.png", getClass().getResource("propertiesModifyWindow.fxml"));

        if (prop == null)
            controller.setProp(new Property<T>(type));
        else
            controller.setProp(prop);
        controller.init(this);
        controller.reload(3);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public Property getProp() {
        return controller.getProp();
    }

    public List<Integer> getRemove() {
        return controller.getRemove();
    }
}
