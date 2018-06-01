package mapEditor;

import javafx.stage.Modality;
import settings.Settings;
import util.Window;

public class NewMapWindow extends Window<NewMapController> {
    public MapDisplay map;

    public void start() {
        String title = Settings.language.getWord("newMapTitle");

        super.start(title, "newfileicon16.png", getClass().getResource("newMapWindow.fxml"));

        controller.init(this);
        controller.reload(3);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void setMap(MapDisplay map) {
        this.map = map;
    }

    public MapDisplay getMap() {
        return map;
    }
}
