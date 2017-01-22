package db.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Денис on 21.01.2017.
 */
public class Group {

    private String chifer;
    private List<Student> students = new LinkedList<>();
    private Student leader;

    public Group() {
    }

    public Group(String chifer, List<Student> students, Student leader) {
        this.chifer = chifer;
        this.students = students;
        this.leader = leader;
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public String getChifer() {
        return chifer;
    }

    public void setChifer(String chifer) {
        this.chifer = chifer;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }
}
