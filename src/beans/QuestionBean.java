package beans;

import db.dao.DAOSingleton;
import db.dao.LabDAO;
import db.entities.Lab;
import db.entities.Question;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

@ManagedBean(name = "question_bean")
@ViewScoped
public class QuestionBean {

    private LabDAO labDAO;
    private int id;
    private String content;
    private String answer;

    public QuestionBean() {
        labDAO = DAOSingleton.getInstance().getLabDAO();
    }

    public void save(Lab lab) {
        try {
            labDAO.addNewQuestion(lab.getId(), new Question(id, content, answer));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
