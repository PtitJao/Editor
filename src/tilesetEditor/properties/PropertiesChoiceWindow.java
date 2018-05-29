package tilesetEditor.properties;

import javafx.stage.Modality;
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
        stage.show();
    }

    public void close() {
        stage.close();
    }
}
