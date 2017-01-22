package db.dao.oracle;

import db.dao.OracleDAOFactory;
import db.dao.SubjectDAO;
import db.entities.Group;
import db.entities.Lab;
import db.entities.Student;
import db.entities.Subject;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 22.01.2017.
 */
public class OracleSubjectDAO implements SubjectDAO {

    @Override
    public Subject getSubject(String name) throws SQLException {
        Subject subject = new Subject(name);
        List<Lab> labs = new LinkedList<>();
        ResultSet rs = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT * FROM LAB WHERE SUBJECT_FK = ?"
                     )) {

            rs = ps.executeQuery();
            while (rs.next()) {
                labs.add(new Lab(rs.getString("TITLE"), subject));
            }
            return subject;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }
    }

}
