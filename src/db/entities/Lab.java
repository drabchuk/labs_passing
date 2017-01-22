package db.entities;

import java.util.List;

/**
 * Created by Денис on 21.01.2017.
 */
public class Lab {

    private String name;
    private Subject subject;
    private List<Question> questions;

    public Lab(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public Lab(String name, Subject subject, List<Question> questions) {
        this.name = name;
        this.subject = subject;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
