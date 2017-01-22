package db.entities;

/**
 * Created by Денис on 21.01.2017.
 */
public class Question {

    private int num;
    private String content;
    private String answer;

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
}
