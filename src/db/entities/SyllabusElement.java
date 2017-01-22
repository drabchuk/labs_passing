package db.entities;

/**
 * Created by Denis on 22.01.2017.
 */
public class SyllabusElement {

    private Subject subject;
    private Group group;
    private User teacher;

    public SyllabusElement(Subject subject, Group group, User teacher) {
        this.subject = subject;
        this.group = group;
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
