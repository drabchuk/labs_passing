package db.dao.oracle;

import db.dao.GroupDAO;
import db.dao.OracleDAOFactory;
import db.entities.Group;
import db.entities.Student;
import db.entities.User;
import db.entities.UserRole;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Denis on 22.01.2017.
 */
public class OracleGroupDAO implements GroupDAO {

    @Override
    public List<Group> getAllGroups() throws SQLException{
        List<Group> groups = new LinkedList<>();
        ResultSet rs = null;
        ResultSet rs2 = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; Statement statement = con.createStatement()
                ; PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT usr.email, first_name, second_name FROM usr JOIN student ON usr.email = student.email WHERE GROUP_FK = ?"
                     )) {

            String query = "SELECT * FROM STD_GROUP";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Group group = new Group();
                String chipher = rs.getString("CHIPHER");
                group.setChifer(chipher);
                ps.setString(1, chipher);
                rs2 = ps.executeQuery();
                while (rs2.next()) {
                    String email = rs2.getString("email");
                    String firstName = rs2.getString("first_name");
                    String secondName = rs2.getString("second_name");
                    Student s = new Student(email, firstName, secondName, group);
                    group.addStudent(s);
                }
                groups.add(group);
            }
            return groups;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }
    }
}
