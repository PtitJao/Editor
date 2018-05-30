package tilesetEditor.properties;

import javafx.stage.Modality;
import model.Property;
import settings.Settings;
import util.Window;

public class PropertiesChoiceWindow extends Window<PropertiesChoiceController> {
    public void start() {
        String title = Settings.language.getWord("propertiesCreateTitle");

        super.start(title, "createPropertie.png", getClass().getResource("propertiesChoiceWindow.fxml"));

        controller.init(this);
        controller.reload(3);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public Property getProp() {
        return controller.getProp();
    }
}
