package beans;

import db.dao.DAOSingleton;
import db.dao.SyllabusDAO;
import db.entities.Lab;
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
    String labsStr;

    public SyllabusBean() {
        syllabusDAO = DAOSingleton.getInstance().getSyllabusDAO();
        try {
            this.labs = syllabusDAO.getSyllabus();
            labsStr = "";
            for (SyllabusElement l: labs) {
                labsStr += l.getTitle() + ", ";
            }
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

    public String editLab() {
        return "edit";
    }

    public String getLabsStr() {
        return labsStr;
    }

    public void setLabsStr(String labsStr) {
        this.labsStr = labsStr;
    }

    public void deleteLab(SyllabusElement lab) {
        try {
            syllabusDAO.deleteLab(lab);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
