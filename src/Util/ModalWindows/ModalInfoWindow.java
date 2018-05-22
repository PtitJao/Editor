package Util.ModalWindows;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ModalInfoWindow extends ModalWindow {
    public ModalInfoWindow(String title, String message) {
        super("Info : " + title, "InfoIcon.png");

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10, 100, 10, 100));
        box.setSpacing(10);

        Label label = new Label(message);
        label.setTextAlignment(TextAlignment.CENTER);

        Button button = new Button("OK");
        button.setOnAction(e -> stage.close());

        box.getChildren().addAll(label, button);

        Scene scene = new Scene(box);
        stage.setScene(scene);

        start();
    }
}
