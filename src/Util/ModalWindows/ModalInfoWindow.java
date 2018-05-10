package Util.ModalWindows;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ModalInfoWindow extends ModalWindow {
    public ModalInfoWindow(String title, String message) {
        super("Info : " + title, "InfoIcon.png");

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);

        Button button = new Button("OK");
        button.setOnAction(e -> stage.close());

        box.getChildren().addAll(new Label(message), button);

        Scene scene = new Scene(box);
        stage.setScene(scene);

        start();
    }
}
