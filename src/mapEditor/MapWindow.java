package mapEditor;

import settings.Settings;
import util.Window;

public class MapWindow extends Window<MapController> {
    public static MapWindow INSTANCE;

    public void start() {
        String title = Settings.language.getWord("mapTitle");

        super.start(title, "mapeditor16.png", getClass().getResource("mapEditorWindow.fxml"));
        INSTANCE = this;

        controller.init();
        controller.reload(3);
        stage.setOnCloseRequest(e -> INSTANCE = null);

        stage.sizeToScene();
        stage.setMinWidth(1000);
        stage.setMinHeight(800);
        stage.show();
    }

    @Override
    public void reload(int value) {
        super.reload(value);
        Palette.INSTANCE.reload(value);
    }

    @Override
    public void close() {
        super.close();
        Palette.INSTANCE.close();
        INSTANCE = null;
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new MapWindow().start();
        else
            INSTANCE.requestFocus();
    }
}
