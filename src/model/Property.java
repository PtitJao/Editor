package model;

import java.util.ArrayList;
import java.util.List;

public class Property<T> {

    private String name = "";
    private String type;
    private List<PropertySpecification<T>> specif = new ArrayList<>();

    public Property(String type) {
        this.type = type;
    }

    public Property(Property<T> prop) {
        name = prop.name;

        for (PropertySpecification<T> ps : prop.getSpecif())
            specif.add(new PropertySpecification<T>(ps));
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

    public String getType() {
        return type;
    }

    public PropertySpecification findSpec(String name) {
        for (PropertySpecification ps : specif)
            if (ps.getName().equals(name))
                return ps;
        return null;
    }
}
