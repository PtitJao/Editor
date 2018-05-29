package tilesetEditor.properties;

import javafx.stage.Modality;
import settings.Settings;
import util.Window;

public class PropertiesModifyWindow extends Window<PropertiesModifyController> {
    public void start() {
        String title = Settings.language.getWord("propertiesModifyTitle");

        super.start(title, "modifPropertie.png", getClass().getResource("propertiesModifyWindow.fxml"));

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
