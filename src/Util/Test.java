package Util;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import settings.SettingsWindow;

public class Test {
    public void start() {
        Stage primaryStage = new Stage();
        VBox vbox = new VBox();

        Label label = new Label("Select a window to open/test");

        HBox hBox = new HBox();

        Button worldEditorButton = new Button("World editor");
        worldEditorButton.setGraphic(new ImageView(Util.loadImage("mapeditor.png")));
        worldEditorButton.setOnAction(e -> System.out.println("\"" + worldEditorButton.getText() + "\" is not implemented yet"));

        Button objectEditorButton = new Button("Object editor");
        objectEditorButton.setGraphic(new ImageView(Util.loadImage("gameobjeteditor.png")));
        objectEditorButton.setOnAction(e -> System.out.println("\"" + objectEditorButton.getText() + "\" is not implemented yet"));

        Button animationEditorButton = new Button("Animation editor");
        animationEditorButton.setGraphic(new ImageView(Util.loadImage("animeditor.png")));
        animationEditorButton.setOnAction(e -> System.out.println("\"" + animationEditorButton.getText() + "\" is not implemented yet"));

        Button settingsButton = new Button("Settings");
        settingsButton.setGraphic(new ImageView(Util.loadImage("preferencesicon.png")));
        settingsButton.setOnAction(e -> SettingsWindow.launchWindow());

        Button newMapButton = new Button("New map");
        newMapButton.setGraphic(new ImageView(Util.loadImage("newfileicon1.png")));
        newMapButton.setOnAction(e -> System.out.println("\"" + newMapButton.getText() + "\" is not implemented yet"));

        Button tilesetEditorButton = new Button("Tileset editor");
        tilesetEditorButton.setGraphic(new ImageView(Util.loadImage("tileditor.png")));
        tilesetEditorButton.setOnAction(e -> System.out.println("\"" + tilesetEditorButton.getText() + "\" is not implemented yet"));


        hBox.getChildren().addAll(worldEditorButton, objectEditorButton, animationEditorButton, settingsButton, newMapButton, tilesetEditorButton);

        vbox.getChildren().addAll(label, hBox);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Testing windows");
        primaryStage.show();
    }
}
