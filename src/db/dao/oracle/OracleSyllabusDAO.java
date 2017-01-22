package db.dao.oracle;

import db.dao.*;
import db.entities.Group;
import db.entities.Student;
import db.entities.Syllabus;
import db.entities.SyllabusElement;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 22.01.2017.
 */
public class OracleSyllabusDAO implements SyllabusDAO{

    SubjectDAO subjectDAO = DAOSingleton.getInstance().getSubjectDAO();
    UserDAO userDAO = DAOSingleton.getInstance().getUserDAO();

    @Override
    public Syllabus getSyllabusByGroup(Group group) throws SQLException {
        Syllabus syllabus = new Syllabus(group);
        ResultSet rs = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT subject_fk, teacher_fk FROM syllabus WHERE GROUP_FK = ?"
                     )) {
            ps.setString(1, group.getChifer());
            rs = ps.executeQuery();
            while (rs.next()) {
                syllabus.addSubject(
                        subjectDAO.getSubject(rs.getString("SUBJECT_FK")),
                        userDAO.selectUserByEmail(rs.getString("TEACHER_FK"))
                );
            }
            return syllabus;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }
    }
}
