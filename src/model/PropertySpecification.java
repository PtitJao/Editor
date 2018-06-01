package model;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.BufferedWriter;

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

    public void bullshitSave(BufferedWriter bw) throws Exception {
        bw.write(name + "\n");
        bw.write(value + "\n");
        bw.write(color.getRed() + "\n");
        bw.write(color.getGreen() + "\n");
        bw.write(color.getBlue() + "\n");
        bw.write(color.getOpacity() + "\n");
    }

    public static PropertySpecification bullshitLoad(BufferedReader br, String type) throws Exception {
        String name = br.readLine();
        String value = br.readLine();
        Color color = new Color(Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()));

        switch (type) {
            case "int":
                return new PropertySpecification<Integer>(name, Integer.parseInt(value), color);
            case "double":
                return new PropertySpecification<Double>(name, Double.parseDouble(value), color);
            case "char":
                return new PropertySpecification<Character>(name, value.charAt(0), color);
            case "string":
                return new PropertySpecification<String>(name, value, color);
            case "bool":
                return new PropertySpecification<Boolean>(name, Boolean.parseBoolean(value), color);
        }

        return null;
    }
}
