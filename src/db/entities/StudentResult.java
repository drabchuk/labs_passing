package db.entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 23.01.2017.
 */
public class StudentResult {

    private User student;
    private List<LabResult> results = new LinkedList<>();

    public StudentResult(User student) {
        this.student = student;
        this.results = results;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public List<LabResult> getResults() {
        return results;
    }

    public void addResult(LabResult labResult) {
        this.results.add(labResult);
    }
}
