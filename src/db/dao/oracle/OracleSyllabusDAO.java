package db.dao.oracle;

import db.dao.*;
import db.entities.Lab;
import db.entities.SyllabusElement;
import db.entities.User;
import db.entities.UserRole;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OracleSyllabusDAO implements SyllabusDAO{

    @Override
    public List<SyllabusElement> getSyllabus() throws SQLException {
        List<SyllabusElement> res = new LinkedList<>();
        ResultSet rs = null;
        try (Connection con = OracleDAOFactory.createConnection()
             ; Statement statement = con.createStatement()) {

            String query =
                    "SELECT * FROM LAB";
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                int maxMark = rs.getInt("MAX_MARK");
                res.add(new SyllabusElement(id, title, maxMark));
            }
            return res;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new SQLException(sqle);
        }
    }
}
