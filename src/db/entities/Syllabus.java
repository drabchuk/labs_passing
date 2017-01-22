package db.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 22.01.2017.
 */
public class Syllabus {

    private Group group;
    private List<SyllabusElement> shedule = new LinkedList<>();

    public Syllabus(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<SyllabusElement> getShedule() {
        return shedule;
    }

    public void addSubject(Subject subject, User teacher) {
        this.shedule.add(
                new SyllabusElement(subject, this.group, teacher)
        );
    }

}
