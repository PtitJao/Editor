package tilesetEditor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Property;
import model.PropertySpecification;

import java.util.ArrayList;
import java.util.List;

public class TileDisplay extends StackPane {
    private Image img;
    private Rectangle select;
    private Rectangle rect;
    private List<Integer> properties = new ArrayList<>();

    private Integer iProp;
    private Integer iSpec;

    public TileDisplay(Image img, Integer iProp, Integer iSpec) {
        this.img = img;
        this.iProp = iProp;
        this.iSpec = iSpec;

        ImageView iw = new ImageView(img);
        iw.setPreserveRatio(true);
        iw.setFitWidth(getWidth());

        getChildren().add(iw);

        select = new Rectangle(getWidth(), getHeight());
        select.setFill(new Color(1,1,1,0.3));

        rect = new Rectangle(getWidth(), getHeight());
        rect.setFill(new Color(1,1,1,0));

        getChildren().add(rect);

        setOnMouseEntered(e -> getChildren().add(select));
        setOnMouseExited(e -> getChildren().remove(select));
        setOnMouseClicked(e -> click());
    }

    public void click() {
        if (iProp != -1 && iSpec != -1) {
            properties.set(iProp, iSpec);
        }
    }

    public void addProperty() {
        properties.add(0);
    }

    public void removeProperty(int prop) {
        properties.remove(prop);
    }

    public void removeSpec(int prop, int spec) {
        if (properties.get(prop) == spec)
            properties.set(prop, 0);
        else if (properties.get(prop) > spec)
            properties.set(prop, properties.get(prop) - 1);
    }

    public void displayPropertie(int index, Property prop) {
        PropertySpecification ps = (PropertySpecification)prop.getSpecif().get(properties.get(index));
        Color c = ps.getColor();
        rect.setFill(new Color(c.getRed(), c.getGreen(), c.getBlue(), 0.5));
    }

    public void displayNoPropertie() {
        rect.setFill(new Color(1,1,1,0));
    }
}
