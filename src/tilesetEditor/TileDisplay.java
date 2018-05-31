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

    private Selection selection;

    public TileDisplay(Image img, Selection selection, double width, double height) {
        setPrefSize(width, height);

        this.img = img;
        this.selection = selection;

        ImageView iw = new ImageView(img);
        iw.setPreserveRatio(true);
        iw.setFitWidth(getWidth());

        getChildren().add(iw);

        select = new Rectangle(width, height);
        select.setFill(new Color(1,1,1,0.3));

        rect = new Rectangle(width, height);
        rect.setFill(new Color(1,1,1,0));

        getChildren().add(rect);

        setOnMouseEntered(e -> {
            getChildren().add(select);
            if (e.isPrimaryButtonDown())
                click();
        });
        setOnMouseExited(e -> getChildren().remove(select));

        setOnMouseClicked(e -> click());
        setOnMouseDragged(e -> click());
        setOnMouseDragOver(e -> click());
        setOnMouseDragEntered(e -> click());
        setOnMousePressed(e -> click());
    }

    public void click() {
        if (selection.iProp != -1 && selection.iSpec != -1) {
            properties.set(selection.iProp, selection.iSpec);
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

    public void displayPropertie(Property prop) {
        PropertySpecification ps = (PropertySpecification)prop.getSpecif().get(properties.get(selection.iProp));
        Color c = ps.getColor();
        rect.setFill(new Color(c.getRed(), c.getGreen(), c.getBlue(), 0.7));
    }

    public void displayNoPropertie() {
        rect.setFill(new Color(1,1,1,0));
    }

    public List<Integer> getProps() {
        return properties;
    }

    public void setProps(List<Integer> props) {
        properties = new ArrayList<>();

        for (Integer i : props)
            properties.add(new Integer(i));
    }
}
