package model;

import java.util.ArrayList;
import java.util.List;

public class Property<T> {

    private String name;
    private List<PropertySpecification<T>> specif = new ArrayList<>();

    public Property() {
    }

    public Property(Property<T> prop) {
        this.name = prop.name;

        for (PropertySpecification<T> spec : prop.specif)
            specif.add(new PropertySpecification<T>(spec));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PropertySpecification<T>> getSpecif() {
        return specif;
    }

    public void setSpecif(List<PropertySpecification<T>> specif) {
        this.specif = specif;
    }
}
