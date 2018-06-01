package mapEditor;

import util.MyPanel;

public class PaletteTerrainPanel extends MyPanel<PaletteTerrainController> {
    public void load() {
        super.load(getClass().getResource("paletteTerrain.fxml"));

        controller.reload(3);
    }
}
