package model;
import javafx.scene.paint.Color;

public class PropertySpecification<T> {

    private String name;
    private T value;
    private Color color;

    public PropertySpecification(String name, T value, Color color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public PropertySpecification(PropertySpecification<T> specif) {
        this.name = specif.name;
        this.value = specif.value;
        this.color = specif.color;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    public Color getColor() {
        return color;
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
