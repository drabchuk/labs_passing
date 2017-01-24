package db.dao.oracle;

import beans.UserBean;
import db.dao.DAOSingleton;
import db.dao.LabDAO;
import db.dao.OracleDAOFactory;
import db.entities.*;

import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OracleLabDAO implements LabDAO {

    @Override
    public Lab selectLabById(int id) throws SQLException {
        List<Question> questions = new LinkedList<>();
        ResultSet rs = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; Statement statement = con.createStatement()) {

            String query =
                    "SELECT * FROM QUESTION WHERE LAB_FK = " + id;
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int num = rs.getInt("QUESTION_NUM");
                String content = rs.getString("CONTENT");
                String answer = rs.getString("ANSWER");
                questions.add(new Question(num, content, answer));
            }
            query =
                    "SELECT TITLE, MAX_MARK FROM LAB WHERE ID = " + id;
            rs = statement.executeQuery(query);
            String title = "";
            int maxMark = 0;
            if (rs.next()) {
                title = rs.getString("TITLE");
                maxMark = rs.getInt("MAX_MARK");
            }
            return new Lab(id, title, questions, maxMark);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }
    }

    @Override
    public void passLab(User user, Lab lab) throws SQLException {
        try (Connection con = OracleDAOFactory.createConnection()
             ; CallableStatement cs = con.prepareCall(
                     "{CALL PASS_LAB(?, ?, ?)}"
        )) {
            cs.setString(1,user.getEmail());
            cs.setInt(2, lab.getId());
            cs.setInt(3, lab.getResult());
            cs.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }
    }

    @Override
    public StudentResult getDinary() throws SQLException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        UserBean userBean = (UserBean)
                facesContext.getApplication()
                        .createValueBinding("#{user}").getValue(facesContext);
        User student = userBean.getUser();
        StudentResult studentResult = new StudentResult(student);
        ResultSet rs = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT ID, TITLE, MAX_MARK, MARK FROM PASSED_LAB JOIN LAB ON LAB.ID = PASSED_LAB.LAB_FK WHERE STUDENT_FK = ?"
                     )) {
            ps.setString(1, student.getEmail());
            LabResult labResult;
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                int maxMark = rs.getInt("MAX_MARK");
                int mark = rs.getInt("MARK");
                Lab lab = new Lab(id, title, maxMark);
                studentResult.addResult(new LabResult(lab, mark));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }

        return studentResult;
    }

    @Override
    public List<StudentResult> getStudentResults() throws SQLException {
        List<StudentResult> results = new LinkedList<>();

        ResultSet rs = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT ID, TITLE, MAX_MARK, MARK FROM PASSED_LAB JOIN LAB ON LAB.ID = PASSED_LAB.LAB_FK WHERE STUDENT_FK = ?"
                     )) {
            List<User> students = DAOSingleton.getInstance().getUserDAO().selectStudents();
            for (User student: students) {
                ps.setString(1, student.getEmail());
                StudentResult studentResult = new StudentResult(student);
                LabResult labResult;
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String title = rs.getString("TITLE");
                    int maxMark = rs.getInt("MAX_MARK");
                    int mark = rs.getInt("MARK");
                    Lab lab = new Lab(id, title, maxMark);
                    studentResult.addResult(new LabResult(lab, mark));
                }
                results.add(studentResult);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }

        return results;
    }
}
