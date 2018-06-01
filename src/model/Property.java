package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    public void bullshitSave(BufferedWriter bw) throws Exception {
        bw.write(name + "\n");
        bw.write(type + "\n");
        bw.write(specif.size() + "\n");

        for (PropertySpecification ps : specif)
            ps.bullshitSave(bw);
    }

    public static Property bullshitLoad(BufferedReader br) throws Exception {
        String name = br.readLine();
        String type = br.readLine();
        int size = Integer.parseInt(br.readLine());

        List<PropertySpecification> specs = new ArrayList<>();

        for (int i = 0; i < size; ++i)
            specs.add(PropertySpecification.bullshitLoad(br, type));

        Property p = new Property(type);
        p.setName(name);
        p.setSpecif(specs);

        return p;
    }
}
