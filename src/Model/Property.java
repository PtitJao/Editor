package Model;

import java.util.List;

public class Property {

    private String name;
    private List<PropertySpecification> specif;

    public Property(String name, List<PropertySpecification> specif) {
        this.name = name;
        this.specif = specif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PropertySpecification> getSpecif() {
        return specif;
    }

    public void setSpecif(List<PropertySpecification> specif) {
        this.specif = specif;
    }
}
