package model;
import javafx.scene.paint.Color;

public class PropertySpecification<T> {

    private String name;
    private T value;
    private Color   c;

    public PropertySpecification(String name, T value, Color c) {
        this.name = name;
        this.value = value;
        this.c = c;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setC(Color c) {

        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
