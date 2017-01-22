package db.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Денис on 21.01.2017.
 */
public class Subject {

    private String name;
    private List<Lab> labs = new LinkedList<>();

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, List<Lab> labs) {
        this.name = name;
        this.labs = labs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }
}
