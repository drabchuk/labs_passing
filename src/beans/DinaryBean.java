package beans;

import db.dao.DAOSingleton;
import db.dao.LabDAO;
import db.entities.StudentResult;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

@ManagedBean(name = "dinary")
@ViewScoped
public class DinaryBean {

    private LabDAO labDAO;
    private StudentResult studentResult;

    public DinaryBean() {
        labDAO = DAOSingleton.getInstance().getLabDAO();
        try {
            studentResult = labDAO.getDinary();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StudentResult getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(StudentResult studentResult) {
        this.studentResult = studentResult;
    }
}
