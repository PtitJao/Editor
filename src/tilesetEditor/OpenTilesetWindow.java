package tilesetEditor;

import javafx.stage.Modality;
import settings.Settings;
import util.Window;

public class OpenTilesetWindow extends Window<OpenTilesetController> {
    private String choosed = null;

    public void start() {
        String title = Settings.language.getWord("tilesetOpenTitle");

        super.start(title, "openicon16.png", getClass().getResource("openTilesetWindow.fxml"));

        controller.init(this);
        controller.reload(3);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void setChoosed(String choosed) {
        this.choosed = choosed;
    }

    public String getChoosed() {
        return choosed;
    }
}
