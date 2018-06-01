package mapEditor;

import javafx.stage.Modality;
import javafx.stage.StageStyle;
import settings.Settings;
import util.Window;

public class Palette extends Window<PaletteController> {
    public static Palette INSTANCE;

    public void start() {
        String title = Settings.language.getWord("palette");

        super.start(title, "palette.png", getClass().getResource("palette.fxml"));
        INSTANCE = this;

        controller.init();
        controller.reload(3);
        stage.sizeToScene();

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UTILITY);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.show();
    }

    public void close() {
        super.close();
        INSTANCE = null;
    }

    public static void launchWindow() {
        if (INSTANCE == null)
            new Palette().start();
        else
            INSTANCE.requestFocus();
    }
}
