package beans;

import db.dao.DAOSingleton;
import db.dao.LabDAO;
import db.dao.SyllabusDAO;
import db.entities.StudentResult;
import db.entities.SyllabusElement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "students_results")
@RequestScoped
public class StudentsResultsBean {
    LabDAO labDAO;
    List<StudentResult> results;

    public StudentsResultsBean() {
        labDAO = DAOSingleton.getInstance().getLabDAO();
        try {
            this.results = labDAO.getStudentResults();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StudentResult> getResults() {
        return results;
    }

}
