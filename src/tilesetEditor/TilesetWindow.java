package tilesetEditor;

import util.Window;
import javafx.stage.Modality;
import settings.Settings;

public class TilesetWindow extends Window<TilesetController> {
    public static TilesetWindow INSTANCE;

    public void start() {
        String title = Settings.language.getWord("tilesetTitle");

        super.start(title, "tileditor.png", getClass().getResource("tilesetEditorWindow.fxml"));
        INSTANCE = this;

        controller.init();
        controller.reload(3);
        stage.setOnCloseRequest(e -> INSTANCE = null);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    @Override
    public void close() {
        super.close();
        INSTANCE = null;
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new TilesetWindow().start();
        else
            INSTANCE.requestFocus();
    }
}
