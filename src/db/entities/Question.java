package db.entities;

public class Question {

    private int num;
    private String content;
    private String answer;
    private String userAnswer;

    public Question(int num, String content, String answer) {
        this.num = num;
        this.content = content;
        this.answer = answer;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean right() {
        return this.answer.equals(userAnswer);
    }

}
