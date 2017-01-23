package beans;

import db.dao.DAOSingleton;
import db.dao.SyllabusDAO;
import db.entities.SyllabusElement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "syllabus")
@RequestScoped
public class SyllabusBean {
    SyllabusDAO syllabusDAO;
    List<SyllabusElement> labs;

    public SyllabusBean() {
        syllabusDAO = DAOSingleton.getInstance().getSyllabusDAO();
        try {
            this.labs = syllabusDAO.getSyllabus();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SyllabusElement> getLabs() {
        return labs;
    }

    public String selectLab() {
        return "select";
    }

}
