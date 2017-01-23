package db.entities;

import java.util.List;

public class Lab {

    private int id;
    private String name;
    private List<Question> questions;
    private int maxMark;
    private int rightAnswers = 0;
    private int totalAnswers = 1;
    private int result;

    public Lab(String name) {
        this.name = name;
    }

    public Lab(int id, String name, int maxMark) {
        this.id = id;
        this.name = name;
        this.maxMark = maxMark;
    }

    public Lab(int id, String name, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.totalAnswers = questions.size();
    }

    public Lab(int id, String name, List<Question> questions, int maxMark) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.totalAnswers = questions.size();
        this.maxMark = maxMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        totalAnswers = questions.size();
    }

    public int check() {
        rightAnswers = 0;
        for (Question q: questions) {
            if (q.right()) {
                rightAnswers++;
            }
        }
        try {
            result = (rightAnswers * maxMark) / totalAnswers;
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int getResult() {
        return result;
    }
}
