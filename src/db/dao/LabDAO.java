package db.dao;

import db.entities.Lab;
import db.entities.StudentResult;
import db.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface LabDAO {

    Lab selectLabById(int id) throws SQLException;
    void passLab(User user, Lab lab) throws SQLException;
    List<StudentResult> getStudentResults() throws SQLException;

}
