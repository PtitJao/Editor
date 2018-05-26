package Model;
import javafx.scene.paint.Color;

public class PropertySpecification {

    private String name;
    private Tileset value;
    private Color   c;

    public PropertySpecification(String name, Tileset value, Color c) {
        this.name = name;
        this.value = value;
        this.c = c;
    }

    public void setValue(Tileset value) {
        this.value = value;
    }

    public void setC(Color c) {

        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public Tileset getValue() {

        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
