package pl.kurs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Candy {

    private String name;
    private String type;
    private List<Kid> kids;

    public Candy(String name, String type) {
        this.name = name;
        this.type = type;
        this.kids = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Kid> getKids() {
        return kids;
    }

    public void setKids(List<Kid> kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", kids=" + kids +
                '}';
    }
}
