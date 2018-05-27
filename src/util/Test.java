package util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mapEditor.MapWindow;
import settings.SettingsWindow;
import tilesetEditor.TilesetWindow;

public class Test {
    public void start() {
        Stage primaryStage = new Stage();
        VBox vbox = new VBox();

        Label label = new Label("Select a icon.window to open/test");

        HBox hBox = new HBox();

        Button worldEditorButton = new Button("World editor");
        worldEditorButton.setOnAction(e -> MapWindow.launchWindow());

        Button objectEditorButton = new Button("Object editor");
        objectEditorButton.setOnAction(e -> System.out.println("\"" + objectEditorButton.getText() + "\" is not implemented yet"));

        Button animationEditorButton = new Button("Animation editor");
        animationEditorButton.setOnAction(e -> System.out.println("\"" + animationEditorButton.getText() + "\" is not implemented yet"));

        Button settingsButton = new Button("Settings");
        settingsButton.setOnAction(e -> SettingsWindow.launchWindow());

        Button newMapButton = new Button("New map");
        newMapButton.setOnAction(e -> System.out.println("\"" + newMapButton.getText() + "\" is not implemented yet"));

        Button tilesetEditorButton = new Button("Tileset editor");
        tilesetEditorButton.setOnAction(e -> TilesetWindow.launchWindow());


        hBox.getChildren().addAll(worldEditorButton, objectEditorButton, animationEditorButton, settingsButton, newMapButton, tilesetEditorButton);

        vbox.getChildren().addAll(label, hBox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Testing windows");
        primaryStage.show();
    }
}
